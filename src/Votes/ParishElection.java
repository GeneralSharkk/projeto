/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Votes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class que representa uma eleição para a Assembleia de Freguesia.
 * 
 * @author henri
 */
public class ParishElection{

    private ArrayList<ParishVote> votes;
    private HashMap<String, HashMap<String, Integer>> votesPerPolicticalParty;
    private int totalNumberOfVotes;

    /**
     * Construtor que cria um objeto para guardar os votos de uma eleição para a Assembleia de Freguesia.
     * Inicializa o ArrayList dos votos e o HashMap dos votos por partido,
     * e o total número de votos a 0.
     */
    public ParishElection(){
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
    public void setVotes(ArrayList<ParishVote> votes){
        this.votes = votes;
        calculateVotes(votes);
        calculateVotesPerPolicticalParty(votes);
    }

    /**
     * Método seletor dos votos por partido político.
     * 
     * @return HashMap de votos por partido político
     */
    public HashMap<String, HashMap<String, Integer>> getVotesPerPolicticalParty() {
        return votesPerPolicticalParty;
    }
    
    
    /**
     * Método seletor alternativo dos votos por partido político.
     * 
     * @return HashMap de votos por partido político
     */
    public HashMap<String, Integer> getVotesPerPolicticalPartyALT(){
        HashMap<String, Integer> temp = new HashMap<>();
        for(ParishVote p : votes){
            if(!temp.containsKey(p.getPoliticalParty())){
                temp.put(p.politicalParty, p.getNumberOfVotes());
            }else{
                int numberVotes = temp.get(p.getPoliticalParty()) + p.getNumberOfVotes();
                temp.put(p.getPoliticalParty(), numberVotes);
            }
        }
        
        return temp;
    }

    /**
     * Método privado que calcula o número total de votos.
     * 
     * @param votes ArrayList de votos
     */
    private void calculateVotes(ArrayList<ParishVote> votes){
        for(ParishVote p : votes){
            this.totalNumberOfVotes += p.getNumberOfVotes();
        }
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
    private void calculateVotesPerPolicticalParty(ArrayList<ParishVote> votes){
        HashMap<String, HashMap<String, Integer>> temp = new HashMap<>();
        for (ParishVote p : votes) {
            if(!temp.containsKey(p.council)){
                temp.put(p.getCouncil(), new HashMap<>());
                temp.get(p.getCouncil()).putAll(innerHashMap(p.getCouncil()));
            }
            else{
               temp.get(p.getCouncil()).putAll(innerHashMap(p.getCouncil()));
            }
        }
        this.votesPerPolicticalParty = temp;
    }

    /**
     * Método privado auxiliar para gerir o HashMap dentro o HashMap de votos.
     * 
     * @param council nome da freguesia
     * @return inner HashMap
     */
    private HashMap<String, Integer> innerHashMap(String council){
        HashMap<String, Integer> temp = new HashMap<>();
        for (ParishVote p : votes) {
            if(p.getCouncil().equals(council)){
                if(!temp.containsKey(p.getPoliticalParty())){
                    temp.put(p.getPoliticalParty(), p.getNumberOfVotes());
                }else{
                    int total = p.getNumberOfVotes() + temp.get(p.getPoliticalParty());
                    temp.put(p.getPoliticalParty(), total);
                }
            }
        }
        return temp;
    }

    /**
     * Método privado auxiliar para dar print a um HashMap.
     * 
     * @param map Hashmap que se quer dar print
     * @return String do Hashmap
     */
    private String printHashMap(HashMap<String, Integer> map){
        StringBuilder s = new StringBuilder();
        int allVotes = 0;
        for(int value : map.values()){
            allVotes += value;
        }
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            String politicalParty = i.getKey();
            int votes = i.getValue();
            double percentage = (votes * 100.0) / allVotes;
            s.append(politicalParty + " : " + votes + " votos (");
            s.append(String.format("%.2f", percentage)).append("% dos votos)\n");
        }
        s.append("Número de votos: " + allVotes + "\n");
        return s.toString();
    }

    /**
     * Método toString().
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("\n\tVotos da Assembleia de Freguesias\n\n");
        for (Map.Entry<String, HashMap<String, Integer>> i : votesPerPolicticalParty.entrySet()) {
            String council = i.getKey();
            HashMap<String, Integer> votes = i.getValue();
            s.append(council + "\n" + printHashMap(votes) + "\n");
        }
        s.append("Número Total de Votos: " + getNumberOfVotes() + "\n");
        return s.toString();
    }
}