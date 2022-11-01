package Info;

import java.util.ArrayList;

/**
 * Classe que guarda todos os candidatos acima dos 35 anos.
 */
public class Candidates {

    ArrayList<Candidate> candidates;
    
    /**
     * Construtor que cria um objeto para guardar os candidatos onde inicializa o ArrayList dos candidatos.
     */
    public Candidates(){
        this.candidates = new ArrayList<>();
    }

    /**
     * Método para adicionar um candidato ao ArrayList, se vai ser adiciona se tiver mais de 35 anos.
     * 
     * @param candidate candidato
     */
    public void addCandidate(Candidate candidate){
        if(candidate != null && getCandidateAge(candidate) >= 35){
            this.candidates.add(candidate);
        }
    }

    /**
     * Método seletor do ArrayList de candidatos.
     * 
     * @return ArrayList de candidatos
     */
    public ArrayList<Candidate> getCandidates(){
        if(!this.candidates.isEmpty()){
            return this.candidates;
        }
        return null;
    }

    /**
     * Método privado para obter a idade do candidato.
     * 
     * @param candidate candidato
     * @return idade do candidato
     */
    private int getCandidateAge(Candidate candidate){
        int age = 0;
        if(candidate != null){
            age = candidate.getAge();
        }
        return age;
    }
}
