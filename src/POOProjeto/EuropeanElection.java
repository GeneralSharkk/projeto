package POOProjeto;

import Reader.Reader;
import java.util.HashMap;
import java.util.Map;

import Hondt.Mandate;
import Info.Tables;
import Interfaces.EuropeanFunctionaliteis;

/**
 * Classe que corresponde a uma Eleição Europeia.
 *
 * @author henri
 */
public class EuropeanElection implements EuropeanFunctionaliteis{
    
    private HashMap<String, Integer> votes;
    private int mandates;
    private int numberOfVotes;
    
    /**
     * Construtor que cria um objeto que corresponde a uma Eleição Europeia. com base nos partidos,
     * nos votos e nos mandatos.
     * 
     * @param politicalParty partidos
     * @param votes votos
     * @param mandates mandatos
     */
    public EuropeanElection(String[] politicalParty, int[] votes, int mandates){
        this.votes = setHashMap(politicalParty, votes);
        this.mandates = mandates;
        for (int i = 0; i < votes.length; i++) {
            this.numberOfVotes += votes[i];
        }
    }
    
    /**
     * Método seletor dos votos.
     * 
     * @return HashMap
     */
    @Override
    public HashMap<String, Integer> getVotes(){
        return this.votes;
    }

    /**
     * Método privado para dar set ao HashMap com os partidos e os seus votos.
     * 
     * @param politicalParty
     * @param votes
     * @return HashMap com os partidos e os seus votos
     */
    private HashMap<String, Integer> setHashMap(String[] politicalParty, int[] votes){
        HashMap<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            temp.put(politicalParty[i], votes[i]);
        }
        return temp;
    }

    /**
     * Método privado para calcular o total número de votos
     * 
     * @return votos
     */
    private int totalNumberOfVotes(){
        int temp = 0;
        Reader r = new Reader();
        Tables t = new Tables();
        t.setTables(r.readTables());
        temp = t.getTotalVoters();
        return temp;
    }

    /**
     * Método que calcula a taxa de abstenção e retorna em forma de String.
     * 
     * @return taxa de abstenção
     */
    @Override
    public String calculateAbstentionRate() {
        StringBuilder s = new StringBuilder();
        if(this.votes != null){
            double votesPercentage = 0.0;
            votesPercentage = (100.0 - (this.numberOfVotes * 100.0) / totalNumberOfVotes());
            s.append("A Taxa de abstenção: ").append(String.format("%.2f", votesPercentage)).append("%\n");
            return s.toString();
        }
        s.append("Não existe votos carregados no programa.");
        return s.toString();
    }
    
    /**
     * Método que calcula a taxa de abstenção e retorna em forma de Double.
     * 
     * @return taxa de abstenção
     */
    @Override
    public double calculateAbstentionRateALT(){
        double votesPercentage = 0.0;
        if(this.votes != null){
            votesPercentage = (100.0 - (this.numberOfVotes * 100.0) / totalNumberOfVotes());
            return votesPercentage;
        }
        return votesPercentage;
    }

    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição e retorna em forma de String.
     * 
     * @return quantidade de mandatos
     */
    @Override
    public String calculateMandates() {
        StringBuilder s = new StringBuilder();
        s.append(Mandate.calculateMandates(mandates, this.votes));
        return s.toString();
    }
    
    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição e retorna em forma de HashMap.
     * 
     * @return quantidade de mandatos
     */
    @Override
    public HashMap<String, Integer> calculateMandatesALT(){
        HashMap<String, Integer> temp = Mandate.calculateMandatesALT(mandates, this.votes);
        return temp;
    }

    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição.
     * 
     * @return quantidade de mandatos
     */
    @Override
    public String numberOfVotesAndPercentage() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Integer> i : this.votes.entrySet()) {
            String party = i.getKey();
            int votes = i.getValue();
            double percentage = (double) (votes * 100) / this.numberOfVotes;
            s.append(party).append(": ").append(votes).append(" (").append(String.format("%.2f", percentage)).append("%)\n");
        }
        return s.toString();
    }
}
