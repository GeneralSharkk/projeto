package Interfaces;

import java.util.HashMap;

/**
 * Interface com as funcionalidades das Eleições Presidencias.
 */
public interface PresidentialFunctionalities {

    /**
     * Método seletor dos votos.
     * 
     * @return HashMap
     */
    public HashMap<String, Integer> getVotes();
    
    /**
     * Método que calcula a taxa de abstenção e retorna em forma de String.
     * 
     * @return taxa de abstenção
     */
    String calculateAbstentionRate();
    
    /**
     * Método que calcula a taxa de abstenção e retorna em forma de Double.
     * 
     * @return taxa de abstenção
     */
    public double calculateAbstentionRateALT();

    /**
     * Método que calcula o número de votos e a percetagem total dos votos de cada partido político 
     * para cada eleição.
     * 
     * @return número de votos e a percetagem total dos votos
     */
    String numberOfVotesAndPercentage();

    /**
     * Método que determina, se possivel, o vencedor da eleição.
     * 
     * @return se houver, o vencedor da eleição
     */
    String declareWinner();
    
}
