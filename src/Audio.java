/**
 * PROJETO: SwiftScore
 * OBJETIVO TÉCNICO:
 * - Demonstrar fundamentos de POO (Programação Orientada a Objetos).
 * - Mostrar o uso de Encapsulamento e Programação Defensiva (tratamento de borda).
 */
public class Audio {
    // ENCAPSULAMENTO:
    // Atributos privados garantem que o estado do objeto não seja alterado de fora
    // sem passar pelas regras de negócio dos métodos.
    private String titulo;
    private int duracaoSegundos;
    private int totalDeReproducoes;
    private double somaDasAvaliacoes;  // Acumula o total das notas recebidas
    private int quantidadeAvaliacoes;  // Contador de quantas avaliações foram feitas

    // =========================================================================
    // MÉTODO 1: REGRA DE NEGÓCIO - AVALIAR
    // =========================================================================
    // Em vez de alterar os atributos diretamente de fora, o método encapsula a lógica:
    // soma a nova nota e incrementa o total de avaliadores.
    public void avaliar(double nota) {
        somaDasAvaliacoes += nota;
        quantidadeAvaliacoes++;
    }

    // =========================================================================
    // MÉTODO 2: REGRA DE NEGÓCIO - CÁLCULO DE MÉDIA (PROGRAMAÇÃO DEFENSIVA)
    // =========================================================================
    // "Faço uma verificação prévia de segurança: se a quantidade de avaliações for 0,
    // retorno 0. Isso evita erro de divisão por zero (NaN/Infinity) se o áudio for novo."
    public double pegarMedia() {
        if (quantidadeAvaliacoes == 0) {
            return 0; // <- Proteção contra divisão por zero
        }
        return somaDasAvaliacoes / quantidadeAvaliacoes;
    }

    // =========================================================================
    // MÉTODO 3: REPRODUÇÃO
    // =========================================================================
    public void reproduzir() {
        this.totalDeReproducoes++;
        System.out.println("Tocando agora: " + this.titulo);
    }

    // =========================================================================
    // GETTERS E SETTERS (Acesso controlado aos dados)
    // =========================================================================
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    public int getTotalDeReproducoes() {
        return totalDeReproducoes;
    }

    public void setTotalDeReproducoes(int totalDeReproducoes) {
        this.totalDeReproducoes = totalDeReproducoes;
    }

    public int getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(int quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }
}
