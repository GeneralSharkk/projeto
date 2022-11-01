package JavaFX.Autharcic;


import java.util.ArrayList;
import Reader.Reader;
import Votes.CountyVote;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * Classe que representa uma Tabela com todas as informações dos votos dos concelhos.
 * 
 * @author henri
 */
public class CouncilVotesView extends VBox{

    private TableView<CountyVote> councilView = new TableView<>();
    private Reader reader = new Reader();

    /**
     * Constroí uma Tabela com todas as informações dos votos dos concelhos.
     * 
     */
    public CouncilVotesView(){
        show();
    }

    /**
     * Método privado que cria toda a interface de uma Tabela com todas as informações dos votos dos concelhos.
     */
    private void show(){

        TableColumn<CountyVote, Integer> columnIdTable = new TableColumn<>("Table ID");
        columnIdTable.setCellValueFactory(new PropertyValueFactory<>("tableId"));

        TableColumn<CountyVote, String> columnCouncil = new TableColumn<>("Council");
        columnCouncil.setCellValueFactory(new PropertyValueFactory<>("council"));

        TableColumn<CountyVote, Integer> columnPoliticalParty = new TableColumn<>("Political Party");
        columnPoliticalParty.setCellValueFactory(new PropertyValueFactory<>("politicalParty"));

        TableColumn<CountyVote, Integer> columnNumberOfVotes = new TableColumn<>("Table Numbers");
        columnNumberOfVotes.setCellValueFactory(new PropertyValueFactory<>("numberOfVotes"));

        councilView.getColumns().add(columnIdTable);
        councilView.getColumns().add(columnCouncil);
        councilView.getColumns().add(columnPoliticalParty);
        councilView.getColumns().add(columnNumberOfVotes);

        ArrayList<CountyVote> tables = reader.readCountiesVotes();

        for(int i = 0; i < tables.size(); i++){
            councilView.getItems().add(tables.get(i));
        }
       
        //parishView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //setSpacing(5);
        getChildren().add(councilView);
        setAlignment(Pos.CENTER); 

    }
 
    
}
