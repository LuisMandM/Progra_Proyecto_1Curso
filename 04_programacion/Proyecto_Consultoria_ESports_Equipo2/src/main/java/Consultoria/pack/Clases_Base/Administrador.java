package Consultoria.pack.Clases_Base;

/**
 * La clase `Administrador` es una subclase de `Usuario` y representa a un usuario con rol de administrador.
 */
public class Administrador extends Usuario {

    /**
     * Crea un nuevo objeto `Administrador` con los siguientes parámetros:
     *
     * @param id_usuario  El ID del usuario.
     * @param contrasenya La contraseña del usuario.
     * @param usuario     El nombre de usuario.
     */
    public Administrador(int id_usuario, String contrasenya, String usuario) {
        super(id_usuario, contrasenya, usuario);
    }
}
