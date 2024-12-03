package jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        do {
            inicializarTabuleiro();
            
            while (true) {
                imprimirTabuleiro();
                System.out.println("Vez do jogador " + jogadorAtual);
                System.out.println("Digite a linha:");
                int linha = scanner.nextInt();

                System.out.println("Digite a coluna:");
                int coluna = scanner.nextInt();

                if (validarJogada(linha, coluna)) {
                    tabuleiro[linha][coluna] = jogadorAtual;

                    if (verificarVencedor()) {
                        imprimirTabuleiro();
                        System.out.println("Parabéns! O jogador " + jogadorAtual + " venceu!");
                        break;
                    }

                    if (empate()) {
                        imprimirTabuleiro();
                        System.out.println("Empate! O jogo terminou sem vencedor.");
                        break;
                    }

                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Coordenada inválida, tente novamente.");
                }
            }

            scanner.nextLine(); 

            int resposta = 0;
            while (resposta != 1 && resposta != 2) {
                System.out.println("Deseja jogar novamente? (1 - Sim, 2 - Não):");
                String input = scanner.nextLine();
                
                try {
                    resposta = Integer.parseInt(input);
                    if (resposta != 1 && resposta != 2) {
                        System.out.println("Opção inválida! Por favor, insira 1 para Sim ou 2 para Não.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida! Por favor, insira 1 para Sim ou 2 para Não.");
                }
            }
            
            if (resposta == 2) {
                break;
            }
            
        } while (true);
        
        scanner.close();
        System.out.println("Obrigado por jogar!");
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private static void imprimirTabuleiro() {
        System.out.println("   0   1   2");
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean validarJogada(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ';
    }

    private static boolean verificarVencedor() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                return true;
            }
        }

        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;
        }

        return false;
    }

    private static boolean empate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}