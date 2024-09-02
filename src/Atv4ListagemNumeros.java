import java.util.*;

public class Atv4ListagemNumeros {
    Scanner in = new Scanner(System.in);
    Queue<Integer> insertNumber = new LinkedList<>();
    Stack<Integer> insertStack = new Stack<>();

    // Método para inserir números na fila
    public void insertData() {
        int opt;
        boolean c = true;
        System.out.println("\nInsira um número inteiro positivo: (digite zero para sair)");

        do {
            try {
                System.out.print(">> ");
                opt = in.nextInt();
                if (opt < 0) {
                    System.out.println(">>Erro! Insira um número inteiro positivo.");
                } else if (opt == 0) {
                    c = false;
                } else {
                    insertNumber.add(opt);
                }
            } catch (Exception e) {
                System.out.println(">>Erro! Caracter inválido");
                in.next();
            }

        } while (c);
    }

    // Método para listar os números inseridos e ordená-los
    public void listData() {
        // Transferir os números da fila para a pilha
        while (!insertNumber.isEmpty()) {
            insertStack.push(insertNumber.poll());
        }

        // Ordenar a pilha usando uma nova pilha auxiliar
        Stack<Integer> sortedStack = new Stack<>();
        while (!insertStack.isEmpty()) {
            int tmp = insertStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() < tmp) { // Inverte a condição para "<"
                insertStack.push(sortedStack.pop());
            }
            sortedStack.push(tmp);
        }

        // Mostrar os números ordenados do menor para o maior
        System.out.println("\nNúmeros ordenados do menor para o maior:");
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
        System.out.println();
    }

    // Método para o menu principal
    public int mainMenu() {
        int o = 0;
        boolean c = true;
        do {
            try {
                System.out.print("\nSelecione a função desejada:\n1-Inserir números inteiros e ordená-los do menor para o maior;\n2-Listar números digitados e números ordenados;\n0-Sair;\nOpção:   ");
                o = in.nextInt();
                c = false;
            } catch (Exception e) {
                System.out.println("\nErro: Entrada inválida.");
                in.next();
            }
        } while (c);

        return o;
    }

    // Método principal
    public static void main(String[] args) {
        Atv4ListagemNumeros method = new Atv4ListagemNumeros();
        boolean c = true;
        int o = 0;

        do {
            o = method.mainMenu();

            switch (o) {
                case 1:
                    method.insertData();
                    break;
                case 2:
                    method.listData();
                    break;
                case 0:
                    System.out.println("\nSaindo...\n\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nErro: Entrada inválida.");
                    break;
            }

        } while (c);
    }
}