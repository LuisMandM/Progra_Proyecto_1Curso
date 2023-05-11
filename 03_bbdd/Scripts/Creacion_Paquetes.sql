

 CREATE OR REPLACE PACKAGE VISUALIZACION_RESULTADOS IS
    
    PROCEDURE HISTORIAL_EQUIPO
    (P_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE, GANADOS OUT NUMBER,PERDIDOS OUT NUMBER, 
    EMPATE OUT NUMBER);
    
    PROCEDURE HISTORIAL_EQUIPO
    (P_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE, P_TEMPORADA IN CALENDARIO.ID_TEMPORADA%TYPE,
    GANADOS OUT NUMBER,PERDIDOS OUT NUMBER, 
    EMPATE OUT NUMBER);
    
    
 END;
 
 CREATE OR REPLACE PACKAGE BODY VISUALIZACION_RESULTADOS AS
 
    PROCEDURE HISTORIAL_EQUIPO
        (P_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE, GANADOS OUT NUMBER,PERDIDOS OUT NUMBER, 
        EMPATE OUT NUMBER)
        IS
        BEGIN
            
            SELECT COUNT(*) INTO GANADOS FROM PARTIDO WHERE GANADOR = P_EQUIPO;
            SELECT COUNT(*)INTO PERDIDOS FROM PARTIDO WHERE GANADOR != P_EQUIPO AND
            (EQUIPO_LOCAL = P_EQUIPO OR EQUIPO_VISITANTE = P_EQUIPO);
            SELECT COUNT(*) INTO EMPATE FROM PARTIDO WHERE GANADOR = -1 AND 
             (EQUIPO_LOCAL = P_EQUIPO OR EQUIPO_VISITANTE = P_EQUIPO);
            
            EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RAISE_APPLICATION_ERROR(-20381,'SIN DATOS');
        
    END HISTORIAL_EQUIPO;
 
     PROCEDURE HISTORIAL_EQUIPO
        (P_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE, P_TEMPORADA IN CALENDARIO.ID_TEMPORADA%TYPE,
        GANADOS OUT NUMBER,PERDIDOS OUT NUMBER, 
        EMPATE OUT NUMBER)
        IS
        
        BEGIN
            GANADOS := 0;
            PERDIDOS := 0;
            EMPATE := 0;
        
            FOR JORNADA_RECORD IN (SELECT GANADOR, MARCADOR_LOCAL, MARCADOR_VISITANTE, 
            EQUIPO_LOCAL, EQUIPO_VISITANTE FROM PARTIDO NATURAL JOIN JORNADA WHERE 
            ID_TEMPORADA = P_TEMPORADA AND 
            (EQUIPO_LOCAL = P_EQUIPO OR EQUIPO_VISITANTE = P_EQUIPO)) LOOP
            
                IF JORNADA_RECORD.GANADOR = P_EQUIPO THEN
                    GANADOS := GANADOS +1;
                ELSIF JORNADA_RECORD.GANADOR != P_EQUIPO THEN
                    PERDIDOS := PERDIDOS +1;
                ELSIF JORNADA_RECORD.GANADOR = -1 THEN
                    EMPATE := EMPATE + 1;
                    
                END IF;
            END LOOP;
            
            EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RAISE_APPLICATION_ERROR(-20382,'SIN DATOS');
        
    END HISTORIAL_EQUIPO;
     
 
 END;


-------- PAQUETE DE ACCIONES_ADMINISTRADOR --------


CREATE OR REPLACE PACKAGE Acciones_Administrador 
IS
PROCEDURE actualizar_resultado(p_id_partido IN NUMBER,marcador_loc NUMBER, marcador_visit NUMBER);
END;

CREATE OR REPLACE PACKAGE BODY Acciones_Administrador 
IS
PROCEDURE actualizar_resultado(p_id_partido IN NUMBER,marcador_loc NUMBER, marcador_visit NUMBER)
    IS
    p_ganador number := -1;
BEGIN
    IF marcador_loc > marcador_visit THEN
        SELECT equipo_local INTO p_ganador FROM partido WHERE id_partido = p_id_partido;
        ELSE 
        SELECT equipo_visitante INTO p_ganador FROM partido WHERE id_partido = p_id_partido;
        END IF;
        UPDATE partido SET ganador = p_ganador WHERE id_partido = p_id_partido;
    END actualizar_resultado;
END Acciones_Administrador;
