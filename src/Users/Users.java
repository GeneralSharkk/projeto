package Users;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa todos os utilizadores.
 * 
 * @author henri
 */
public class Users {
    
    private HashMap<String, User> users;

    /**
     * Constroí um objeto que representa todos os utilizadores.
     * Vai inicializar um HashMap que tem como chave o numero de cartao de cidadao e 
     * como valor o utilizador com esse numero de cartao de cidadao.
     * 
     */
    public Users(){
        this.users = new HashMap<>();
    }

    /**
     * Método que cria um utilizador, e se nao existir nenhum utilizador com o numero de cartao de cidadao no HashMap,
     * este vai ser adicionado.
     * 
     * @param name nome
     * @param ccNumber numero de cartao de cidadao
     * @param dateofBirth data de nascimento
     * @param userType tipo de utilizador
     * @param password palavra-passe
     */
    public void addUser(String name, String ccNumber, LocalDate dateofBirth, String userType, String password){
        if(!existUserByCCNumber(ccNumber)){
            User user = new User(name, ccNumber, dateofBirth, userType, password);
            users.put(ccNumber, user);
        }
    }

    /**
     * Método privado que verifica que existe um certo numero de cartao de cidadao no HashMap
     * 
     * @param ccNumber numero de cartao de cidadao
     * @return true se existir
     */
    public boolean existUserByCCNumber(String ccNumber){
        if(users.containsKey(ccNumber)){
            return true;
        }
        return false;
    }
    
    /**
     * Método que verifica se existe um utilizador com base no nome e na palavra-passe para efetuar o login.
     * 
     * @param name nome
     * @param password nome
     * @return true se existir
     */
    public boolean existUserLogin(String name, String password){
        for (Map.Entry<String, User> entry : users.entrySet()) {
            User value = entry.getValue();
            if(value.getPassword().equals(password) && value.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método que retorna o tipo de um utilizador com base no nome e na palavra-passe desse utilizador.
     * Se não existir retorna null.
     * 
     * @param name nome
     * @param password nome
     * @return tipo de um utilizador se existir
     */
    public UserType getUserType(String name, String password){
        for (Map.Entry<String, User> entry : users.entrySet()) {
            User value = entry.getValue();
            if(value.getPassword().equals(password) && value.getName().equals(name)){
                return value.getUserType();
            }
        }
        return null;
    }
    
    /**
     * Método seletor do HashMap dos utilizadores.
     * 
     * @return HashMap
     */
    public HashMap<String, User> getUsers(){
        return this.users;
    }
}
