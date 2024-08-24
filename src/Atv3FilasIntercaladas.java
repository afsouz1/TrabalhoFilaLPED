import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Atv3FilasIntercaladas
 */
public class Atv3FilasIntercaladas {
    Scanner in = new Scanner(System.in);
    Queue<Integer> numberA = new LinkedList<>();
    Queue<Integer> numberB = new LinkedList<>();
    Queue<Integer> numberC = new LinkedList<>();
    boolean c = true;
    int o = 0;

    public void methodAddQueue (){
        do{
            

        }while(c);


    }

    public void printQueue (){


    }

    public void deleteQueue (){


    }
    public int mainMenu (){
        do{
            try{
                System.out.print("\nInsira a opção desejada:\n1-Criar filas de inteiro;\n2-Verificar filas e fila intercalada;\n3-Limpar filas;\n0-Sair;\n>> ");
                o = in.nextInt();
                c = false;
                
            }catch(Exception e){
                in.nextLine();
                System.out.println("\nErro::Entrada inválida");
            }
        }while(c);

        return o;
    }


    public static void main(String[] args) {
        Atv3FilasIntercaladas method = new Atv3FilasIntercaladas();
        do{
            o = method.mainMenu();
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
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("\nErro::Entrada inválida");
                    break;
            }

        }while(c);


    }
}