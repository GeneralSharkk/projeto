package Info;

/**
 *  Class que representa uma mesa.
 * 
 * @author henri
 */
public class Table {
    
    private int id;
    private int councilId;
    private String council;
    private int tableNumber;
    private int numberOfVoters;

    /**
     * Construtor que cria uma mesa com base no id, id da freguesia, na freguesia, nº da mesa e o numero de votantes.
     * 
     * @param id id
     * @param councilId id da freguesia
     * @param council freguesia
     * @param tableNumber nº da mesa
     * @param numberOfVoters numero de votantes
     */
    public Table(int id, int councilId, String council, int tableNumber, int numberOfVoters){
        this.id = (id > 0) ? id : 1000;
        this.councilId = (councilId > 0) ? councilId : 1000;
        this.council = (council != null) ? council : "Sintra";
        this.tableNumber = (tableNumber > 0) ? tableNumber : 1000;
        this.numberOfVoters = (numberOfVoters > 0) ? numberOfVoters : 1000;
    }

    /**
     * Construtor que cria uma mesa sem parâmetros.
     */
    public Table(){}

    /**
     * Método seletor do nome.
     * 
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Método modificador do id.
     * 
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método modificador do id da freguesia.
     * 
     * @param councilId id da freguesia
     */
    public void setCouncilId(int councilId) {
        this.councilId = councilId;
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
     * Método modificador do nº da mesa.
     * 
     * @param tableNumber nº da mesa
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Método modificador do numero de votantes
     * 
     * @param numberOfVoters numero de votantes
     */
    public void setNumberOfVoters(int numberOfVoters) {
        this.numberOfVoters = numberOfVoters;
    }

    /**
     * Método seletor do id da freguesia.
     * 
     * @return id da freguesia
     */
    public int getCouncilId() {
        return this.councilId;
    }

    /**
     * Método seletor da freguesia.
     * 
     * @return freguesia
     */
    public String getCouncil() {
        return this.council;
    }

    /**
     * Método seletor do nº da mesa.
     * 
     * @return nº da mesa
     */
    public int getTableNumber() {
        return this.tableNumber;
    }

    /**
     * Método seletor do numero de votantes.
     * 
     * @return numero de votantes
     */
    public int getNumberOfVoters() {
        return this.numberOfVoters;
    }
    
    /**
     * Método toString().
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("ID: ");
        sb.append(getId()).append("\nIDJunta: ");
        sb.append(getCouncilId()).append(", Junta: ");
        sb.append(getCouncil()).append(", NºMesa: ");
        sb.append(getTableNumber()).append(", NºEletoreis: ").append(getNumberOfVoters()).append("\n\n");
        return sb.toString();
    }
}
