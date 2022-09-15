package tarefa1;

import java.util.Scanner;
import java.util.ArrayList;

public class Index {

    public static ArrayList<String> pVermelho = new ArrayList<String>();
    public static ArrayList<String> pAmarelo = new ArrayList<String>();
    public static ArrayList<String> pVerde = new ArrayList<String>();

    public static void main(String[] agrs) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("Olá seja bem vindo(a), ao pronto socorro");
        Thread.sleep(2000);
        
        while (true){
            System.out.println("Digite seu nome completo: ");
            String nome = input.next();
            
            while (true){
                System.out.println("Escolha um código de atendimento: ");
                System.out.println("(A) Vermelho (maior prioridade)");
                System.out.println("(B) Amarelo, (prioridade media)");
                System.out.println("(C) Verde (nada grave)");
                String code = input.next();

                if (code.toUpperCase().equals("A")){
                    pVermelho.add(nome); break;
                } else if (code.toUpperCase().equals("B")){
                    pAmarelo.add(nome); break;
                } else if (code.toUpperCase().equals("C")){
                    pVerde.add(nome); break;
                } else break;
            }

            System.out.println("Paciente armazenado na fila de espera!");

            System.out.println("\n\nAguarde 5 segundos até a consulta acabar!\n");
            if (pVermelho.size() > 0) {
                consulta(pVermelho);
            } else if (pAmarelo.size() > 0) {
                consulta(pAmarelo);
            } else consulta(pVerde);

            Thread.sleep(5000);
            System.out.println("A consulta acabou!\n\n");

            System.out.println("\n OK! Agora aguarde 4 segundos para a próxima chamada...");
            Thread.sleep(4000);
            System.out.println("\n\nPróximo!!!\n");
        }
    }

    private static void consulta(ArrayList<String> pacientes){
        System.out.println("Consultando...");
        pacientes.remove(0);
    }
}
