package com.albertovilar.domain.model;

import java.util.UUID;

public class StockItem {

    private int productCode;
    private String description;
    private int stock;

    public StockItem() {}

    public StockItem(int productCode, String description, int stock) {
        this.productCode = productCode;
        this.description = description;
        this.stock = stock;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
