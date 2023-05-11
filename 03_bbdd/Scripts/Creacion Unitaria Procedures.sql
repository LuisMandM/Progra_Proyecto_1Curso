
---PROCEDURES----


--PACKAGE VISUALIZACION

	CREATE OR REPLACE PROCEDURE HISTORIAL_EQUIPO
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
	
	
	CREATE OR REPLACE PROCEDURE HISTORIAL_EQUIPO_TEMP
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
			
		END HISTORIAL_EQUIPO_TEMP;