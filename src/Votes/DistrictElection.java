/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Votes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class que representa uma eleição para a Assembleia Municipal.
 * 
 * @author henri
 */
public class DistrictElection{

    private ArrayList<DistrictVote> votes;
    private HashMap<String, Integer> votesPerPolicticalParty;
    private int totalNumberOfVotes;

    /**
     * Construtor que cria um objeto para guardar os votos de uma eleição para a Assembleia Municipal.
     * Inicializa o ArrayList dos votos e o HashMap dos votos por partido,
     * e o total número de votos a 0.
     */
    public DistrictElection(){
        this.votes = new ArrayList<>();
        this.votesPerPolicticalParty = new HashMap<>();
        this.totalNumberOfVotes = 0;
    }

    /**
     * Método seletor dos votos por partido político.
     * 
     * @return HashMap de votos por partido político
     */
    public HashMap<String, Integer> getVotesPerPolicticalParty() {
        return votesPerPolicticalParty;
    }

    /**
     * Método que recebe os votos e calcula o número total de votos e
     * o número de votos por partido político.
     * 
     * @param votes ArrayList de votos
     */
    public void setVotes(ArrayList<DistrictVote> votes){
        this.votes = votes;
        calculateVotes(votes);
        calculateVotesPerPolicticalParty(votes);
    }

    /**
     * Método privado que calcula o número total de votos.
     * 
     * @param votes ArrayList de votos
     */
    private void calculateVotes(ArrayList<DistrictVote> votes){
        for(DistrictVote d : votes){
            this.totalNumberOfVotes += d.getNumberOfVotes();
        }
    }

    /**
     * Método seletor do ArrayList de votos.
     * 
     * @return ArrayList de votos
     */
    public ArrayList<DistrictVote> getVotes() {
        return this.votes;
    }

    /**
     * Método seletor do número de votos.
     * 
     * @return número de votos.
     */
    public int getNumberOfVotes(){
        return this.totalNumberOfVotes;
    }

    /**
     * Método privado que calcula o número de votos por partido político.
     * 
     * @param votes ArrayList de votos
     */
    private void calculateVotesPerPolicticalParty(ArrayList<DistrictVote> votes){
        HashMap<String, Integer> temp = new HashMap<>();
        if(this.votesPerPolicticalParty.isEmpty()){
            for (DistrictVote d : votes) {
                if(!temp.containsKey(d.getPoliticalParty())){
                    temp.put(d.getPoliticalParty(), d.getNumberOfVotes());
                }else {
                    int numberVotes = temp.get(d.getPoliticalParty()) + d.getNumberOfVotes();
                    temp.put(d.getPoliticalParty(), numberVotes);
                }
            }
            this.votesPerPolicticalParty = temp;
        }
    }

    /**
     * Método toString().
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("\n\tVotos da Assembleia Municipal\n");
        int totalVotes = getNumberOfVotes();
        for (Map.Entry<String, Integer> i : votesPerPolicticalParty.entrySet()) {
            String politicalParty = i.getKey();
            int votes = i.getValue();
            double percentage = (double) (votes * 100) / totalVotes;
            s.append(politicalParty).append(": ").append(votes).append(" votos (");
            s.append(String.format("%.2f", percentage)).append("% dos votos)\n");
        }
        s.append("Número de Votos: " + getNumberOfVotes() + "\n");
        return s.toString();
    }
}
