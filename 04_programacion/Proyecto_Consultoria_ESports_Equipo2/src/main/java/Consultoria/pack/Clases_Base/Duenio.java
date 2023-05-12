package Consultoria.pack.Clases_Base;

public class Duenio extends Usuario {
    private String nombre;

    public Duenio(int id_duenio, String nombre, String usuario, String contrasenia) {
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
        return "Clases_Base.Duenyo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
