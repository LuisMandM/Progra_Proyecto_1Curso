

-------------------Triggers------------



------------------PROCEDURE------------

--Procedure Historial Equipo TEMP
DECLARE
V_GANADOS NUMBER;
V_PERDIDOS NUMBER;
V_EMPATADOS NUMBER;
BEGIN
HISTORIAL_EQUIPO_TEMP(1,4,V_GANADOS,V_PERDIDOS,V_EMPATADOS);
DBMS_OUTPUT.PUT_LINE( 'GANADOS: '|| V_GANADOS ||' PERDIDOS: '||V_PERDIDOS
||' EMPATADOS: ' || V_EMPATADOS);
END;

/** Respuesta
GANADOS: 1 PERDIDOS: 0 EMPATADOS: 0
Procedimiento PL/SQL terminado correctamente.
**/

--Procedure Historial Equipo
DECLARE
V_GANADOS NUMBER;
V_PERDIDOS NUMBER;
V_EMPATADOS NUMBER;
BEGIN
HISTORIAL_EQUIPO_(111,V_GANADOS,V_PERDIDOS,V_EMPATADOS);
DBMS_OUTPUT.PUT_LINE( 'GANADOS: '|| V_GANADOS ||' PERDIDOS: '||V_PERDIDOS
||' EMPATADOS: ' || V_EMPATADOS);
END;

/** Respuesta
GANADOS: 0 PERDIDOS: 1 EMPATADOS: 0
Procedimiento PL/SQL terminado correctamente.
**/