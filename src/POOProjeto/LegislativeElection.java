package POOProjeto;

import java.util.HashMap;
import java.util.Map;

import Hondt.Mandate;
import Info.Tables;
import Interfaces.LegislativeFunctionalities;
import Reader.Reader;

/**
 * Classe que corresponde a uma Eleição Legislativa.
 *
 * @author henri
 */
public class LegislativeElection implements LegislativeFunctionalities{

    private HashMap<String, Integer> votes;
    private int mandates;
    private int numberOfVotes;
    
    /**
     * Construtor que cria um objeto que corresponde a uma Eleição Legislativa. com base nos partidos,
     * nos votos e nos mandatos.
     * 
     * @param politicalParty partidos
     * @param votes votos
     * @param mandates mandatos
     */
    public LegislativeElection(String[] politicalParty, int[] votes, int mandates){
        this.votes = setHashMap(politicalParty, votes);
        this.mandates = mandates;
        for (int i = 0; i < votes.length; i++) {
            this.numberOfVotes += votes[i];
        }
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
     * Método que calcula a taxa de abstenção.
     * 
     * @return taxa de abstenção
     */
    @Override
    public String calculateAbstentionRate() {
        StringBuilder s = new StringBuilder();
        if(this.votes != null){
            double votesPercentage = 0.0;
            votesPercentage = (100.0 - (this.numberOfVotes * 100.0) / totalNumberOfVotes());
            s.append("A Taxa de abstenção: " + String.format("%.2f", votesPercentage) + "%\n");
            return s.toString();
        }
        s.append("Não existe votos carregados no programa.");
        return s.toString();
    }

    /**
     * Método que calcula o número de votos e a percetagem total dos votos de cada partido político 
     * para cada eleição.
     * 
     * @return número de votos e a percetagem total dos votos
     */
    @Override
    public String calculateMandates() {
        StringBuilder s = new StringBuilder();
        s.append(Mandate.calculateMandates(mandates, this.votes));
        return s.toString();
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
            s.append(party + ": " + votes + " (" + String.format("%.2f", percentage) + "%)\n");
        }
        return s.toString();
    }

}
