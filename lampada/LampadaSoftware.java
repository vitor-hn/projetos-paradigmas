package lampada;

import java.util.Scanner;

public class LampadaSoftware {

    private String marca;
    private int voltagem;
    private String tipo;
    private String modelo;
    private String cor;
    private double preco;
    private String garantia;
    private boolean isLigada;

    public void inicializarLampada() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(">>> INÍCIO DO SOFTWARE DA LÂMPADA <<<\n");

        System.out.print("Informe a marca da lâmpada: ");
        marca = scanner.nextLine();

        System.out.print("Informe a voltagem da lâmpada (em volts): ");
        voltagem = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o tipo da lâmpada: ");
        tipo = scanner.nextLine();

        System.out.print("Informe o modelo da lâmpada: ");
        modelo = scanner.nextLine();

        System.out.print("Informe a cor da lâmpada: ");
        cor = scanner.nextLine();

        System.out.print("Informe o preço da lâmpada (R$): ");
        preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Informe a garantia da lâmpada (em meses): ");
        garantia = scanner.nextLine();

        isLigada = false;
    }

    public void ligar() {
        if (!isLigada) {
            isLigada = true;
            System.out.println("# Lâmpada Ligada #");
        } else {
            System.out.println("A lâmpada já está ligada.");
        }
    }

    public void desligar() {
        if (isLigada) {
            isLigada = false;
            System.out.println("# Lâmpada Desligada #");
        } else {
            System.out.println("A lâmpada já está desligada.");
        }
    }

    public void mostrarStatus() {
        System.out.println("\n>>> STATUS DA LÂMPADA <<<\n");
        System.out.println("COR: " + cor);
        System.out.println("MARCA: " + marca);
        System.out.println("MODELO: " + modelo);
        System.out.println("VOLTAGEM: " + voltagem + " volts");
        System.out.println("TIPO: " + tipo);
        System.out.println("GARANTIA: " + garantia + " meses");
        System.out.println("PREÇO: R$ " + preco);
        System.out.println("STATUS: " + (isLigada ? "Ligada" : "Desligada"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LampadaSoftware lampada = new LampadaSoftware();

        lampada.inicializarLampada();

        lampada.mostrarStatus();

        int opcao;
        do {
            System.out.println("\nLigar/Desligar lâmpada? 0 – Sair / 1 – Sim / 2 – Não");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    if (lampada.isLigada) {
                        lampada.desligar();
                    } else {
                        lampada.ligar();
                    }
                    break;
                case 2:
                    System.out.println("Você escolheu não alterar o estado da lâmpada.");
                    break;
                case 0:
                    System.out.println("*** Você encerrou o software. ***");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
