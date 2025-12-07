package com.albertovilar.application.contracts;

import com.albertovilar.domain.model.Movement;
import com.albertovilar.domain.model.StockItem;

import java.util.List;

public interface InventoryService {

    void loadInitialInventory(List<StockItem> items);

    StockItem findByProductCode(int productCode);

    int applyMovement(Movement movement);

}
