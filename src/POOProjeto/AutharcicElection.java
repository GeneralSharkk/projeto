/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POOProjeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Hondt.Mandate;
import Info.County;
import Info.Parish;
import Info.Parishes;
import Info.Tables;
import Interfaces.AutharcicFunctionalities;
import Votes.CountyElection;
import Votes.DistrictElection;
import Votes.ParishElection;

/**
 * Classe que corresponde a uma Eleição Autárquica.
 *
 * @author henri
 */
public class AutharcicElection implements AutharcicFunctionalities{

    private County county;
    private Parishes parishes;
    private Tables tables;
    private CountyElection countiesVotes;
    private DistrictElection districtVotes;
    private ParishElection parishesVotes;

    /**
     * Construtor que cria um objeto que corresponde a uma Eleição Autárquica. com base no concelho.
     * 
     * @param county concelho
     */
    public AutharcicElection(County county){
        this.county = county;
        this.parishes = new Parishes();
    }

    /**
     * Método seletor do concelho.
     * 
     * @return concelho
     */
    public County getCounty(){
        return this.county;
    }

    /**
     * Método que vai carregar as mesas para o programa.
     * Também vai guardar todas as freguesias.
     * 
     */
    @Override
    public void LoadTables(Tables tables) {
        this.tables = tables;
        ArrayList<Parish> p = new ArrayList<>();
        ArrayList<String> s = this.tables.getCouncils();
        for (String string : s) {
            Parish parish = new Parish(string, this.county);
            p.add(parish);
        }
        this.parishes.setParishes(p);
    }

    /**
     * Método que carrega dos votos das eleiçóes para o programa.
     * Os votos só vão ser carregados se já existerem mesas guardadas no programa.
     * 
     * @param countiesVotes votos da Câmara Municipal
     * @param districtVotes votos da Assembleia Municipal
     * @param parishesVotes votos da Assembleia de Freguesia
     */
    @Override
    public void LoadVotes(CountyElection countiesVotes, DistrictElection districtVotes, ParishElection parishesVotes){
        if(this.tables != null){
            this.countiesVotes = countiesVotes;
            this.districtVotes = districtVotes;
            this.parishesVotes = parishesVotes;
        }

    }

    /**
     * Método que vai calcular a quantidade de votos por mesa.
     * Só vai ser calculado se houver mesas carregadas no programa.
     * 
     * @return string com o número da mesa e a quantidades de votos dessa mesa
     */
    @Override
    public String numberOfCandidatesPerTable(){
        StringBuilder s = new StringBuilder();
        if(this.tables != null){
            HashMap<Integer, Integer> temp = tables.getVotersPerTable();
            for (Map.Entry<Integer, Integer> i : temp.entrySet()) {
                int tableNumber = i.getKey();
                int votesNumbers = i.getValue();            
                s.append("Mesa nº").append(tableNumber).append(" : ").append(votesNumbers).append(" Votantes\n");                 
            }
            return s.toString();
        }
        s.append("Não existe mesas carregados no programa.");
        return s.toString();
    }

    /**
     * Método que calcula a taxa de abstenção.
     * 
     * @param option opcao
     * @return taxa de abstenção
     */
    @Override
    public String calculateAbstentionRate(int option) {
        StringBuilder s = new StringBuilder();
        if(this.districtVotes != null && this.countiesVotes != null && this.parishesVotes != null){
            int total = tables.getTotalVoters();
            switch(option){
                case 1 :
                    double districtPercentage = (100.0 - (this.districtVotes.getNumberOfVotes() * 100.0) / total);
                    s.append("Taxa de abstenção da Assembleia Municipal: ").append(String.format("%.2f", districtPercentage)).append("%\n");
                    break;
                case 2 :
                    double countiesPercentage = (100.0 - (this.countiesVotes.getNumberOfVotes() * 100.0) / total);
                    s.append("Taxa de abstenção da Câmara Municipal: ").append(String.format("%.2f", countiesPercentage)).append("%\n");
                    break;
                case 3 :
                    double parishesPercentage = (100.0 - (this.parishesVotes.getNumberOfVotes() * 100.0) / total);
                    s.append("Taxa de abstenção da Assembleia de Freguesia: ").append(String.format("%.2f", parishesPercentage)).append("%\n");
                    break;
            }
            return s.toString();
        }
        s.append("Não existe votos carregados no programa.");
        return s.toString();
    }
    
    /**
     * Método que calcula a taxa de abstenção e retorna em forma de Double.
     * 
     * @param option opcao
     * @return taxa de abstenção
     */
    @Override
    public double calculateAbstentionRateALT(int option){
        if(this.districtVotes != null && this.countiesVotes != null && this.parishesVotes != null){
            int total = tables.getTotalVoters();
            double temp = 0.0;
            switch(option){
                case 1 -> temp = (100.0 - (this.districtVotes.getNumberOfVotes() * 100.0) / total);
                case 2 -> temp = (100.0 - (this.countiesVotes.getNumberOfVotes() * 100.0) / total);
                case 3 -> temp = (100.0 - (this.parishesVotes.getNumberOfVotes() * 100.0) / total);
            }
            return temp;
        }
        return 0.0;
    }

