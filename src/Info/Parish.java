package Info;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *  Class que representa um freguesia (subclass de County).
 * 
 * @author henri
 */

public class Parish extends County {

    private String name;

    /**
     * Constroí uma freguesia com base no nome e no concelho.
     * 
     * @param name nome
     * @param county concelho
     */
    public Parish(String name, County county) {
        super(county.getName(), new District(county.getDistrict()));
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
     * Método toString().
     */
    @Override
    public String toString() {
        return name;
    }

}
