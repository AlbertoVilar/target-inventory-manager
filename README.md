<h1 align="center">🗃️ Target Inventory Manager</h1>

<p align="center">
  Sistema de movimentação de estoque desenvolvido para o Desafio Técnico da <strong>Target Sistemas</strong>.
 </p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-3.9-blue?style=for-the-badge&logo=apachemaven" />
  <img src="https://img.shields.io/badge/Jackson-2.17-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Status-Finalizado-success?style=for-the-badge" />
</p>

---

## 📚 Sumário

- [📌 Sobre o Projeto](#-sobre-o-projeto)
- [🚀 Funcionalidades](#-funcionalidades)
- [🧱 Arquitetura](#-arquitetura)
- [📦 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [📂 Estrutura do JSON](#-estrutura-do-json)
- [▶️ Como Executar](#️-como-executar)
- [🎮 Exemplo de Execução](#-exemplo-de-execução)
- [👨‍💻 Autor](#-autor)

---

## 📌 Sobre o Projeto

Este sistema permite realizar **movimentação de estoque** com base em um arquivo JSON inicial.  
O usuário pode registrar **entradas** e **saídas** de produtos e obter o estoque final atualizado.

O projeto foi desenvolvido seguindo:

- Arquitetura em camadas  
- Princípios do SOLID (SRP, DIP)  
- Clean code  
- Simplicidade e clareza, como esperado em um desafio júnior  

---

## 🚀 Funcionalidades

### ✔ Leitura de estoque via JSON  
- Realizada através da classe `JsonReader`  
- Uso de `@JsonProperty` para mapear nomes diferentes do JSON  

### ✔ Movimentações permitidas  
- **Entrada (increase stock)**  
- **Saída (decrease stock)**  
- Validações completas  

### ✔ Estrutura da movimentação  
- UUID automático  
- Descrição da operação  
- Tipo da operação  
- Data/hora  
- Quantidade  

### ✔ Validações importantes  
- Produto não encontrado  
- Estoque insuficiente  
- Quantidade inválida  

### ✔ Execução amigável no console  
Interface de texto usando `Scanner`.

---

## 🧱 Arquitetura

```
src/main/java/com/albertovilar/
│
├── app/ → Classe Application (main)
│
├── application/
│   ├── contracts/ → Interfaces de serviço (DIP)
│   └── service/ → Implementações concretas (SRP)
│
├── domain/
│   └── model/ → Entidades do domínio
│
└── infrastructure/
    └── adapter/ → JsonReader (camada de dados)
```

### Entidades principais

| Classe                | Função                         |
|-----------------------|--------------------------------|
| **StockItem**         | Representa um produto em estoque |
| **Movement**          | Movimento de entrada ou saída   |
| **MovementType**      | Enum: Entrada / Saída            |
| **InventoryWrapper**  | Wrapper do JSON de entrada       |

### Serviços

| Serviço                     | Responsabilidade                    |
|-----------------------------|-------------------------------------|
| **DefaultInventoryService** | Controle do estoque                 |
| **DefaultMovementService**  | Criação e execução de movimentações |

---

## 📦 Tecnologias Utilizadas

- ☕ **Java 21**
- 📦 **Maven**
- 📘 **Jackson Databind**
- 🎯 **Princípios SOLID**
- 🧱 Arquitetura modular

---

## 📂 Estrutura do JSON

Arquivo: `src/main/resources/inventory.json`

```json
{
  "estoque": [
    {
      "codigoProduto": 101,
      "descricaoProduto": "Caneta Azul",
      "estoque": 150
    },
    {
      "codigoProduto": 102,
      "descricaoProduto": "Caderno Universitário",
      "estoque": 75
    },
    {
      "codigoProduto": 103,
      "descricaoProduto": "Borracha Branca",
      "estoque": 200
    },
    {
      "codigoProduto": 104,
      "descricaoProduto": "Lápis Preto HB",
      "estoque": 320
    },
    {
      "codigoProduto": 105,
      "descricaoProduto": "Marcador de Texto Amarelo",
      "estoque": 90
    }
  ]
}
```

## ▶️ Como Executar

🔧 1. Clonar o repositório

```
git clone https://github.com/albertovilar/target-inventory-manager.git
```

📁 2. Entrar no diretório

```
cd target-inventory-manager
```

▶️ 3. Executar o projeto

```
mvn clean compile exec:java
```

Ou:

✔ Rodar a Application na sua IDE (IntelliJ, Eclipse, VS Code)

---

## 🎮 Exemplo de Execução

🧾 Entrada

```
=== Movimentação de Estoque ===
Digite o código do produto: 101
Descrição da movimentação: Saída para cliente.
Quantidade movimentada: 50
Tipo de operação (1 = Entrada, 2 = Saída): 2
```

✅ Saída

```
Movimentação realizada com sucesso!
Produto: 101
Operação: Saída
Quantidade final em estoque: 100
```

❌ Caso de erro

```
Erro ao realizar movimentação: Estoque insuficiente para saída.
Estoque atual: 150, solicitado: 200
```

---

## 👨‍💻 Autor

Alberto Villar  
Desenvolvedor Java Backend

📧 Email: albertovialr1@gmail.com  
🔗 LinkedIn: https://www.linkedin.com/in/albertovilar1  
🐙 GitHub: https://github.com/albertovilar  

<h3 align="center">💼 Projeto finalizado e pronto para avaliação!</h3>
