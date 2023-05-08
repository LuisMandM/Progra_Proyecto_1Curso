public class Duenyo {

    private int id_duenyo;
    private String nombre;
    private String contrasenya;
    private String usuario;

    public Duenyo(int id_duenyo, String nombre, String contrasenya, String usuario) {
        this.id_duenyo = id_duenyo;
        this.nombre = nombre;
        this.contrasenya = contrasenya;
        this.usuario = usuario;
    }

    public int getId_duenyo() {
        return id_duenyo;
    }

    public void setId_duenyo(int id_duenyo) {
        this.id_duenyo = id_duenyo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Duenyo{" +
                "id_duenyo=" + id_duenyo +
                ", nombre='" + nombre + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
