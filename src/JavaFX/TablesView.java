package JavaFX;


import java.util.ArrayList;
import Info.Table;
import Reader.Reader;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * Classe que representa uma Tabela com todas as informações das mesas.
 * 
 * @author henri
 */
public class TablesView extends VBox{

    private TableView<Table> tablesList = new TableView<>();
    private Reader reader = new Reader();

    /**
     * Constroí uma Tabela com todas as informações das mesas.
     * 
     */
    public TablesView(){
        show();
    }

    /**
     * Método privado que cria toda a interface da Tabela com as informações das mesas.
     * 
     */
    private void show(){

        TableColumn<Table, Integer> columnIdTable = new TableColumn<>("ID");
        columnIdTable.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Table, Integer> columnCouncilId = new TableColumn<>("Council ID");
        columnCouncilId.setCellValueFactory(new PropertyValueFactory<>("councilId"));

        TableColumn<Table, String> columnCouncil = new TableColumn<>("Council");
        columnCouncil.setCellValueFactory(new PropertyValueFactory<>("council"));

        TableColumn<Table, Integer> columnTableNumber = new TableColumn<>("Table Number");
        columnTableNumber.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));

        TableColumn<Table, Integer> columnNumberOfVoters = new TableColumn<>("NºVoters");
        columnNumberOfVoters.setCellValueFactory(new PropertyValueFactory<>("numberOfVoters"));

        tablesList.getColumns().add(columnIdTable);
        tablesList.getColumns().add(columnCouncilId);
        tablesList.getColumns().add(columnCouncil);
        tablesList.getColumns().add(columnTableNumber);
        tablesList.getColumns().add(columnNumberOfVoters);

        ArrayList<Table> tables = reader.readTables();

        for(int i = 0; i < tables.size(); i++){
            tablesList.getItems().add(tables.get(i));
        }
        
        tablesList.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        setSpacing(4);
        getChildren().add(tablesList);
        setAlignment(Pos.CENTER); 

    }
 
    
}
