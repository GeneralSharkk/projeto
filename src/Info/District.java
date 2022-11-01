package Info;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *  Class que representa um conselho (superclass).
 * 
 * @author henri
 */

public class District {

    private String name;

    /**
     * Constroí um distrito com base no nome.
     * 
     * @param name nome
     */
    public District(String name){
        this.name = name;
    }

    /**
     * Método seletor do nome.
     * 
     * @return nome
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método modificador do nome.
     * 
     * @param name nome
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
