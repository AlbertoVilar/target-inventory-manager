package com.albertovilar.application.service;

import com.albertovilar.application.contracts.MovementService;
import com.albertovilar.application.contracts.InventoryService;
import com.albertovilar.domain.model.Movement;
import com.albertovilar.domain.model.MovementType;

public class DefaultMovementService implements MovementService {

    private final InventoryService inventoryService;

    public DefaultMovementService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public Movement registerMovement(int productCode,
                                     String description,
                                     int quantity,
                                     MovementType type) {
        return new Movement(
                productCode,
                description,
                quantity,
                type
        );
    }

    @Override
    public int processMovement(Movement movement) {
        return inventoryService.applyMovement(movement);
    }
}
