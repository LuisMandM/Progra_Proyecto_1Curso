public class Aministrador {

    private int id_admin;
    private String contrasenya;
    private String usuario;

    public Aministrador(int id_admin, String contrasenya, String usuario) {
        this.id_admin = id_admin;
        this.contrasenya = contrasenya;
        this.usuario = usuario;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
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
        return "Aministrador{" +
                "id_admin=" + id_admin +
                ", contrasenya='" + contrasenya + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
