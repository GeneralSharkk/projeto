package POOProjeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

import Info.Candidate;
import Info.Candidates;
import Info.Tables;
import Interfaces.PresidentialFunctionalities;
import Reader.Reader;

/**
 * Classe que corresponde a uma Eleição Presidencial.
 *
 * @author henri
 */
public class PresidentialElection implements PresidentialFunctionalities {

    private HashMap<String, Integer> votes;
    private int numberOfVotes;
    
    /**
     * Construtor que cria um objeto que corresponde a uma Eleição Presidencial com base nos candidatos.
     * 
     * 
     * @param candidates candidatos
     */
    public PresidentialElection(Candidates candidates){
        this.votes = setHashMap(candidates.getCandidates());
        for(Map.Entry<String, Integer> i : this.votes.entrySet()){
            this.numberOfVotes += i.getValue();
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
     * Método privado para dar set ao HashMap com os candidatos e os seus votos.
     * 
     * @param candidates candidatos
     * @return HashMap com os candidatos e os seus votos
     */
    private HashMap<String, Integer> setHashMap(ArrayList<Candidate> candidates){
        HashMap<String, Integer> temp = new HashMap<>();
        if(!candidates.isEmpty()){
            for (int i = 0; i < candidates.size(); i++) {
                temp.put(candidates.get(i).getName(), candidates.get(i).getNumberOfVotes());
            }
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
            votesPercentage = (double) (100 - (this.numberOfVotes * 100) / totalNumberOfVotes());
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
            votesPercentage = (double) (100 - (this.numberOfVotes * 100) / totalNumberOfVotes());
        }
        return votesPercentage;
    }

    /**
     * Método que calcula o número de votos e a percetagem total dos votos de cada partido político 
     * para cada eleição.
     * 
     * @return número de votos e a percetagem total dos votos
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

    /**
     * Método que determina, se possivel, o vencedor da eleição.
     * 
     * @return se houver, o vencedor da eleição
     */
    @Override
    public String declareWinner() {
        StringBuilder s = new StringBuilder();
        for(Map.Entry<String, Integer> i : this.votes.entrySet()){
            int votes = i.getValue();
            if(votes > (this.numberOfVotes/2)){
                double percentage = (votes * 100.0) / this.numberOfVotes;
                s.append(i.getKey()).append(" ganhou com ").append(String.format("%.2f", percentage)).append("% dos votos!!");
            }
        }
        if(s.isEmpty()){
            s.append("Não existe ninguem com mais de 50% dos votos. Será necessário um segundo volta.\n\n");
            s.append(secondRound());
            return s.toString();
        }
        return s.toString();
    }
     
    /**
     * Método privado para determinar quem ganha, se houver, na segunda rounda da eleição.
     * 
     * @return o vencedor
     */
    private String secondRound(){
        StringBuilder s = new StringBuilder();
        this.votes = sortByValue(this.votes);
        int counter = 0;
        for(Map.Entry<String, Integer> i : this.votes.entrySet()){
            if(counter < 2){
                s.append(i.getKey()).append(" ");
                counter++;
            }
        }
        s.append("estão na segunda rounda.\n");
        for (Map.Entry<String, Integer> i : this.votes.entrySet()) {
            s.append(i.getKey()).append(" ganhou na segunda rounda!\n");
            break;
        }
        return s.toString();
    }

    /**
     * Método privado para dar sort ao HashMap por values.
     * 
     * @param data
     * @return HashMap sorted
     */
    private HashMap<String, Integer> sortByValue(HashMap<String, Integer> data)
    {
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(data.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
}
