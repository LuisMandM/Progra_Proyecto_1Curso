package Consultoria.pack.Clases_Base;

/**
 * La clase `Usuario` representa un usuario en el sistema.
 */
public class Usuario {
    private int id_usuario;
    private String contrasenya;
    private String usuario;

    /**
     * Crea un nuevo objeto `Usuario` con los siguientes parámetros:
     *
     * @param id_usuario   El ID del usuario.
     * @param contrasenya  La contraseña del usuario.
     * @param usuario      El nombre de usuario.
     */
    public Usuario(int id_usuario, String contrasenya, String usuario) {
        this.id_usuario = id_usuario;
        this.contrasenya = contrasenya;
        this.usuario = usuario;
    }

    public Usuario() {

    }

    public Usuario(String contrasenya, String usuario) {
        this.contrasenya = contrasenya;
        this.usuario = usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return id_usuario +"-"+usuario;
    }
}
