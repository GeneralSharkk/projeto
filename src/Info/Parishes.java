package Info;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

import java.util.ArrayList;

/**
 *  Class que representa todas as freguesias guardados no programa.
 * 
 * @author henri
 */
public class Parishes {
    
    private ArrayList<Parish> parishes;
    
    /**
     * Constroí um objeto do tipo Parishes onde vai guardar todas as freguesias.
     * Inicializa o ArrayList parishes.
     */
    public Parishes(){
        this.parishes = new ArrayList<>();
    }

    /**
     * Método que aceita as freguesias que guarda no ArrayList.
     * 
     * @param parishes arrayList de freguesias
     */
    public void setParishes(ArrayList<Parish> parishes){
        this.parishes = parishes;
    }

    /**
     * Método toString().
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Parish parish : parishes) {
            s.append(parish.toString() + "\n");
        }
        return s.toString();
    }
}
