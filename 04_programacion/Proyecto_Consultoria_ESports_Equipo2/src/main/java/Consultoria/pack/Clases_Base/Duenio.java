package Consultoria.pack.Clases_Base;

import java.util.Objects;

/**
 * La clase `Duenio` es una subclase de `Usuario` y representa a un usuario con rol de dueño.
 */
public class Duenio extends Usuario {
    private String nombre;

    /**
     * Crea un nuevo objeto `Duenio` con los siguientes parámetros:
     *
     * @param id_duenio   El ID del dueño.
     * @param nombre      El nombre del dueño.
     * @param usuario     El nombre de usuario del dueño.
     * @param contrasenia La contraseña del dueño.
     */
    public Duenio(int id_duenio, String nombre, String usuario, String contrasenia) {
        super(id_duenio, contrasenia, usuario);
        this.nombre = nombre;
    }

    public Duenio(String nombre, String usuario, String contrasenya) {
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

    /**
     * Compara si el objeto actual es igual a otro objeto dado.
     *
     * @param o El objeto a comparar.
     * @return `true` si los objetos son iguales, `false` en caso contrario.
     */
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
