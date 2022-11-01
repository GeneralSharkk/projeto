package Users;

/**
 * Enumerado que representa o tipo de utilizador.
 * @author henri
 */
public enum UserType {
    /**
     * Admin
     */
    ADMIN, 
    /**
     * Manager
     */
    MANAGER, 
    /**
     * User
     */
    USER;

    /**
     * Método toString do tipo de utilizador.
     * @return string
     */
    @Override
    public String toString(){
        return switch (this) {
            case ADMIN -> "Admin";
            case MANAGER -> "Manager";
            case USER -> "User";
            default -> "";
        };
    }
    
}
