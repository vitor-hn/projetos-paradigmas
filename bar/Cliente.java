package bar;

public class Cliente {
    private char sexo;
    private int quantidadeCervejas;
    private int quantidadeRefrigerantes;
    private int quantidadeEspetinhos;

    public Cliente(char sexo, int quantidadeCervejas, int quantidadeRefrigerantes, int quantidadeEspetinhos) {
        this.sexo = sexo;
        this.quantidadeCervejas = quantidadeCervejas;
        this.quantidadeRefrigerantes = quantidadeRefrigerantes;
        this.quantidadeEspetinhos = quantidadeEspetinhos;
    }

    public char getSexo() {
        return sexo;
    }

    public int getQuantidadeCervejas() {
        return quantidadeCervejas;
    }

    public int getQuantidadeRefrigerantes() {
        return quantidadeRefrigerantes;
    }

    public int getQuantidadeEspetinhos() {
        return quantidadeEspetinhos;
    }
}
