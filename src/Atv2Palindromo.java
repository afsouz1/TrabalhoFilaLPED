
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//Atividade: Verificar se palavra é uma palavra Palíndromo (é lida de trás para frente como normal, ex. Arara)


public class Atv2Palindromo {
    Scanner in = new Scanner(System.in);
    Queue<Character> wordQueue = new LinkedList<>();
    Stack<Character> wordStack = new Stack<>();

    public void insertQueue () {
        String add;
        int testTrue=0, testFalse=0;
        
        System.out.print("Insira uma palavra:\n>> ");
        add = in.next();

        for (int i = 0; i < add.length(); i++) {
            wordStack.push(add.charAt(i));
            wordQueue.offer(add.charAt(i));
        }

        for (int i = 0; i < add.length(); i++) {
            wordQueue.poll();
            wordStack.pop();

            try {
                if(wordStack.peek() == wordQueue.peek()){
                    testTrue++;
                }else{
                    testFalse++;
                }                
            } catch (Exception e) {
            }
        }

        if (testFalse == 0) {
            System.out.println("A palavra "+add+" É UMA palavra Palíndromo");            
        }else{
            System.out.println("A palavra "+add+" NÃO é uma palavra Palíndromo");
        }



    }

    public int mainMenu (){
        int o = 0;
        boolean c = true;
        
        do{
            System.out.print("\nInsira a opção desejada:\n (1)Testar se palavra é um Palíndromo;\n (0)Sair;\n>>");
            try {
                o = in.nextInt();
                c = false;
            } catch (Exception e) {
                in.nextLine();
                System.out.println("Erro::Entrada inválida");                
            }
        }while(c);
        
        return o;
    }

    public static void main(String[] args) {
        Atv2Palindromo method = new Atv2Palindromo();

        int o = 0;
        boolean c = true;

        do{
            o = method.mainMenu();
            switch (o) {
                case 1:
                    method.insertQueue();
                    break;
                case 0:
                    System.out.println("Saindo...\n\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Erro::Entrada inválida");
                    break;
            }

        }while(c);





    }    
}
