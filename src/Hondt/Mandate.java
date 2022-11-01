package Hondt;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

import java.util.HashMap;

/**
 *  Classe para calcular a quantidade de mandatos por partido político.
 * 
 * @author henri
 */
public class Mandate {
    
    /**
     * Método estático que calcula a quantidade de mandatos por partido político.
     * 
     * @param mandates mandatos
     * @param data votos
     * @return string com a quantidade de mantados por partido político.
     */
    public static String calculateMandates(int mandates, HashMap<String, Integer> data){
        StringBuilder s = new StringBuilder();

        int[] votes = data.values().stream().mapToInt(Integer::intValue).toArray();
        String[] partys = data.keySet().toArray(new String[data.keySet().size()]);
        int[] allocated = new int[votes.length];
        int[][] table = new int[mandates][votes.length];

        for (int i = 0; i < mandates; i++) {
            for (int j = 0; j < votes.length; j++) {
                if (i == 0){
                    table[i][j] = votes[j];
                }else{
                     table[i][j] = table[0][j]/(i+1);
                }
            }
        }

        int o = 0;
	    for (int i = 1; i < mandates + 1; i++) {
            o = Hondt.getMaxElement(table, votes.length, mandates);
            Hondt.drawDhondtTable(table, votes.length, mandates);
            allocated[o] = allocated[o] + 1;
	    }

        for (int i =0; i < votes.length; i++) {
            s.append(partys[i]).append(": ").append(allocated [i]).append(" Mandatos\n");
        }

        return s.toString();
    }
    
    /**
     * Método estático que calcula a quantidade de mandatos por partido político.
     * 
     * @param mandates mandatos
     * @param data votos
     * @return HashMap com os partidos e o numero de mandatos
     */
    public static HashMap<String, Integer> calculateMandatesALT(int mandates, HashMap<String, Integer> data){
        HashMap<String, Integer> temp = new HashMap<>();

        int[] votes = data.values().stream().mapToInt(Integer::intValue).toArray();
        String[] partys = data.keySet().toArray(new String[data.keySet().size()]);
        int[] allocated = new int[votes.length];
        int[][] table = new int[mandates][votes.length];

        for (int i = 0; i < mandates; i++) {
            for (int j = 0; j < votes.length; j++) {
                if (i == 0){
                    table[i][j] = votes[j];
                }else{
                     table[i][j] = table[0][j]/(i+1);
                }
            }
        }

        int o = 0;
	    for (int i = 1; i < mandates + 1; i++) {
            o = Hondt.getMaxElement(table, votes.length, mandates);
            Hondt.drawDhondtTable(table, votes.length, mandates);
            allocated[o] = allocated[o] + 1;
	    }

        for (int i =0; i < votes.length; i++) {
            temp.put(partys[i], allocated[i]);
        }

        return temp;
    }
}