/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Info.Tables;
import Votes.CountyElection;
import Votes.DistrictElection;
import Votes.ParishElection;
import java.util.HashMap;

/**
 * Interface com as funcionalidades das Eleições Aurtáquicas.
 */
public interface AutharcicFunctionalities {
    
    /**
     * Método que vai calcular a quantidade de votos por mesa.
     * Só vai ser calculado se houver mesas carregadas no programa.
     * 
     * @return string com o número da mesa e a quantidades de votos dessa mesa
     */
    String numberOfCandidatesPerTable();

    /**
     * Método que vai carregar as mesas para o programa.
     * Também vai guardar todas as freguesias.
     * 
     * @param tables mesas
     */
    void LoadTables(Tables tables);

    /**
     * Método que carrega dos votos das eleiçóes para o programa.
     * Os votos só vão ser carregados se já existerem mesas guardadas no programa.
     * 
     * @param countiesVotes votos da Câmara Municipal
     * @param districtVotes votos da Assembleia Municipal
     * @param parishesVotes votos da Assembleia de Freguesia
     */
    void LoadVotes(CountyElection countiesVotes, DistrictElection districtVotes, ParishElection parishesVotes);

    /**
     * Método que calcula a taxa de abstenção e retorna em forma de String.
     * 
     * @param option opcao
     * @return taxa de abstenção
     */
    String calculateAbstentionRate(int option);
    
    /**
     * Método que calcula a taxa de abstenção e retorna em forma de Double.
     * 
     * @param option opcao
     * @return taxa de abstenção
     */
    double calculateAbstentionRateALT(int option);

    /**
     * Método que calcula o número de votos e a percetagem total dos votos de cada partido político 
     * para cada eleição.
     * 
     * @param option opcao
     * @return número de votos e a percetagem total dos votos
     */
    String numberOfVotesAndPercentage(int option);
    
    /**
     * Método que vai retornar um HashMap com os partidos com chave e todos os seus votos como valor
     * 
     * @param option opcao
     * @return HashMap
     */
    HashMap<String, Integer> numberOfVotesPerPoliticalParty(int option);

    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição e retorna em forma de String.
     * 
     * @param option opcao
     * @return quantidade de mandatos
     */
    String calculateMandates(int option);
    
    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição e retorna em forma de HashMap.
     * Esse HashMap vai ter o partido com chave e a quantidade de mandatos com valor.
     * 
     * @param option opcao
     * @return quantidade de mandatos
     */
    public HashMap<String, Integer> calculateMandatesALT(int option);
}
