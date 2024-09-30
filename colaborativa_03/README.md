# Padrões Utilizados
### Singleton (Aplicado na classe Elevator)
- Descrição: O padrão Singleton foi utilizado para garantir que exista apenas uma instância do elevador em todo o sistema.
- Justificativa: Como estamos controlando apenas um elevador, faz sentido usar o Singleton para assegurar que todas as requisições e eventos estejam centralizados em uma única instância. Isso previne a criação acidental de múltiplas instâncias que poderiam corromper o estado global.
  
### Mediator (Aplicado no InternalPanel e comunicação com ElevatorControlCenter)
- Descrição: O padrão Mediator foi implementado para controlar a comunicação entre os botões do painel interno e o sistema de controle do elevador.
- Justificativa: Isso ajuda a centralizar as interações entre os componentes, como os botões de chamada de andar, e evita que os componentes do painel interajam diretamente com o ElevatorControlCenter. Assim, o InternalPanel atua como o mediador, organizando a comunicação e simplificando o código.
  
### Observer (Aplicado na interface Observer e ElevatorDisplay)
- Descrição: O padrão Observer foi utilizado para manter atualizados os displays e outros componentes de saída (como o painel externo), notificando-os sempre que o estado do elevador mudar.
- Justificativa: O Observer garante que os displays e outros observadores sejam informados automaticamente sempre que o elevador mudar de andar ou estado, mantendo a interface gráfica sincronizada com o estado do sistema.

### State (Aplicado para gerenciar os estados de movimentação do elevador)
- Descrição: O padrão State foi aplicado para gerenciar os diferentes estados de movimentação do elevador (parado, subindo, descendo).
- Justificativa: Usar o padrão State permite que o comportamento do elevador mude dinamicamente de acordo com seu estado atual, como mover-se para um andar ou parar. Isso torna o código mais modular e facilita a adição de novos estados ou comportamentos no futuro.
