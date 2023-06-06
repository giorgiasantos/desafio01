import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// MÉTODO DO JOGO DE ADIVINHAÇÃO - 2 NÍVEIS DE DIFICULDADE
public class JogoAdivinhaNumeroFinal {
    static int jogo(Scanner entrada, int pontuacao, Random aleatorio, List<Integer> erros, List<Integer> acertos){
        int numero = 0;
        // SELEÇÃO DE DIFICULDADE
        System.out.println("SELECIONE A DIFICULDADE: FACIL (F) / DIFICIL (D) ");
        String dificuldade = entrada.next();
        System.out.println("-----------------------------------------------------------");

        // NÍVEL FÁCIL
        if (dificuldade.equalsIgnoreCase("F")) {
            numero = aleatorio.nextInt(10);
            //System.out.println(numero);
            System.out.println("VOCÊ TEM 5 TENTATIVAS PARA ACERTAR.");

            for (int i = 0; i < 5; i++) {
                System.out.println("DIGITE UM NÚMERO DE 0 A 10: ");
                int chute = entrada.nextInt();
                if (chute == (numero + 1)) {
                    System.out.println("SEU NÚMERO FOI UM A MAIS QUE O NÚMERO QUE EU PENSEI.");
                    pontuacao += 5;
                    erros.add(chute);
                } else if(chute == (numero - 1)) {
                    System.out.println("SEU NÚMERO FOI UM A MENOS QUE O NÚMERO QUE EU PENSEI!");
                    pontuacao += 5;
                    erros.add(chute);
                } else if (chute == numero) {
                    System.out.println("VOCÊ ACERTOU!!! :D ");
                    pontuacao += 10;
                    acertos.add(chute);
                    return pontuacao;
                } else if (chute != numero) {
                    System.out.println("VOCÊ ERROU :( ");
                    erros.add(chute);
                }

            }
        // NÍVEL DIFÍCIL
        }else if(dificuldade.equalsIgnoreCase("D")) {
            numero = aleatorio.nextInt(100);
            System.out.println("VOCÊ TEM 3 TENTATIVAS PARA ACERTAR.");
            //System.out.println(numero);

            for (int i = 0; i < 3; i++) {
                System.out.println("DIGITE UM NÚMERO DE 0 A 100: ");
                int chute = entrada.nextInt();

                if (chute == (numero + 1)) {
                    System.out.println("SEU NÚMERO FOI UM A MAIS QUE O NÚMERO QUE EU PENSEI.");
                    pontuacao += 5;
                    erros.add(chute);
                } else if(chute == (numero - 1)) {
                    System.out.println("SEU NÚMERO FOI UM A MENOS QUE O NÚMERO QUE EU PENSEI!");
                    pontuacao += 5;
                    erros.add(chute);
                } else if (chute == numero) {
                    System.out.println("VOCÊ ACERTOU!!! :D ");
                    pontuacao += 10;
                    acertos.add(chute);
                    return pontuacao;
                } else if (chute != numero) {
                    System.out.println("VOCÊ ERROU :( ");
                    erros.add(chute);
                }

            }
        }

    return pontuacao;
}
// MÉTODO PARA JOGAR NOVAMENTE
    static void reiniciar(Scanner entrada, int pontuacao, Random aleatorio, List<Integer> erros, List<Integer> acertos){
        // perguntar se quer reiniciar o jogo
        System.out.println("QUER JOGAR NOVAMENTE? SIM (S) / NÃO (N)");
        String denovo = entrada.next();

        // validação da opção e loop para jogar novamente
        while(denovo.equalsIgnoreCase("S"))
        {
            // chamando o método do jogo
            pontuacao = jogo(entrada, pontuacao, aleatorio, erros,acertos);

            // saída da pontuação e históricos
            System.out.println("PONTUAÇÃO TOTAL = " +pontuacao);
            System.out.println("-----------------------------------------------------------");
            System.out.println("SEU HISTORICO DE ACERTOS: " +acertos);
            System.out.println("SEU HISTORICO DE ERROS: " +erros);
            System.out.println("-----------------------------------------------------------");
            System.out.println("QUER JOGAR NOVAMENTE? SIM (S) / NÃO (N)");
            denovo = entrada.next();
        }

    }

    // PRINCIPAL
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        // inicialização de variaveis
        int pontuacao = 0;
        List<Integer> acertos = new ArrayList<>();
        List<Integer> erros = new ArrayList<>();

        // introdução do jogo
        System.out.println("✩｡:*•.─────  ❁ ❁  ─────.•*:｡✩✩｡:*•.─────  ❁ ❁  ─────.•*:｡✩");
        System.out.println("VOCÊ CONSEGUE ADIVINHAR O NÚMERO EM QUE ESTOU PENSANDO? ");
        System.out.println("✩｡:*•.─────  ❁ ❁  ─────.•*:｡✩✩｡:*•.─────  ❁ ❁  ─────.•*:｡✩");
        System.out.println();

        // chamando o metodo do jogo e parâmetros para inicializar a partida e registrar pontuação
        pontuacao = jogo(entrada,pontuacao,aleatorio,erros,acertos);

        // saída de pontuação e históricos usando os parâmetros
        System.out.println("PONTUAÇÃO TOTAL = " +pontuacao);
        System.out.println("-----------------------------------------------------------");
        System.out.println("SEU HISTORICO DE ACERTOS: " +acertos);
        System.out.println("SEU HISTORICO DE ERROS: " +erros);
        System.out.println("-----------------------------------------------------------");

        // chamando o método e parâmetros para jogar uma nova partida
        reiniciar(entrada, pontuacao, aleatorio, erros, acertos);

    }
}
