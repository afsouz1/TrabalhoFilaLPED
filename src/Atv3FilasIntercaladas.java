import java.util.*;


public class Atv3FilasIntercaladas {
    Scanner in = new Scanner(System.in);
    Queue<Integer> numberA1 = new LinkedList<>();
    Queue<Integer> numberA2 = new LinkedList<>();
    Queue<Integer> numberB1 = new LinkedList<>();
    Queue<Integer> numberB2 = new LinkedList<>();
    Queue<Integer> numberC = new LinkedList<>();
    int o = 0;

    public void methodAddQueue() {
        int insert = 0;

        // Inserir informações na fila A
        System.out.println("\nInserir números na Fila A (digite zero para sair)");
        do {
            try {
                System.out.print("Insira um número para a Fila A: ");
                insert = in.nextInt();
                if (insert != 0) {
                    numberA1.add(insert);
                    numberA2.add(insert);
                }
            } catch (Exception e) {
                System.out.println("Erro::Entrada inválida");
                insert = 1;
                in.next(); // Limpa a entrada inválida
            }
        } while (insert != 0);

        // Inserir informações na fila B
        System.out.println("\nInserir números na Fila B (digite zero para sair)");
        do {
            try {
                System.out.print("Insira um número para a Fila B: ");
                insert = in.nextInt();
                if (insert != 0) {
                    numberB1.add(insert);
                    numberB2.add(insert);
                }
            } catch (Exception e) {
                System.out.println("Erro::Entrada inválida");
                insert = 1;
                in.next();
            }
        } while (insert != 0);

        // Gerar fila C intercalada
        while (!numberA1.isEmpty() || !numberB1.isEmpty()) {
            if (!numberA1.isEmpty()) {
                numberC.add(numberA1.poll());
            }
            if (!numberB1.isEmpty()) {
                numberC.add(numberB1.poll());
            }
        }
    }

    public void printQueue() {
        boolean c = true;

        do{
            if (numberA2.isEmpty() && numberB2.isEmpty()) {
                // in.next();
                System.out.println("\nFilas vazias.");
                c = false;
            } else {
                System.out.println("\nFilas atuais:");
                System.out.println("Fila A: " + numberA2);
                System.out.println("Fila B: " + numberB2);
                System.out.println("Fila C (Intercalada): " + numberC);
                c = false;
            }
        }while(c);
    }

    public void deleteQueue() {
        Boolean c = true;
        do{
            if (numberA2.isEmpty() && numberB2.isEmpty()) {
                System.out.println("\nFilas vazias.");
                c = false;
            } else {
                System.out.print("\nConfirma apagar todos os dados das filas? y/n: ");
                String opt = in.next();
    
                if (opt.equalsIgnoreCase("y")) {
                    numberA1.clear();
                    numberA2.clear();
                    numberB1.clear();
                    numberB2.clear();
                    numberC.clear();
                    System.out.println("Filas apagadas.");
                    c = false;
                } else if (opt.equalsIgnoreCase("n")){
                    System.out.println("Filas não apagadas.");
                    c = false;
                } else{
                    System.out.println("Erro: Entrada inválida.");
                    c = true;
                }
            }
        }while(c);
        
    }

    public int mainMenu() {
        boolean c = true;

        do {
            try {
                System.out.print("\nInsira a opção desejada:\n1-Criar filas de inteiros\n2-Verificar filas e fila intercalada\n3-Limpar filas\n0-Sair\n>> ");
                o = in.nextInt();
                c = false;
            } catch (Exception e) {
                in.nextLine(); // Limpa a entrada inválida
                System.out.println("\nErro::Entrada inválida");
            }
        } while (c);

        return o;
    }

    public static void main(String[] args) {
        Atv3FilasIntercaladas method = new Atv3FilasIntercaladas();
        boolean c = true;
        do {
            int o = method.mainMenu();
            switch (o) {
                case 1:
                    method.methodAddQueue();
                    break;
                case 2:
                    method.printQueue();
                    break;
                case 3:
                    method.deleteQueue();
                    break;
                case 0:
                    c = false;
                    break;
                default:
                    System.out.println("\nErro::Entrada inválida");
                    break;
            }
        } while (c);
    }
}