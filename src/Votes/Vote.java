package Votes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *  Classe abstrata que reprenta um voto.
 * 
 * @author henri
 */
public abstract class Vote {
    /**
     * id da mesa
     */
    protected int tableId;
    /**
     * concelho
     */
    protected String council;
    /**
     * partido politico
     */
    protected String politicalParty;
    /**
     * numero de votos
     */
    protected int numberOfVotes;

    /**
     * Construtor de uma eleiçao onde nao receber parâmetros.
     */
    public Vote(){}
    
    /**
     * Método seletor do id da mesa.
     * 
     * @return id da mesa
     */
    public int getTableId(){
        return this.tableId;
    }

    /**
     * Método seletor da freguesia.
     * 
     * @return freguesia
     */
    public String getCouncil(){
        return this.council;
    }

    /**
     * Método seletor do partido político.
     * 
     * @return partido político
     */
    public String getPoliticalParty(){
        return this.politicalParty;
    }

    /**
     * Método modificador do id da mesa.
     * 
     * @param tableId id da mesa
     */
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    /**
     * Método modificador da freguesia.
     * 
     * @param council freguesia
     */
    public void setCouncil(String council) {
        this.council = council;
    }

    /**
     * Método modificador do partido político.
     * 
     * @param politicalParty partido político
     */
    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    /**
     * Método seletor do número de votos.
     * 
     * @return número de votos
     */
    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    /**
     * Método modificador do número de votos.
     * 
     * @param numberOfVotes número de votos.
     */
    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
   
}
