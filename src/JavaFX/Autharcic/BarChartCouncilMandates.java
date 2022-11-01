/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFX.Autharcic;

import POOProjeto.AutharcicElection;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * Classe que representa um BarChart com os mandatos de todos os partidos dos concelhos.
 * 
 * @author henri
 */
public class BarChartCouncilMandates extends AnchorPane{
    
    private final AutharcicElection election;
    
    /**
     * Constroí um BarChart com os mandatos de todos os partidos dos concelhos.
     * 
     * @param election eleição
     */
    public BarChartCouncilMandates(AutharcicElection election){
        this.election = election;
        show();
    }
    
    /**
     * Método que cria toda a interface dos mandatos de todos os partidos dos concelhos.
     */
    private void show(){
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Political Partys");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Mandates");
        
        BarChart barChart = new BarChart(xAxis, yAxis);
        
        XYChart.Series barChartData = new XYChart.Series();
        barChartData.setName("NºMandates");
        
        HashMap<String, Integer> map = election.calculateMandatesALT(2);
        
        for(Map.Entry<String, Integer> i : map.entrySet()){
            barChartData.getData().add(new XYChart.Data(i.getKey(), i.getValue()));
        }
        
        barChart.getData().addAll(barChartData);
        getChildren().add(barChart);
    }
}
