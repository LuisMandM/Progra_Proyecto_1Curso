--Script de Registro de Triggers almacenados.







/*
Trigger en tabla Jugador Usado para evitar que el 
sueldo incumpla la restriccion de ser menor que el salario minimo interprofesional
*/
CREATE OR REPLACE TRIGGER CONTROL_SALARIOS
BEFORE INSERT OR UPDATE OF SUELDO ON JUGADOR
FOR EACH ROW
BEGIN
IF :NEW.SUELDO < 1080 THEN
    RAISE_APPLICATION_ERROR(-20100, 'VALOR DE SALARIO INCORRECTO, 
    NO PUEDE SER MENOR A 1080€');
END IF;
END;
