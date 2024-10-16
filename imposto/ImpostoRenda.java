package imposto;

import java.util.Scanner;

public class ImpostoRenda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Renda anual com salário: ");
        double rendaSalario = scanner.nextDouble();
        
        System.out.print("Renda anual com prestação de serviço: ");
        double rendaServicos = scanner.nextDouble();
        
        System.out.print("Renda anual com ganho de capital: ");
        double rendaGanhoCapital = scanner.nextDouble();
        
        System.out.print("Gastos médicos: ");
        double gastosMedicos = scanner.nextDouble();
        
        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = scanner.nextDouble();
        
        CalculadoraImposto calculadora = new CalculadoraImposto(rendaSalario, rendaServicos, rendaGanhoCapital, gastosMedicos, gastosEducacionais);
        
        calculadora.gerarRelatorio();
        
        scanner.close();
    }
}
