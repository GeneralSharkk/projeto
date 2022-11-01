package Info;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Class que representa todas as mesas carregadas no programa.
 * 
 * @author henri
 */
public class Tables {

    private ArrayList<Table> tables;
    private int numberOfTables;

    /**
     * Construtor que cria um objeto que guarda as mesas.
     * Inicializa o ArrayList e o nº de mesas a 0.
     */
    public Tables(){
        this.tables = new ArrayList<>();
        this.numberOfTables = 0;
    }

    /**
     * Método seletor do ArrayList das mesas.
     * 
     * @return arrayList das mesas
     */
    public ArrayList<Table> getTables() {
        return tables;
    }

    /**
     * Método que calcula o total número de votos.
     * 
     * @return número de votos
     */
    public int getTotalVoters(){
        int total = 0;
        for (Table table : tables) {
            total += table.getNumberOfVoters();
        }
        return total;
    }

    /**
     * Método que calcula o número de votantes por mesa.
     * 
     * @return hashMap onde a key é o número da mesa e o value é o número de votantes
     */
    public HashMap<Integer, Integer> getVotersPerTable(){
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (Table table : tables) {
            if(!temp.containsKey(table.getTableNumber())){
                temp.put(table.getTableNumber(), table.getNumberOfVoters());
            }else if(temp.containsKey(table.getTableNumber())){
                int numberVotes = temp.get(table.getTableNumber()) + table.getNumberOfVoters();
                temp.put(table.getTableNumber(), numberVotes);
            }
        }
        return temp;
    }

    /**
     * Método que retorna um ArrayList com todas as freguesias.
     * 
     * @return ArrayList com as freguesias
     */
    public ArrayList<String> getCouncils(){
        ArrayList<String> temp = new ArrayList<>();
        for (Table table : tables) {
            if(!temp.contains(table.getCouncil())){
                temp.add(table.getCouncil());
            }
        }
        return temp;
    }

    /**
     * Método modificador do ArrayList das mesas
     * 
     * @param tables ArrayList das mesas
     */
    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
        numberOfTables = tables.size();
    }

    /**
     * Método seletor do número de mesas.
     * 
     * @return número de mesas
     */
    public int getNumberOfTables(){
        return this.numberOfTables;
    }

    /**
     * Método toString().
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Table table : tables) {
            sb.append(table.toString());
        }
        sb.append("Número de mesas: " + getNumberOfTables() + "\n");
        return sb.toString();
    }
    
}
