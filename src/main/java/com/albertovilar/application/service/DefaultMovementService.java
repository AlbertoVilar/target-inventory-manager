package com.albertovilar.application.service;

import com.albertovilar.application.contracts.MovementService;
import com.albertovilar.domain.model.Movement;
import com.albertovilar.domain.model.MovementType;

public class DefaultMovementService implements MovementService {
    @Override
    public Movement registerMovement(int productCode, String description, int quantity, MovementType type) {
        return null;
    }

    @Override
    public int processMovement(Movement movement) {
        return 0;
    }
}
