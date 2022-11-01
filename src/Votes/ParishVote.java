/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Votes;

/**
 *  Classe que representa um voto para a Assembleia de Freguesia.
 * 
 * @author henri
 */
public class ParishVote extends Vote {

    /**
     * Construtor que cria um objeto de uma eleicão para a Assembleia de Freguesia.
     */
    public ParishVote(){}

    /**
     * Método seletor da freguesia.
     * 
     * @return freguesia
     */
    @Override
    public String getCouncil() {
        return super.getCouncil();
    }

    /**
     * Método seletor do partido político.
     * 
     * @return partido político
     */
    @Override
    public String getPoliticalParty() {
        return super.getPoliticalParty();
    }

    /**
     * Método seletor do id da mesa.
     * 
     * @return id da mesa
     */
    @Override
    public int getTableId() {
        return super.getTableId();
    }

    /**
     * Método modificador da freguesia.
     * 
     * @param council freguesia
     */
    @Override
    public void setCouncil(String council) {
        super.setCouncil(council);
    }

    /**
     * Método modificador do partido político.
     * 
     * @param politicalParty partido político
     */
    @Override
    public void setPoliticalParty(String politicalParty) {
        super.setPoliticalParty(politicalParty);
    }

    /**
     * Método modificador do id da mesa.
     * 
     * @param tableId id da mesa
     */
    @Override
    public void setTableId(int tableId) {
        super.setTableId(tableId);
    }

    /**
     * Método seletor do número de votos.
     * 
     * @return número de votos
     */
    @Override
    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    /**
     * Método modificador do número de votos.
     * 
     * @param numberOfVotes número de votos.
     */
    @Override
    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
    
    /**
     * Método toString().
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("NºMesa: ");
        sb.append(getTableId() + "\nJunta: ");
        sb.append(getCouncil() + "\nPartido: ");
        sb.append(getPoliticalParty() + "\nNºVotos Assembleia: ");
        sb.append(getNumberOfVotes() + "\n\n");
        return sb.toString();
    }
}
