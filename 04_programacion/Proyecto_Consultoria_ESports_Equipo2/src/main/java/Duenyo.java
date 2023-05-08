public class Duenyo extends Usuario {
    private String nombre;

    public Duenyo(String nombre) {
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
