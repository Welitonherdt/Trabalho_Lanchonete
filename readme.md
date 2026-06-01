# Sistema de Pedidos de Lanchonete (Java)

## Descrição
Aplicação Java para controle de pedidos de uma lanchonete, seguindo a regra **FIFO** (First In, First Out): o primeiro pedido registrado é o primeiro a ser atendido.

## Tema da Atividade
**Sistema de Pedidos de uma Lanchonete**

Cada pedido possui:
- Número do pedido
- Nome do cliente
- Descrição do pedido
- Valor total
- Status do pedido

## Estrutura da Entrega
O projeto foi desenvolvido em duas etapas:

### 1) Versão sem estruturas prontas
Implementação manual da fila com nós encadeados:
- Classe `FilaPedido`
- Classe interna `No`
- Operações de enfileirar, desenfileirar e listar

### 2) Versão refatorada com estruturas prontas
Implementação usando biblioteca padrão do Java:
- `Queue<Pedido>`
- `ArrayDeque<Pedido>`
- Métodos `offer`, `poll`, `isEmpty`, `size`

## Regras de Funcionamento
- Pedido novo entra com status `AGUARDANDO_PREPARO`
- Ao iniciar preparo, o primeiro da fila passa para `EM_PREPARO`
- Ao finalizar, status vira `FINALIZADO`
- Só pode haver um pedido em preparo por vez

## Funcionalidades do Menu
1. Registrar pedido
2. Iniciar preparo do próximo pedido
3. Finalizar pedido em preparo
4. Listar fila de espera
5. Ver pedido em preparo
0. Sair

## Como Executar

### Pré-requisitos
- Java JDK 17+ (ou compatível)

### Compilar
```bash
javac Main.java
Executar
java Main

Conceito de Estrutura de Dados Aplicado
A aplicação usa o método FIFO:
quem entra primeiro na fila é atendido primeiro;
ideal para processos sequenciais como preparação de pedidos.

Autor: Weliton Herdt Sebastião

Projeto acadêmico para disciplina de Estruturas de Dados.