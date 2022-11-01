package Info;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *  Class que representa um conselho (subclass de District).
 * 
 * @author henri
 */

public class County extends District {

    private String name;

    /**
     * Constroí um concelho com base no nome e no distrito.
     * 
     * @param name nome
     * @param district distrito
     */
    public County(String name, District district){
        super(district.getName());
        this.name = name;
    }

    /**
     * Constroí um concelho com base no nome.
     * 
     * @param name nome
     */
    public County(String name){
        super("");
        this.name = name;
    }

    /**
     * Método seletor do nome.
     */
    public String getName() {
        return name;
    }

    /**
     * Método modificador do nome.
     * 
     * @param name nome
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Método seletor do nome do distrito.
     * 
     * @return nome do distrito
     */
    public String getDistrict(){
        return super.getName();
    }
}
