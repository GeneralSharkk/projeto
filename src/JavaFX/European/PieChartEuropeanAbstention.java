/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFX.European;

import POOProjeto.EuropeanElection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

/**
 * Classe que representa um PieChart com as taxas de absencao das europeias.
 * 
 * @author henri
 */
public class PieChartEuropeanAbstention extends AnchorPane{
    
    private final EuropeanElection election;
    
    /**
     * Constroí um PieChart com as taxas de absencao das europeias.
     * 
     * @param election eleição
     */
    public PieChartEuropeanAbstention(EuropeanElection election){
        this.election = election;
        show();
    }
    
    /**
     * Método que cria toda a interface das taxas de absencao das europeias.
     */
    private void show(){
        final double percentageAb = election.calculateAbstentionRateALT();
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
