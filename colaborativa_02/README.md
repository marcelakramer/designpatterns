# Padrões de Projeto Utilizados

## 1. **Padrão Builder**

**Descrição:**
O padrão Builder é utilizado para a construção de objetos complexos. Neste projeto, ele é aplicado para construir diferentes tipos de baralhos, como o Tradicional e o Uno.

**Justificativa:**
- **Flexibilidade na Construção:** Permite a criação de diferentes variações de baralhos (Tradicional e Uno) sem modificar o código de construção dos baralhos. Cada tipo de baralho pode ter uma configuração diferente de cartas, valores e ações.
- **Separation of Concerns:** Separa a construção do baralho do seu uso, facilitando a manutenção e a escalabilidade. Cada builder (`BaralhoTradicionalBuilder` e `BaralhoUnoBuilder`) é responsável apenas por seu tipo específico de baralho.
- **Modularidade:** Facilita a adição de novos tipos de baralhos no futuro, bastando implementar novos builders.

**Implementação:**
- **`BaralhoBuilder`**: Interface com métodos para construir um baralho.
- **`BaralhoTradicionalBuilder`** e **`BaralhoUnoBuilder`**: Implementações específicas para baralhos Tradicional e Uno, respectivamente.
- **`Diretor`**: Controla o processo de construção do baralho usando o builder apropriado.

## 2. **Padrão Factory (Simple Factory)**

**Descrição:**
O padrão Factory é utilizado para criar instâncias de objetos sem expor a lógica de criação ao cliente. No projeto, ele é usado para criar objetos de cartas (`CartaTradicional` e `CartaUno`).

**Justificativa:**
- **Encapsulamento da Criação:** Centraliza a lógica de criação de cartas, permitindo adicionar novos tipos de cartas sem alterar o código que utiliza essas cartas.
- **Facilidade de Extensão:** Facilita a introdução de novos tipos de cartas ou baralhos sem necessidade de alterar o código de construção de cartas.
- **Consistência:** Garante que as cartas sejam criadas de maneira consistente, seguindo as regras definidas para cada tipo de carta.

**Implementação:**
- **`CartaFactory`**: Fornece um método estático para criar instâncias de `CartaTradicional` e `CartaUno` com base no tipo de carta especificado.
- **`TipoCarta`**: Enum que define os tipos de cartas que podem ser criadas pela fábrica.
