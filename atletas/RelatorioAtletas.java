package atletas;

import java.util.Scanner;

public class RelatorioAtletas {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a quantidade de atletas? ");
        int N = sc.nextInt();
        
        while (N <= 0) {
            System.out.print("Valor inválido! A quantidade de atletas deve ser maior que 0. Tente novamente: ");
            N = sc.nextInt();
        }

        String nomeMaisAlto = "";
        double maiorAltura = 0.0;
        double somaPesos = 0.0;
        int contadorHomens = 0;
        int contadorMulheres = 0;
        double somaAlturaMulheres = 0.0;

        for (int i = 1; i <= N; i++) {
            System.out.println("Digite os dados do atleta numero " + i + ":");
            sc.nextLine();

            String nome;
            while (true) {
                System.out.print("Nome: ");
                nome = sc.nextLine().trim();

                if (nome.matches("[A-Za-zÀ-ÿ\\s]+")) {
                    break;
                } else {
                    System.out.println("Nome inválido! O nome não pode conter números ou caracteres especiais. Tente novamente.");
                }
            }
            
            String sexo;
            do {
                System.out.print("Sexo (M/F): ");
                sexo = sc.nextLine().toUpperCase();
                if (!sexo.equals("M") && !sexo.equals("F")) {
                    System.out.println("Valor inválido! Favor digitar F ou M.");
                }
            } while (!sexo.equals("M") && !sexo.equals("F"));
            
            double altura;
            do {
                System.out.print("Altura: ");
                altura = sc.nextDouble();
                if (altura <= 0) {
                    System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                }
            } while (altura <= 0);
            
            double peso;
            do {
                System.out.print("Peso: ");
                peso = sc.nextDouble();
                if (peso <= 0) {
                    System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                }
            } while (peso <= 0);

            somaPesos += peso;

            if (sexo.equals("M")) {
                contadorHomens++;
            } else {
                contadorMulheres++;
                somaAlturaMulheres += altura;
            }

            if (altura > maiorAltura) {
                maiorAltura = altura;
                nomeMaisAlto = nome;
            }
        }

        System.out.println("\n### RELATÓRIO ###");

        double pesoMedio = somaPesos / N;
        System.out.printf("Peso médio dos atletas: %.2f\n", pesoMedio);

        System.out.println("Atleta mais alto: " + nomeMaisAlto);

        double porcentagemHomens = (double) contadorHomens / N * 100;
        System.out.printf("Porcentagem de homens: %.1f %%\n", porcentagemHomens);

        if (contadorMulheres > 0) {
            double alturaMediaMulheres = somaAlturaMulheres / contadorMulheres;
            System.out.printf("Altura média das mulheres: %.2f\n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }

        sc.close();
    }
}
