package com.albertovilar.application.service;

import com.albertovilar.application.contracts.InventoryService;
import com.albertovilar.domain.model.Movement;
import com.albertovilar.domain.model.MovementType;
import com.albertovilar.domain.model.StockItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultInventoryService implements InventoryService {

    private final Map<Integer, StockItem> inventory = new HashMap<>();

    @Override
    public void loadInitialInventory(List<StockItem> items) {
        if (items == null) return;

        for (StockItem item : items) {
            inventory.put(item.getProductCode(), item);
        }
    }

    @Override
    public StockItem findByProductCode(int productCode) {
        return inventory.get(productCode);
    }

    @Override
    public int applyMovement(Movement movement) {

        StockItem item = inventory.get(movement.getProductCode());

        if (item == null) {
            throw new IllegalArgumentException("Produto não encontrado: " + movement.getProductCode());
        }

        int currentStock = item.getStock();
        int quantity = movement.getQuantity();

        if (movement.getType() == MovementType.ENTRADA) {
            currentStock += quantity;
        } else if (movement.getType() == MovementType.SAIDA) {
            if (quantity > currentStock) {
                throw new IllegalArgumentException(
                        "Estoque insuficiente para saída. Estoque atual: "
                                + currentStock + ", solicitado: " + quantity
                );
            }
            currentStock -= quantity;
        }

        item.setStock(currentStock);
        return currentStock;
    }
}
