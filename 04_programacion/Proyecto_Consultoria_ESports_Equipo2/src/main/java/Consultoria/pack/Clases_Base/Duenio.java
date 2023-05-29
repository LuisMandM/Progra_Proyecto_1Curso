package Consultoria.pack.Clases_Base;

import java.util.Objects;

public class Duenio extends Usuario {
    private String nombre;

    public Duenio(int id_duenio, String nombre, String usuario, String contrasenia) {
        super(id_duenio,contrasenia,usuario);
        this.nombre = nombre;
    }

    public Duenio(String nombre, String usuario, String contrasenya) {
    }

    public Duenio(int id_dueño, String nombre) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return nombre;
    }

    //equals and Hascode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duenio duenio = (Duenio) o;
        return Objects.equals(nombre, duenio.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
