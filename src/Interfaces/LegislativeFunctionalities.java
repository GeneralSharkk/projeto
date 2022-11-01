package Interfaces;

/**
 * Interface com as funcionalidades das Eleições Legislativas.
 */
public interface LegislativeFunctionalities {
    
    /**
     * Método que calcula a taxa de abstenção.
     * 
     * @return taxa de abstenção
     */
    String calculateAbstentionRate();

    /**
     * Método que calcula o número de votos e a percetagem total dos votos de cada partido político 
     * para cada eleição.
     * 
     * @return número de votos e a percetagem total dos votos
     */
    String numberOfVotesAndPercentage();

    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição.
     * 
     * @return quantidade de mandatos
     */
    String calculateMandates();
}
