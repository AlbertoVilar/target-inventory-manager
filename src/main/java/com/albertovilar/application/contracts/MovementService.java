package com.albertovilar.application.contracts;

import com.albertovilar.domain.model.Movement;
import com.albertovilar.domain.model.MovementType;

public interface MovementService {

    Movement registerMovement(int productCode, String description, int quantity, MovementType type);

    int processMovement(Movement movement);

}
