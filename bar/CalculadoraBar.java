package bar;

import java.util.Scanner;

public class CalculadoraBar {
    private static final double Ingresso_Homem = 10.0;
    private static final double Ingresso_Mulher = 8.0;
    private static final double Preco_Cerveja = 5.0;
    private static final double Preco_Refrigerante = 3.0;
    private static final double Preco_Espetinho = 7.0;
    private static final double Couvert = 4.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sexo (F ou M): ");
        char sexo = scanner.next().charAt(0);

        System.out.print("Quantidade de cervejas: ");
        int quantidadeCervejas = scanner.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        int quantidadeRefrigerantes = scanner.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        int quantidadeEspetinhos = scanner.nextInt();

        Cliente cliente = new Cliente(sexo, quantidadeCervejas, quantidadeRefrigerantes, quantidadeEspetinhos);

        double consumo = calcularConsumo(cliente);
        double ingresso = calcularIngresso(cliente.getSexo());
        double valorTotal = calcularValorTotal(consumo, ingresso);

        imprimirRelatorio(consumo, ingresso, valorTotal);
        
        scanner.close();
    }

    private static double calcularConsumo(Cliente cliente) {
        return (cliente.getQuantidadeCervejas() * Preco_Cerveja) +
               (cliente.getQuantidadeRefrigerantes() * Preco_Refrigerante) +
               (cliente.getQuantidadeEspetinhos() * Preco_Espetinho);
    }

    private static double calcularIngresso(char sexo) {
        return (sexo == 'M' || sexo == 'm') ? Ingresso_Homem : Ingresso_Mulher;
    }

    private static double calcularValorTotal(double consumo, double ingresso) {
        if (consumo > 30) {
            return consumo + ingresso;
        } else {
            return consumo + ingresso + Couvert;
        }
    }

    private static void imprimirRelatorio(double consumo, double ingresso, double valorTotal) {
        System.out.println("\nRELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f%n", consumo);
        if (consumo > 30) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f%n", Couvert);
        }
        System.out.printf("Ingresso = R$ %.2f%n\n", ingresso);
        System.out.printf("Valor a pagar = R$ %.2f%n", valorTotal);
    }
}
