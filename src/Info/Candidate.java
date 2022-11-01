package Info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 *  Classe que representa um votande.
 * 
 * @author henri
 */
public class Candidate {
    
    private String name;
    private String dateOfBirth;
    private int numberOfVotes;

    /**
     * Construtor que cria um objeto que de um votantde com base no nome, data de nascimento e o número de votos.
     * 
     * @param name come
     * @param dateOfBirth data de nascimento
     * @param numberOfVotes número de votos
     */
    public Candidate(String name, String dateOfBirth, int numberOfVotes){
        this.dateOfBirth = (validDate(dateOfBirth)) ? dateOfBirth : "2002-10-09";
        this.name = name;
        this.numberOfVotes = numberOfVotes;
    }

    /**
     * Construtor que cria um objeto que de um votantde com base no nome e o número de votos.
     * 
     * @param name come
     * @param numberOfVotes número de votos
     */
    public Candidate(String name, int numberOfVotes){
        this.name = name;
        this.numberOfVotes = numberOfVotes;
        this.dateOfBirth = "";
    }

    /**
     * Método private para validar a data de nascimento.
     * 
     * @param dateOfBirth
     * @return validade
     */
    private boolean validDate(String dateOfBirth){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            formatter.parse(dateOfBirth);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Método seletor da idade.
     * 
     * @return idade
     */
    public int getAge(){
        return (int)ChronoUnit.YEARS.between(LocalDate.parse(this.dateOfBirth), LocalDate.now());
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
     * Método modificador do número de votos.
     * 
     * @param numberOfVotes número de votos
     */
    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    /**
     * Método seletor do nome.
     * 
     * @return nome
     */
    public String getName(){
        return this.name;
    }

    /**
     * Método seletor do número de votos.
     * 
     * @return número de votos
     */
    public int getNumberOfVotes(){
        return this.numberOfVotes;
    }

}
