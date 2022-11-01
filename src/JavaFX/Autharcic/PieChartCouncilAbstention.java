/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFX.Autharcic;

import POOProjeto.AutharcicElection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

/**
 * Classe que representa um PieChart com as taxas de absencao dos concelhos.
 * 
 * @author henri
 */
public class PieChartCouncilAbstention extends AnchorPane{
    
    private final AutharcicElection election;
    
    /**
     * Constroí um PieChart com as taxas de absencao dos concelhos.
     * 
     * @param election eleição
     */
    public PieChartCouncilAbstention(AutharcicElection election){
        this.election = election;
        show();
    }
    
    /**
     * Método que cria toda a interface das taxas de absencao dos concelhos.
     */
    private void show(){
        final double percentageAb = election.calculateAbstentionRateALT(2);
        final double percentageNotAb = 100.0 - percentageAb;
        ObservableList<PieChart.Data> pieChartInfo = FXCollections.observableArrayList();
        
        pieChartInfo.add(new PieChart.Data("Taxa de absenção", percentageAb));
        pieChartInfo.add(new PieChart.Data("Taxa de presença", percentageNotAb));
        
        PieChart pieChart = new PieChart(pieChartInfo);
        pieChart.setStartAngle(20);
        pieChart.setLegendSide(Side.LEFT);
        
        getChildren().add(pieChart);
        
        pieChart.getData().forEach(data -> {
            String percentage = String.format("%.2f%%", (data.getPieValue()));
            Tooltip tooltip = new Tooltip(percentage);
            Tooltip.install(data.getNode(), tooltip);
        });
    }
       
}

