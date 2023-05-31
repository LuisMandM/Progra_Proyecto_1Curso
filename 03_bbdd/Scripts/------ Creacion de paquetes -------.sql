------ Creacion de paquetes --------

 CREATE OR REPLACE PACKAGE VISUALIZACION_RESULTADOS IS
    TYPE PACK_CURSOR IS REF CURSOR;
    FUNCTION EQUIPO_EXISTS (EQUI EQUIPO.ID_EQUIPO%TYPE)RETURN BOOLEAN;
    
    PROCEDURE HISTORIAL_EQUIPO
    (P_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE, GANADOS OUT NUMBER,PERDIDOS OUT NUMBER, 
    EMPATE OUT NUMBER);
    
    PROCEDURE HISTORIAL_EQUIPO
    (P_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE, P_TEMPORADA IN CALENDARIO.ID_TEMPORADA%TYPE,
    GANADOS OUT NUMBER,PERDIDOS OUT NUMBER, 
    EMPATE OUT NUMBER);
    
    PROCEDURE clasificacion (resul_out out PACK_CURSOR);
    
    PROCEDURE RESULTADOS_DE_LA_JORNADA
    (P_NUMJORNADA PARTIDO.JORNADA%TYPE,P_RESULT_CURSOR OUT PACK_CURSOR);

 END;
 
 CREATE OR REPLACE PACKAGE BODY VISUALIZACION_RESULTADOS AS
 
 
    FUNCTION EQUIPO_EXISTS (EQUI EQUIPO.ID_EQUIPO%TYPE)RETURN BOOLEAN
    IS 
    V_TRASLADO EQUIPO.ID_EQUIPO%TYPE;
    BEGIN
        SELECT ID_EQUIPO INTO V_TRASLADO FROM EQUIPO WHERE ID_EQUIPO = EQUI;
        IF V_TRASLADO IS NOT NULL THEN
            RETURN TRUE;
        END IF;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN FALSE;
        END EQUIPO_EXISTS;
 
    PROCEDURE HISTORIAL_EQUIPO
        (P_EQUIPO IN EQUIPO.ID_EQUIPO%TYPE, GANADOS OUT NUMBER,PERDIDOS OUT NUMBER, 
        EMPATE OUT NUMBER)
        IS
        NO_EXISTS EXCEPTION;
        BEGIN
            
            IF EQUIPO_EXISTS(P_EQUIPO) THEN
                SELECT COUNT(*) INTO GANADOS FROM PARTIDO WHERE GANADOR = P_EQUIPO;
                SELECT COUNT(*)INTO PERDIDOS FROM PARTIDO WHERE GANADOR != P_EQUIPO AND
                (EQUIPO_LOCAL = P_EQUIPO OR EQUIPO_VISITANTE = P_EQUIPO);
                SELECT COUNT(*) INTO EMPATE FROM PARTIDO WHERE GANADOR = -1 AND 
                 (EQUIPO_LOCAL = P_EQUIPO OR EQUIPO_VISITANTE = P_EQUIPO);
            ELSE 
                RAISE NO_EXISTS;
            END IF;
            EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RAISE_APPLICATION_ERROR(-20381,'SIN DATOS');
            WHEN NO_EXISTS THEN
                RAISE_APPLICATION_ERROR(-20382,'EQUIPO INEXISTENTE');
        
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
    
    
    PROCEDURE clasificacion
        (resul_out out PACK_CURSOR)
        IS
        BEGIN
            OPEN resul_out FOR
                SELECT equi.nombre, equi.id_equipo, COUNT(parti.ganador) AS "NUM_GANADOS" FROM equipo equi
                    LEFT JOIN partido parti
                        ON
                            parti.ganador = equi.id_equipo
                GROUP BY equi.id_equipo, equi.nombre
                ORDER BY COUNT(parti.ganador) desc;
    END clasificacion;
    
    PROCEDURE RESULTADOS_DE_LA_JORNADA
        (P_NUMJORNADA PARTIDO.JORNADA%TYPE,P_RESULT_CURSOR OUT PACK_CURSOR)
    IS
    BEGIN
            OPEN P_RESULT_CURSOR FOR
               SELECT MARCADOR_LOCAL,EQUIPO_LOCAL,
                MARCADOR_VISITANTE,EQUIPO_VISITANTE
                FROM PARTIDO
                WHERE JORNADA= P_NUMJORNADA; 
    END RESULTADOS_DE_LA_JORNADA;

 END;
 
DECLARE 
RESULTADO VISUALIZACION_RESULTADOS.PACK_CURSOR;
TYPE PACK_REC IS RECORD (EQUIPO VARCHAR2(10), ID_EQUIPO NUMBER, GANADOS NUMBER);
REC PACK_REC;
BEGIN
    VISUALIZACION_RESULTADOS.clasificacion(RESULTADO);
    LOOP
        FETCH RESULTADO INTO REC;
        EXIT WHEN RESULTADO%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('EQUIPO: '|| REC.EQUIPO || ' PARTIDOS WIN: '|| REC.GANADOS);
    END LOOP;
END;

SELECT equi.nombre, equi.id_equipo, COUNT(parti.ganador) AS "NUM_GANADOS" FROM equipo equi
                    LEFT JOIN partido parti
                        ON
                            parti.ganador = equi.id_equipo
                GROUP BY equi.id_equipo, equi.nombre
                ORDER BY COUNT(parti.ganador) desc;

SET SERVEROUTPUT ON;
SHOW ERRORS;
 
 
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
        ELSIF marcador_visit > marcador_loc THEN 
        SELECT equipo_visitante INTO p_ganador FROM partido WHERE id_partido = p_id_partido;
        END IF;
        UPDATE partido SET ganador = p_ganador WHERE id_partido = p_id_partido;
        UPDATE PARTIDO SET MARCADOR_LOCAL = marcador_loc WHERE id_partido = p_id_partido;
        UPDATE PARTIDO SET MARCADOR_VISITANTE = marcador_visit WHERE id_partido = p_id_partido;
        COMMIT;
    END actualizar_resultado;
END Acciones_Administrador;


