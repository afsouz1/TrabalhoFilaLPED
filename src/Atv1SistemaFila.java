import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
        Faça um sistema que gerencie a fila de uma lanchonete através de senha
 */

public class Atv1SistemaFila {
    Scanner in = new Scanner(System.in);
    Queue<String> name = new LinkedList<>();
    Queue<Integer> password = new LinkedList<>();
    int cont = 0;


    //Método inserir nome e gerar senha   
    public void insertPool(){
        String contName;
        System.out.print("\nInsira o nome do Cliente: ");
        contName = in.nextLine();
        name.add(contName);

        if (password.isEmpty()) {
            cont = 1;
        }else{
            cont = (cont +1);
        }

        password.add(cont);      
        System.out.println("Sucesso! Cliente: "+contName+", Senha: "+cont);
    }


    //Método imprimir senhas
    public void usrPasswd (){
        
        if (password.isEmpty()) {
            System.out.println("\nSem fila");
        }else{
            System.out.println("\nSenha: "+password.poll()+", Cliente: "+name.poll());
        }
    }

    //Método ver tamanho da fila
    public void passwdList (){
        Iterator nameItr = name.iterator();
        Iterator passwdItr = password.iterator();
        int time = 8;

        if (password.isEmpty()) {
            System.out.println("\nSem fila");
        }else{
            System.out.println("Usuários na fila: "+password.size()+"\n");
            while(nameItr.hasNext())
            System.out.println("Senha: "+passwdItr.next()+", Nome: " + nameItr.next());
            if (password.size() == 1) {
                System.out.println("\nTempo de espera estimado total: "+(password.size()*time)+" minutos");
            }else{
                System.out.println("\nTempo de espera estimado por usuário: "+time+" minutos");
                System.out.println("Tempo de espera estimado total: "+(password.size()*time)+" minutos");
            }   
        }    
    }

    //Método Menu Principal
    public int mainMenu (){
        int o = 0;
        boolean ctrl = true;

        do{
            try {
                System.out.print("\nInsira a opção desejada:\n1-Inserir cliente e gerar senha;\n2-Chamar próxima senha;\n3-Ver todas as senhas da fila;\n0-Sair;\n>>");
                o = in.nextInt();
                in.nextLine();
                ctrl = false;                
            } catch (Exception e) {
                in.nextLine();     
                System.out.println("Err.:Inserir caracter válido");
            }
        }while(ctrl);
        
        return o;
    }

    public static void main(String[] args) throws Exception {
        Atv1SistemaFila method = new Atv1SistemaFila();
        
        int opt = 0;
        boolean ctrl = true;
        
        //Method calling
        do{
            opt = method.mainMenu();
            
            switch (opt) {
                case 1:
                    method.insertPool();                    
                    break;
                case 2:
                    method.usrPasswd();
                    break;
                case 3:
                    method.passwdList();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Erro! Opção inválida");
                    break;
            }
        }while(ctrl);
    }
}