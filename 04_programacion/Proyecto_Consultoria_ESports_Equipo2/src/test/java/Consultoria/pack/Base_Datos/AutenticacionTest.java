package Consultoria.pack.Base_Datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutenticacionTest {

    @Test
    void autorizacion() {
        assertEquals(Autenticacion.Autorizacion("",""), -800);
    }
}