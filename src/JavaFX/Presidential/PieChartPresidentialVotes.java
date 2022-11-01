/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFX.Presidential;

import POOProjeto.PresidentialElection;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

/**
 * Classe que representa um PieChart com os votos de todos os partidos das presidenciais.
 * 
 * @author henri
 */
public class PieChartPresidentialVotes extends AnchorPane{
    
    private final PresidentialElection election;
    
    /**
     * Constroí um PieChart com os votos de todos os partidos das presidenciais.
     * 
     * @param election eleição
     */
    public PieChartPresidentialVotes(PresidentialElection election){
        this.election = election;
        show();
    }
    
    /**
     * Método que cria toda a interface dos votos de todos os partidos das presidenciais.
     */
    private void show(){
        HashMap<String, Integer> temp = election.getVotes();
        ObservableList<PieChart.Data> pieChartInfo = FXCollections.observableArrayList();
        
        int allVotes = 0;
        for(Map.Entry<String, Integer> i : temp.entrySet()){
            pieChartInfo.add(new PieChart.Data(i.getKey(), i.getValue()));
            allVotes += i.getValue();
        }
        
        final int allVotesF = allVotes;
        
        PieChart pieChart = new PieChart(pieChartInfo);
        pieChart.setStartAngle(20);
        pieChart.setLegendSide(Side.LEFT);
        
        getChildren().add(pieChart);
        
        pieChart.getData().forEach(data -> {
            String percentage = String.format("%.2f%%", (data.getPieValue() / allVotesF) * 100);
            Tooltip tooltip = new Tooltip(percentage);
            Tooltip.install(data.getNode(), tooltip);
        });
        
    }
}
