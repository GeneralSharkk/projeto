package JavaFX.Autharcic;


import java.util.ArrayList;
import Reader.Reader;
import Votes.DistrictVote;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * Classe que representa uma Tabela com todas as informações dos votos dos distritos.
 * 
 * @author henri
 */
public class DistrictVotesView extends VBox{

    private TableView<DistrictVote> districtView = new TableView<>();
    private Reader reader = new Reader();

    /**
     * Constroí uma Tabela com todas as informações dos votos dos distritos.
     * 
     */
    public DistrictVotesView(){
        show();
    }

    /**
     * Método privado que cria toda a interface de uma Tabela com todas as informações dos votos dos distritos.
     */
    private void show(){

        TableColumn<DistrictVote, Integer> columnIdTable = new TableColumn<>("Table ID");
        columnIdTable.setCellValueFactory(new PropertyValueFactory<>("tableId"));

        TableColumn<DistrictVote, String> columnCouncil = new TableColumn<>("Council");
        columnCouncil.setCellValueFactory(new PropertyValueFactory<>("council"));

        TableColumn<DistrictVote, Integer> columnPoliticalParty = new TableColumn<>("Political Party");
        columnPoliticalParty.setCellValueFactory(new PropertyValueFactory<>("politicalParty"));

        TableColumn<DistrictVote, Integer> columnNumberOfVotes = new TableColumn<>("Table Numbers");
        columnNumberOfVotes.setCellValueFactory(new PropertyValueFactory<>("numberOfVotes"));

        districtView.getColumns().add(columnIdTable);
        districtView.getColumns().add(columnCouncil);
        districtView.getColumns().add(columnPoliticalParty);
        districtView.getColumns().add(columnNumberOfVotes);

        ArrayList<DistrictVote> tables = reader.readDistrictVotes();

        for(int i = 0; i < tables.size(); i++){
            districtView.getItems().add(tables.get(i));
        }
       
        getChildren().add(districtView);
        setAlignment(Pos.CENTER); 

    }
 
    
}
