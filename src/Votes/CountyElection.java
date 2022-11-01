/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Votes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class que representa uma eleição para a Câmara Municipal.
 * 
 * @author henri
 */
public class CountyElection{

    private ArrayList<CountyVote> votes;
    private HashMap<String, Integer> votesPerPolicticalParty;
    private int totalNumberOfVotes;

    /**
     * Construtor que cria um objeto para guardar os votos de uma eleição para a Câmara Municipal.
     * Inicializa o ArrayList dos votos e o HashMap dos votos por partido,
     * e o total número de votos a 0.
     */
    public CountyElection(){
        this.votes = new ArrayList<>();
        this.votesPerPolicticalParty = new HashMap<>();
        this.totalNumberOfVotes = 0;
    }

    /**
     * Método que recebe os votos e calcula o número total de votos e
     * o número de votos por partido político.
     * 
     * @param votes ArrayList de votos
     */
    public void setVotes(ArrayList<CountyVote> votes){
        this.votes = votes;
        calculateVotes(votes);
        calculateVotesPerPolicticalParty(votes);
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
     * Método seletor do ArrayList de votos.
     * 
     * @return ArrayList de votos
     */
    public ArrayList<CountyVote> getVotes() {
        return this.votes;
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
     * Método seletor do número de votos.
     * 
     * @return número de votos
     */
    public int getTotalNumberOfVotes() {
        return totalNumberOfVotes;
    }

    /**
     * Método que calcula o número total de votos.
     * 
     * @param votes ArrayList de votos
     */
    private void calculateVotes(ArrayList<CountyVote> votes){
        for(CountyVote d : votes){
            this.totalNumberOfVotes += d.getNumberOfVotes();
        }
    }

    /**
     * Método que calcula o número de votos por partido político.
     * 
     * @param votes ArrayList de votos
     */
    private void calculateVotesPerPolicticalParty(ArrayList<CountyVote> votes){
        HashMap<String, Integer> temp = new HashMap<>();
        if(votesPerPolicticalParty.isEmpty()){
            for (CountyVote c : votes) {
                if(!temp.containsKey(c.getPoliticalParty())){
                    temp.put(c.getPoliticalParty(), c.getNumberOfVotes());
                }else {
                    int numberVotes = temp.get(c.getPoliticalParty()) + c.getNumberOfVotes();
                    temp.put(c.getPoliticalParty(), numberVotes);
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
        s.append("\n\tVotos da Câmara Municipal\n");
        int totalVotes = getNumberOfVotes();
        for (Map.Entry<String, Integer> i : votesPerPolicticalParty.entrySet()) {
            String politicalParty = i.getKey();
            int votes = i.getValue();
            double percentage = (double) (votes * 100) / totalVotes;
            s.append(politicalParty).append(": ").append(votes).append(" votos (");
            s.append(String.format("%.2f", percentage)).append("% dos votos)\n");
        }
        s.append("Número total de votos: " + getNumberOfVotes() + "\n");
        return s.toString();
    }

}