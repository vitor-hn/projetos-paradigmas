package imposto;

public class CalculadoraImposto {
    private double rendaSalario;
    private double rendaServicos;
    private double rendaGanhoCapital;
    private double gastosMedicos;
    private double gastosEducacionais;

    public CalculadoraImposto(double rendaSalario, double rendaServicos, double rendaGanhoCapital, double gastosMedicos, double gastosEducacionais) {
        this.rendaSalario = rendaSalario;
        this.rendaServicos = rendaServicos;
        this.rendaGanhoCapital = rendaGanhoCapital;
        this.gastosMedicos = gastosMedicos;
        this.gastosEducacionais = gastosEducacionais;
    }

    public double calcularImpostoSalario() {
        double salarioMensal = rendaSalario / 12;
        if (salarioMensal < 3000) {
            return 0;
        } else if (salarioMensal < 5000) {
            return salarioMensal * 0.10 * 12;
        } else {
            return salarioMensal * 0.20 * 12;
        }
    }

    public double calcularImpostoServicos() {
        return rendaServicos * 0.15;
    }

    public double calcularImpostoGanhoCapital() {
        return rendaGanhoCapital * 0.20;
    }

    public double calcularMaximoDedutivel(double impostoBrutoTotal) {
        return Math.min(0.3 * impostoBrutoTotal, gastosMedicos + gastosEducacionais);
    }

    public double calcularImpostoDevido(double maximoDedutivel) {
        double impostoBrutoTotal = calcularImpostoSalario() + calcularImpostoServicos() + calcularImpostoGanhoCapital();
        return impostoBrutoTotal - maximoDedutivel;
    }

    public void gerarRelatorio() {
        double impostoSalario = calcularImpostoSalario();
        double impostoServicos = calcularImpostoServicos();
        double impostoGanhoCapital = calcularImpostoGanhoCapital();
        double impostoBrutoTotal = impostoSalario + impostoServicos + impostoGanhoCapital;
        double maximoDedutivel = calcularMaximoDedutivel(impostoBrutoTotal);
        double gastosDedutiveis = gastosMedicos + gastosEducacionais;
        double impostoDevido = calcularImpostoDevido(maximoDedutivel);

        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###\n");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f\n", impostoServicos);
        System.out.printf("Imposto sobre ganho de capital: %.2f\n\n", impostoGanhoCapital);
        System.out.println("* DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f\n\n", gastosDedutiveis);
        System.out.println("* RESUMO:");
        System.out.printf("Imposto bruto total: %.2f\n", impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f\n", maximoDedutivel);
        System.out.printf("Imposto devido: %.2f\n", impostoDevido);
    }
}
