package com.albertovilar.infrastructure.adapter;

import com.albertovilar.domain.model.InventoryWrapper;
import com.albertovilar.domain.model.StockItem;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<StockItem> readStockItems(String path) throws IOException {
        File file = new File(path);
        InventoryWrapper wrapper = objectMapper.readValue(file, InventoryWrapper.class);
        return wrapper.getStockItems();
    }
}
