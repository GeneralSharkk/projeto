package Hondt;

import java.text.DecimalFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *  Classe do Método de Hondt
 *  https://github.com/conorgilmer/Dhondt/blob/master/dhondt.java
 *
 * @author henri
 */
public class Hondt {

    /**
     * Método estático que encontra o maior valor no array bidimensional e o remove.
     * Retorna no fim a linha desse valor no array.
     * 
     * @param dTable array com os valores
     * @param pN votos
     * @param pM mandatos
     * @return linha do maior valor
     */
    public static int getMaxElement(int [][]dTable, int pN, int pM){
        double maxValue = dTable[0][0];
        int i =0, j =0;
        for (int sn = 0; sn < pN; sn++) {
            for (int sm = 0; sm < pM; sm++) {
                if(dTable[sm][sn] > maxValue){
                    maxValue = dTable[sm][sn];
                    i =sm;
                    j = sn;
                }
            }
        }
        dTable[i][j] = 0;
        return j;
	}

    /**
     * Método estático que cria a tabela de Hondt.
     * 
     * @param dTable array com os valores
     * @param pN votos
     * @param pM mandatos
     */
    public static void drawDhondtTable(int [][]dTable ,int pN, int pM) {
		String row = "";		
		DecimalFormat df = new DecimalFormat();		
		df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		for (int n = 0; n < pN; n++) {
			for (int m = 0; m < pM; m++) {
				row = row + df.format(dTable[m][n]) + ", ";
			}
			row = row + "\n";
		}
	}
    
}
