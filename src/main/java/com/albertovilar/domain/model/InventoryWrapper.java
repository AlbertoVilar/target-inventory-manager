package com.albertovilar.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class InventoryWrapper {

    @JsonProperty("estoque")
    private List<StockItem> stockItems;

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItem> stockItems) {
        this.stockItems = stockItems;
    }
}
