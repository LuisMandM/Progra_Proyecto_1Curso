public class Duenyo extends Usuario {
    private String nombre;

    public Duenyo(int id_duenio, String nombre, String usuario, String contrasenia) {
        super(id_duenio,contrasenia,usuario);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Duenyo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
