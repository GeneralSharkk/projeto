package Interfaces;

import java.util.HashMap;

/**
 * Interface com as funcionalidades das Eleições Europeias.
 */
public interface EuropeanFunctionaliteis {
   
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
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição e retorna em forma de String.
     * 
     * @return quantidade de mandatos
     */
    String calculateMandates();
    
    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição e retorna em forma de HashMap.
     * 
     * @return quantidade de mandatos
     */
    public HashMap<String, Integer> calculateMandatesALT();
}
