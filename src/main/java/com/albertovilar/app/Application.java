package com.albertovilar.app;

import com.albertovilar.application.service.DefaultInventoryService;
import com.albertovilar.application.service.DefaultMovementService;
import com.albertovilar.domain.model.StockItem;
import com.albertovilar.domain.model.Movement;
import com.albertovilar.domain.model.MovementType;
import com.albertovilar.infrastructure.adapter.JsonReader;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        JsonReader jsonReader = new JsonReader();
        DefaultInventoryService inventoryService = new DefaultInventoryService();
        DefaultMovementService movementService = new DefaultMovementService(inventoryService);

        try {
            // 1) Ler o JSON
            List<StockItem> items = jsonReader.readStockItems("src/main/resources/inventory.json");

            // 2) Carregar o estoque
            inventoryService.loadInitialInventory(items);

            System.out.println("=== Movimentação de Estoque ===");

            // 3) entrada do usuário
            System.out.print("Digite o código do produto: ");
            int productCode = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            System.out.print("Descrição da movimentação: ");
            String description = scanner.nextLine();

            System.out.print("Quantidade movimentada: ");
            int quantity = scanner.nextInt();

            System.out.print("Tipo de movimentação (1 = Entrada, 2 = Saída): ");
            int typeOption = scanner.nextInt();

            MovementType type =
                    (typeOption == 1) ? MovementType.ENTRADA : MovementType.SAIDA;

            // 4) Registrar movimentação
            Movement movement = movementService.registerMovement(
                    productCode,
                    description,
                    quantity,
                    type
            );

            // 5) Processar movimentação
            int finalStock = movementService.processMovement(movement);

            // 6) Exibir o resultado
            System.out.println("\nMovimentação realizada com sucesso!");
            System.out.println("Produto: " + productCode);
            System.out.println("Tipo: " + type);
            System.out.println("Quantidade final em estoque: " + finalStock);

        } catch (Exception e) {
            System.err.println("Erro ao realizar movimentação: " + e.getMessage());
        }

        scanner.close();
    }
}
