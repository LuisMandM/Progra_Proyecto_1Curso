public class Duenyo extends Usuario {
    private String nombre;

    public Duenyo(int id_dueño, String nombre, String usuario, String string) {
        super();
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
