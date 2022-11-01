package JavaFX.Autharcic;


import java.util.ArrayList;
import Reader.Reader;
import Votes.ParishVote;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * Classe que representa uma Tabela com todas as informações dos votos das freguesias.
 * 
 * @author henri
 */
public class ParishVotesView extends VBox{

    private TableView<ParishVote> parishView = new TableView<>();
    private Reader reader = new Reader();

    /**
     * Constroí uma Tabela com todas as informações dos votos das freguesias.
     * 
     */
    public ParishVotesView(){
        show();
    }

    /**
     * Método privado que cria toda a interface de uma Tabela com todas as informações dos votos das freguesias.
     */
    private void show(){

        TableColumn<ParishVote, Integer> columnIdTable = new TableColumn<>("Table ID");
        columnIdTable.setCellValueFactory(new PropertyValueFactory<>("tableId"));

        TableColumn<ParishVote, String> columnCouncil = new TableColumn<>("Council");
        columnCouncil.setCellValueFactory(new PropertyValueFactory<>("council"));

        TableColumn<ParishVote, Integer> columnPoliticalParty = new TableColumn<>("Political Party");
        columnPoliticalParty.setCellValueFactory(new PropertyValueFactory<>("politicalParty"));

        TableColumn<ParishVote, Integer> columnNumberOfVotes = new TableColumn<>("Table Numbers");
        columnNumberOfVotes.setCellValueFactory(new PropertyValueFactory<>("numberOfVotes"));

        parishView.getColumns().add(columnIdTable);
        parishView.getColumns().add(columnCouncil);
        parishView.getColumns().add(columnPoliticalParty);
        parishView.getColumns().add(columnNumberOfVotes);

        ArrayList<ParishVote> tables = reader.readParishesVotes();

        for(int i = 0; i < tables.size(); i++){
            parishView.getItems().add(tables.get(i));
        }
       
        //parishView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //setSpacing(5);
        getChildren().add(parishView);
        setAlignment(Pos.CENTER); 

    }
 
    
}
