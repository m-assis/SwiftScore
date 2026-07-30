# 🎵 SwiftScore - Avaliador e Ranking de Músicas de Album

O **SwiftScore** é uma aplicação Java de console desenvolvida para gerenciar, avaliar e ordenar faixas de álbuns musicais em tempo real. O projeto simula um sistema de avaliação de mídia aplicando conceitos fundamentais da Programação Orientada a Objetos (POO) e manipulação de dados em memória.

---

## 🚀 Funcionalidades

- **Menu Interativo:** Navegação via console para escolha de ações (Avaliar, Ver Ranking, Sair).
- **Avaliação de Faixas:** Permite registrar notas decimais (0 a 10) para cada música.
- **Cálculo Dinâmico de Média:** Acumula avaliações e calcula a nota média sem redundância de dados.
- **Ranking em Tempo Real:** Ordenação dinâmica das faixas avaliadas da maior para a menor média utilizando `Comparator` e *Method References*.

---

## 🛠️ Conceitos Técnicos Aplicados

- **Orientação a Objetos (POO):**
  - **Herança:** A classe `Musica` herda características e comportamentos da classe base `Audio`.
  - **Encapsulamento:** Atributos protegidos por modificadores `private` e acessados via `getters` e `setters`.
  - **Polimorfismo:** Sobrescrita de método (`@Override`) para comportamento específico ao reproduzir uma música.
- **Estrutura de Dados:** Uso de `List` e `ArrayList` para manipulação dinâmica de coleções em memória.
- **Programação Defensiva:** Trata potenciais exceções de divisão por zero no cálculo de médias quando a quantidade de avaliações é zero.
- **Modularização:** Separação clara de responsabilidades entre o fluxo principal do programa e métodos auxiliares.

---

## 💻 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/lucasneves55/SwiftScore.git](https://github.com/lucasneves55/SwiftScore.git)