    /**
     * Método que calcula o número de votos e a percetagem total dos votos de cada partido político 
     * para cada eleição.
     * 
     * @param option opcao
     * @return número de votos e a percetagem total dos votos
     */
    @Override
    public String numberOfVotesAndPercentage(int option){
        StringBuilder s = new StringBuilder();
        if(this.districtVotes != null && this.countiesVotes != null && this.parishesVotes != null){
            switch(option){
                case 1:
                    s.append(this.districtVotes.toString());
                    break;
                case 2:
                    s.append(this.countiesVotes.toString());
                    break;
                case 3:
                    s.append(this.parishesVotes.toString());
                    break;
            }
            return s.toString();
        }
        s.append("Não existe votos carregados no programa.");
        return s.toString();
    }
    
    /**
     * Método que vai retornar um HashMap com os partidos com chave e todos os seus votos como valor
     * 
     * @param option opcao
     * @return HashMap
     */
    @Override
    public HashMap<String, Integer> numberOfVotesPerPoliticalParty(int option){
        if(option == 1){
             return districtVotes.getVotesPerPolicticalParty();    
        }else if(option == 2){
            return countiesVotes.getVotesPerPolicticalParty();
        }else if (option == 3){
            return parishesVotes.getVotesPerPolicticalPartyALT();
        }
        return null;
    }

    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição.
     * 
     * @param option opcao
     * @return quantidade de mandatos
     */
    @Override
    public String calculateMandates(int option) {
        StringBuilder s = new StringBuilder();
        if(this.districtVotes != null && this.countiesVotes != null && this.parishesVotes != null){
            switch(option){
                case 1:
                    HashMap<String, Integer> district = this.districtVotes.getVotesPerPolicticalParty();
                    s.append("\n\tVotos da Assembleia Municipal\n");
                    s.append(Mandate.calculateMandates(27, district));
                    break;
                case 2:
                    HashMap<String, Integer> counties = this.countiesVotes.getVotesPerPolicticalParty();
                    s.append("\n\tVotos da Câmara Municipal\n");
                    s.append(Mandate.calculateMandates(11, counties));
                    break;
                case 3:
                    int count = 0;
                    int[] mandates = {19, 21, 25, 9, 9};
                    HashMap<String, HashMap<String, Integer>> parishes = this.parishesVotes.getVotesPerPolicticalParty();
                    s.append("\n\tVotos da Assembleia de Freguesias\n\n");
                    for (Map.Entry<String, HashMap<String, Integer>> i : parishes.entrySet()) {
                        HashMap<String, Integer> votes = i.getValue();
                        s.append(i.getKey()).append("\n");
                        s.append(Mandate.calculateMandates(mandates[count++], votes)).append("\n");
                    }
                    break;
            }
            return s.toString();   
        }
        s.append("Não existe votos carregados no programa.");
        return s.toString();
    }
    
    /**
     * Método que calcula a quantidade de mandatos de cada partido polítoco para cada eleição e retorna em forma de HashMap.
     * Esse HashMap vai ter o partido com chave e a quantidade de mandatos com valor.
     * 
     * @param option opcao
     * @return quantidade de mandatos
     */
    @Override
    public HashMap<String, Integer> calculateMandatesALT(int option) {
        if(this.districtVotes != null && this.countiesVotes != null && this.parishesVotes != null){
            HashMap<String, Integer> temp = new HashMap<>();
            switch(option){
                case 1:
                    HashMap<String, Integer> district = this.districtVotes.getVotesPerPolicticalParty();
                    temp = Mandate.calculateMandatesALT(27, district);
                    break;
                case 2:
                    HashMap<String, Integer> counties = this.countiesVotes.getVotesPerPolicticalParty();
                    temp = Mandate.calculateMandatesALT(11, counties);
                    break;
                case 3:
                    int count = 0;
                    int[] mandates = {19, 21, 25, 9, 9};
                    HashMap<String, HashMap<String, Integer>> parishes = this.parishesVotes.getVotesPerPolicticalParty();
                    for (Map.Entry<String, HashMap<String, Integer>> i : parishes.entrySet()) {
                        HashMap<String, Integer> votes = i.getValue();
                        if(temp.isEmpty()){
                            temp = Mandate.calculateMandatesALT(mandates[count++], votes);
                        }else{
                            HashMap<String, Integer> sum = Mandate.calculateMandatesALT(mandates[count++], votes);
                            for (Map.Entry<String, Integer> j : sum.entrySet()) {
                                int intSum = j.getValue() + temp.get(j.getKey());
                                temp.put(j.getKey(), intSum);
                            }
                        }
                    }
                    break;
            }
            return temp;
        }
        return null;
    }

}
