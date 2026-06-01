import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static int proximoNumero = 1;

    public static void main(String[] args) {
        Queue<Pedido> fila = new ArrayDeque<>();
        Pedido emPreparo = null;
        int opcao;

        do {
            System.out.println("\n=== Sistema de Pedidos da Lanchonete (Refatorado com Queue) ===");
            System.out.println("1 - Registrar pedido");
            System.out.println("2 - Iniciar preparo do próximo pedido");
            System.out.println("3 - Finalizar pedido em preparo");
            System.out.println("4 - Listar fila de espera");
            System.out.println("5 - Ver pedido em preparo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = lerInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine().trim();

                    System.out.print("Descrição do pedido: ");
                    String descricao = sc.nextLine().trim();

                    System.out.print("Valor total: ");
                    double valor = lerDouble();

                    Pedido pedido = new Pedido(
                            proximoNumero++,
                            nomeCliente,
                            descricao,
                            valor,
                            "AGUARDANDO_PREPARO"
                    );

                    fila.offer(pedido); // entra no fim da fila
                    System.out.println("Pedido registrado: " + pedido);
                }
                case 2 -> {
                    if (emPreparo != null) {
                        System.out.println("Já existe pedido em preparo. Finalize-o antes.");
                    } else {
                        emPreparo = fila.poll(); // remove do início da fila (FIFO)
                        if (emPreparo == null) {
                            System.out.println("Fila vazia.");
                        } else {
                            emPreparo.setStatus("EM_PREPARO");
                            System.out.println("Agora em preparo: " + emPreparo);
                        }
                    }
                }
                case 3 -> {
                    if (emPreparo == null) {
                        System.out.println("Nenhum pedido em preparo.");
                    } else {
                        emPreparo.setStatus("FINALIZADO");
                        System.out.println("Pedido finalizado: " + emPreparo);
                        emPreparo = null;
                    }
                }
                case 4 -> listarFila(fila);
                case 5 -> {
                    if (emPreparo == null) {
                        System.out.println("Nenhum pedido em preparo.");
                    } else {
                        System.out.println("Em preparo: " + emPreparo);
                    }
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void listarFila(Queue<Pedido> fila) {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }

        int i = 1;
        for (Pedido pedido : fila) {
            System.out.println(i++ + ". " + pedido);
        }
        System.out.println("Total na fila: " + fila.size());
    }

    private static int lerInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (Exception e) {
                System.out.print("Digite um valor válido: ");
            }
        }
    }

    static class Pedido {
        private final int numeroPedido;
        private final String nomeCliente;
        private final String descricaoPedido;
        private final double valorTotal;
        private String status;

        public Pedido(int numeroPedido, String nomeCliente, String descricaoPedido, double valorTotal, String status) {
            this.numeroPedido = numeroPedido;
            this.nomeCliente = nomeCliente;
            this.descricaoPedido = descricaoPedido;
            this.valorTotal = valorTotal;
            this.status = status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "#" + numeroPedido +
                    " | Cliente: " + nomeCliente +
                    " | Pedido: " + descricaoPedido +
                    " | Valor: R$ " + String.format("%.2f", valorTotal) +
                    " | Status: " + status;
        }
    }
}