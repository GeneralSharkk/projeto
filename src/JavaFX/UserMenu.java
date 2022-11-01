/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFX;

import Info.Candidate;
import Info.Candidates;
import Info.County;
import Info.Tables;
import JavaFX.Autharcic.PieChartCouncilVotes;
import JavaFX.Autharcic.PieChartDistrictVotes;
import JavaFX.Autharcic.PieChartParishVotes;
import JavaFX.European.PieChartEuropeanVotes;
import JavaFX.Presidential.PieChartPresidentialVotes;
import POOProjeto.AutharcicElection;
import POOProjeto.EuropeanElection;
import POOProjeto.PresidentialElection;
import Reader.Reader;
import Votes.CountyElection;
import Votes.DistrictElection;
import Votes.ParishElection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *  Classe que corresponde ao menu de utilizador User.
 * 
 * @author henri
 */
public class UserMenu extends GridPane{
    
    private Reader reader;
    private Tables tables;
    private AutharcicElection autharcicElection;
    private EuropeanElection europeanElection;
    private PresidentialElection presidentialElection;
    
    /**
     * Constroí um menu de utilizador User.
     * Vai chamar o método setUp() e show().
     * 
     */
    public UserMenu(){
        setUp();
        show();
    }
    
    /**
     * Método privado que vai criar toda a interface do menu de utilizador Manager.
     * 
     */
    private void show(){
        
        VBox districtBox = new VBox();
        districtBox.setAlignment(Pos.TOP_CENTER);
        districtBox.setPadding(new Insets(10));
        districtBox.setSpacing(10);
        
        Label autharcicLabel = new Label("District");
        autharcicLabel.setStyle("-fx-font-weight: bold");
        autharcicLabel.setFont(new Font("Arial", 20));
        autharcicLabel.setTextFill(Color.NAVY);
        
        Button b2 = new Button("Show Results");
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                stage.setTitle("District Results");
                Label label = new Label("District Results");
                label.setFont(new Font("Arial", 25));
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                vBox.setPadding(new Insets(10));
                vBox.setSpacing(10);
                vBox.getChildren().addAll(label, new PieChartDistrictVotes(autharcicElection));
                
                Scene scene = new Scene(vBox, 500, 450);
                
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        });
        
        districtBox.getChildren().addAll(autharcicLabel, b2);
        
        setPadding(new Insets(25));
        addColumn(0, districtBox);
        
        // -----------------------------------------------------------------------------------------------------------------------------------------
        
        VBox councilBox = new VBox();
        councilBox.setAlignment(Pos.TOP_CENTER);
        councilBox.setPadding(new Insets(10));
        councilBox.setSpacing(10);
        
        Label councilLabel = new Label("Council");
        councilLabel.setStyle("-fx-font-weight: bold");
        councilLabel.setFont(new Font("Arial", 20));
        councilLabel.setTextFill(Color.NAVY);
        
        Button b6 = new Button("Show Results");
        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                stage.setTitle("Council Results");
                Label label = new Label("Council Results");
                label.setFont(new Font("Arial", 25));
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                vBox.setPadding(new Insets(10));
                vBox.setSpacing(10);
                vBox.getChildren().addAll(label, new PieChartCouncilVotes(autharcicElection));
                
                Scene scene = new Scene(vBox, 500, 450);
                
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        });
        
        councilBox.getChildren().addAll(councilLabel, b6);
        
        setPadding(new Insets(25));
        addColumn(1, councilBox);
        
        // -----------------------------------------------------------------------------------------------------------------------------------------
        
        VBox parishBox = new VBox();
        parishBox.setAlignment(Pos.TOP_CENTER);
        parishBox.setPadding(new Insets(10));
        parishBox.setSpacing(10);
        
        Label parishLabel = new Label("Parish");
        parishLabel.setStyle("-fx-font-weight: bold");
        parishLabel.setFont(new Font("Arial", 20));
        parishLabel.setTextFill(Color.NAVY);

        Button b10 = new Button("Show Results");
        b10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                stage.setTitle("Parish Results");
                Label label = new Label("Parish Results");
                label.setFont(new Font("Arial", 25));
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                vBox.setPadding(new Insets(10));
                vBox.setSpacing(10);
                vBox.getChildren().addAll(label, new PieChartParishVotes(autharcicElection));
                
                Scene scene = new Scene(vBox, 500, 450);
                
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        });
        
        parishBox.getChildren().addAll(parishLabel, b10);
        
        setPadding(new Insets(25));
        addColumn(2, parishBox);
        
        // ------------------------------------------------------------------------------------------------------------------
        
        VBox europeanBox = new VBox();
        europeanBox.setAlignment(Pos.TOP_CENTER);
        europeanBox.setPadding(new Insets(10));
        europeanBox.setSpacing(10);
        
        Label europeanLabel = new Label("European");
        europeanLabel.setStyle("-fx-font-weight: bold");
        europeanLabel.setFont(new Font("Arial", 20));
        europeanLabel.setTextFill(Color.NAVY);
        
        Button b13 = new Button("Show Results");
        b13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                stage.setTitle("European Results");
                Label label = new Label("European Results");
                label.setFont(new Font("Arial", 25));
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                vBox.setPadding(new Insets(10));
                vBox.setSpacing(10);
                vBox.getChildren().addAll(label, new PieChartEuropeanVotes(europeanElection));
                
                Scene scene = new Scene(vBox, 500, 450);
                
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        });
        
        europeanBox.getChildren().addAll(europeanLabel, b13);
        
        setPadding(new Insets(25));
        addColumn(3, europeanBox);
        
        // ---------------------------------------------------------------------------------------------------------------------
        
        VBox presidentialBox = new VBox();
        presidentialBox.setAlignment(Pos.TOP_CENTER);
        presidentialBox.setPadding(new Insets(10));
        presidentialBox.setSpacing(10);
        
        Label presidentialLabel = new Label("Presidential");
        presidentialLabel.setStyle("-fx-font-weight: bold");
        presidentialLabel.setFont(new Font("Arial", 20));
        presidentialLabel.setTextFill(Color.NAVY);
        
        Button b16 = new Button("Show Results");
        b16.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                stage.setTitle("Presidential Results");
                Label label = new Label("Presidential Results");
                label.setFont(new Font("Arial", 25));
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                vBox.setPadding(new Insets(10));
                vBox.setSpacing(10);
                vBox.getChildren().addAll(label, new PieChartPresidentialVotes(presidentialElection));
                
                Scene scene = new Scene(vBox, 500, 450);
                
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        });
        
        presidentialBox.getChildren().addAll(presidentialLabel, b16);
        
        setPadding(new Insets(7));
        addColumn(4, presidentialBox);
        setStyle("-fx-background-color: #F5F6FA;");

        }
    
    /**
     * Método privado que vai inicializar todos os abributos e
     * vai colocar toda a informação necessária para as eleições.
     * 
     */
    private void setUp(){
        reader = new Reader();
        tables = new Tables();
        tables.setTables(reader.readTables());
        DistrictElection d = new DistrictElection();
        d.setVotes(reader.readDistrictVotes());
        CountyElection c = new CountyElection();
        c.setVotes(reader.readCountiesVotes());
        ParishElection p = new ParishElection();
        p.setVotes(reader.readParishesVotes());
        
        autharcicElection = new AutharcicElection(new County(""));
        autharcicElection.LoadTables(tables);
        autharcicElection.LoadVotes(c, d, p);
        
        String[] parties = {"Partido A", "Partido B", "Partido C", "Partido D", "Partido E"};
        int[] votes = {18842, 7343, 10523, 4652, 9241};
        int mandates = 19;
        
        europeanElection = new EuropeanElection(parties, votes, mandates);
        
        Candidate c1 = new Candidate("Joao", "1985-10-13", 8536);
        Candidate c2 = new Candidate("Henrique", "1985-10-13", 14526);
        Candidate c3 = new Candidate("Telmo", "1985-10-13", 5721);
        Candidate c4 = new Candidate("Rodrigo", "1985-10-13", 7164);
        Candidate c5 = new Candidate("Alexandre", "1985-10-13", 1393);
        
        Candidates cAll = new Candidates();
        cAll.addCandidate(c1);
        cAll.addCandidate(c2);
        cAll.addCandidate(c3);
        cAll.addCandidate(c4);
        cAll.addCandidate(c5);
        
        presidentialElection = new PresidentialElection(cAll);
    }
}

