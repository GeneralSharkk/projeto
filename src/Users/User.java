package Users;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe que representa um utilizador.
 * 
 * @author henri
 */
public class User {

    private String name;
    private String ccNumber;
    private LocalDate dateOfBirth;
    private int age;
    private UserType userType;
    private String password;

    /**
     * Constroí um utilizador com base no nome, número de cartao de cidadao, data de
     * nascimento, tipo de utilizador e palavra-passe.
     * Se alguma informação não for aceite, da-se se throw a um erro,
     * IllegalArgumentException.
     * 
     * @param name        nome
     * @param ccNumber    número de cartao de cidadao
     * @param dateofBirth data de nascimento
     * @param userType    tipo de utilizador
     * @param password    palavra-passe
     * @throws IllegalArgumentException e
     */
    public User(String name, String ccNumber, LocalDate dateofBirth, String userType, String password)
            throws IllegalArgumentException {
        if (validName(name) && validCCNumber(ccNumber) && validDate(dateofBirth) && validPassword(password)
                && setType(userType)) {
            this.name = name;
            this.ccNumber = ccNumber;
            this.dateOfBirth = dateofBirth;
            this.age = Period.between(dateofBirth, LocalDate.now()).getYears();
            this.password = password;
        } else {
            throw new IllegalArgumentException();
        }

    }

    /**
     * 
     * @param name
     * @return
     */
    private boolean validName(String name){
        if(name.isBlank() || name.isEmpty() || name == null || name.length() < 1 || name.length() > 50){
            return false;
        }

        for(int i = 0; i < name.length(); i++){
            if(Character.isDigit(name.charAt(i))){
                return false;
            }
        }

        return true;
    }

    /**
     * Método privado que verificar se o número de cartao de cidadao nao é branco,
     * nao é vazio, tem 8 letras e todas as letras são digitos.
     * 
     * @param ccNumber
     * @return
     */
    private boolean validCCNumber(String number) {

        final int max = 9;
        // check if is numeric and has 9 numbers
        if (!number.matches("[0-9]+") || number.length() != max)
            return false;
        int checkSum = 0;
        // calculate checkSum
        for (int i = 0; i < max - 1; i++) {
            checkSum += (number.charAt(i) - '0') * (max - i);
        }
        int checkDigit = 11 - (checkSum % 11);
        // if checkDigit is higher than 9 set it to zero
        if (checkDigit > 9)
            checkDigit = 0;
        // compare checkDigit with the last number of NIF
        return checkDigit == number.charAt(max - 1) - '0';

    }

    /**
     * 
     * @param dOB
     * @return
     */
    private boolean validDate(LocalDate dOB) {
        if (dOB == null) {
            return false;
        }

        if (Period.between(dOB, LocalDate.now()).getYears() < 18) {
            return false;
        }

        return true;
    }

    /**
     * 
     * @param password
     * @return
     */
    private boolean validPassword(String password) {
        if (password.isBlank() || password.isEmpty() || password == null || password.length() < 8) {
            return false;
        }

        boolean upper = false;
        boolean num = false;
        for (int i = 0; i <= password.length(); i++) {
            if (i == password.length()) {
                return false;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                upper = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                num = true;
            }

            if (upper && num) {
                break;
            }
        }
        return true;
    }

    /**
     * 
     * @param userType
     * @return
     */
    private boolean setType(String userType) {

        switch (userType) {
            case "Admin":
                this.userType = UserType.ADMIN;
                return true;
            case "Manager":
                this.userType = UserType.MANAGER;
                return true;
            case "User":
                this.userType = UserType.USER;
                return true;
            default:
                return false;
        }

    }

    /**
     * Método seletor do nome.
     * 
     * @return nome
     */
    public String getName() {
        return name;
    }

    /**
     * Método modificador do nome
     * 
     * @param name nome
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método seletor do numero de cartao de cidadao.
     * 
     * @return numero de cartao de cidadao
     */
    public String getCcNumber() {
        return ccNumber;
    }

    /**
     * Método modificador do numero de cartao de cidadao.
     * 
     * @param ccNumber numero de cartao de cidadao
     */
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    /**
     * Método seletor da data de nascimento.
     * 
     * @return data de nascimento
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Método modificador da data de nascimento.
     * 
     * @param dateOfBirth data de nascimento
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Método seletor da idade.
     * 
     * @return idade
     */
    public int getAge() {
        return age;
    }

    /**
     * Método modificador da idade.
     * 
     * @param age idade
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Método seletor do tipo de utilizador.
     * 
     * @return tipo de utilizador
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Método modificador do tipo de utilizador.
     * 
     * @param userType tipo de utilizador
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Método seletor da palavra-passe.
     * 
     * @return palavra-passe
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método modificador da palavra-passe.
     * 
     * @param password palavra-passe
     */
    public void setPassword(String password) {
        this.password = password;
    }

}