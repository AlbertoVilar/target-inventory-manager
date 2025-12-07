package com.albertovilar.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Movement {

    private UUID id;
    private int productCode;
    private String description;
    private int quantity;
    private MovementType type;
    private LocalDateTime date;

    public Movement() {}

    public Movement(int productCode, String description, int quantity, MovementType type) {
        this.id = UUID.randomUUID();
        this.productCode = productCode;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
        this.date = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public int getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public MovementType getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
