package Consultoria.pack.Clases_Base;

public class Usuario {
    private int id_usuario;
    private String contrasenya;
    private String usuario;

    public Usuario(int id_usuario, String contrasenya, String usuario) {
        this.id_usuario = id_usuario;
        this.contrasenya = contrasenya;
        this.usuario = usuario;
    }

    public Usuario() {

    }

    public Usuario(String nombreU, String contrasenya) {
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
        return "\n********************Usuario********************\n" +
                "-Id usuario: " + id_usuario + "\n" +
                "-Contraseña: " + contrasenya + "\n" +
                "-Usuario: " + usuario +
                "\n*********************************************\n";
    }
}
