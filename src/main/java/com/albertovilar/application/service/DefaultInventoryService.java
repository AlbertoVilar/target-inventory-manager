package com.albertovilar.application.service;

import com.albertovilar.application.contracts.InventoryService;
import com.albertovilar.domain.model.Movement;
import com.albertovilar.domain.model.StockItem;

import java.util.List;

public class DefaultInventoryService implements InventoryService {
    @Override
    public void loadInitialInventory(List<StockItem> items) {

    }

    @Override
    public StockItem findByProductCode(int productCode) {
        return null;
    }

    @Override
    public int applyMovement(Movement movement) {
        return 0;
    }
}
