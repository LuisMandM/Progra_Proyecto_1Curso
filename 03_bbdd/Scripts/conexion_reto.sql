create table Administrador(
id_admin NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_admin_pk PRIMARY KEY ,
contrase�a varchar2(20) not null,
usuario varchar2(50) not null
);

create table Due�o(
id_due�o NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_due�o_pk PRIMARY KEY,
nombre varchar2(50) not null,
contrase�a varchar2(20) not null,
usuario varchar2(50) not null
);

CREATE TABLE Jugador(
id_jugador NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_jugador_pk PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
nickname VARCHAR2(50) NOT NULL,
sueldo NUMBER(10) NOT NULL
);

CREATE TABLE Jugador_Equipo(
id_jugador NUMBER(10) NOT NULL CONSTRAINT id_jugador_fk REFERENCES Jugador,
id_equipo NUMBER(10) NOT NULL CONSTRAINT id_equipo_fk REFERENCES Equipo,
fecha_inicio date NOT NULL,
fecha_fin date ,
CONSTRAINT jef_pk PRIMARY KEY(id_jugador, id_equipo, fecha_inicio)
);

CREATE TABLE CALENDARIO(
ID_TEMPORADA NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_temporada_pk PRIMARY KEY,
FECHA_INICIO DATE CONSTRAINT NN_FEC_IN NOT NULL,
FECHA_FIN DATE CONSTRAINT NN_FEC_FIN NOT NULL

);

CREATE TABLE JORNADA(
ID_JORNADA NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_jornada_pk PRIMARY KEY,
FECHA DATE CONSTRAINT NN_FEC NOT NULL,
ID_TEMPORADA NUMBER(10) CONSTRAINT FK_JOR  REFERENCES CALENDARIO  

);

CREATE TABLE EQUIPO(
	ID_EQUIPO NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 10 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_equipo_pk PRIMARY KEY,
	NOMBRE VARCHAR2(100) NOT NULL CONSTRAINT EQUI_NOM_UK UNIQUE,
	SALARIO_TOTAL NUMBER(10),
	ID_DUENIO NUMBER(10) CONSTRAINT EQUI_DUENIO_FK REFERENCES DUE�O ON DELETE SET NULL
);

CREATE TABLE PARTIDO(
	ID_PARTIDO NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_partido_pk PRIMARY KEY,
	GANADOR NUMBER(10),
	MARCADOR_LOCAL NUMBER(10),
	MARCADOR_VISITANTE NUMBER(10),
	EQUIPO_LOCAL NUMBER(10) CONSTRAINT PART_LOCAL_FK REFERENCES EQUIPO ON DELETE SET NULL,
	EQUIPO_VISITANTE NUMBER(10)CONSTRAINT PART_VISITAL_FK REFERENCES EQUIPO ON DELETE SET NULL,
	JORNADA NUMBER(10) CONSTRAINT PART_JOR_FK REFERENCES JORNADA	
);

-- INSERTS

INSERT INTO administrador(contrase�a, usuario) VALUES('12345A', 'admin');
INSERT INTO Due�o(nombre, contrase�a, usuario) VALUES('PEDRO', '12345A', 'due�o2');
INSERT INTO Jugador(nombre, nickname, sueldo) VALUES('ADRIAN', 'user1', 1000);
INSERT INTO Jugador(nombre, nickname, sueldo) VALUES('DIEGO', 'user2', 1000);
INSERT INTO Jugador(nombre, nickname, sueldo) VALUES('PABLO', 'user3', 1000);
INSERT INTO Jugador(nombre, nickname, sueldo) VALUES('ALVARO', 'user5', 1000);
COMMIT;

INSERT INTO equipo(nombre, salario_total, ID_DUENIO) VALUES('equipo2', 20000, 2);

INSERT INTO partido(GANADOR, MARCADOR_LOCAL, MARCADOR_VISITANTE, EQUIPO_LOCAL, EQUIPO_VISITANTE, JORNADA) VALUES()

INSERT INTO jugador_equipo VALUES(4, 111, '10/1/22', '20/10/23');

SELECT * FROM administrador;
SELECT * FROM due�o;
SELECT * FROM jugador;
SELECT * FROM calendario;
SELECT * FROM jornada;
SELECT * FROM equipo;
SELECT * FROM partido;
SELECT * FROM jugador_equipo;

-- TRIGGERS

CREATE OR REPLACE TRIGGER max_jugadores
BEFORE INSERT ON jugador_equipo
    FOR EACH ROW

DECLARE
    v_id_jugador    jugador.id_jugador%TYPE;
    v_id_equipo     equipo.id_equipo%TYPE;
    v_num_jugadores NUMBER;
    
BEGIN

    SELECT COUNT(*) AS "NUM_JUGADORES" INTO v_num_jugadores FROM jugador_equipo
    WHERE id_equipo = :new.id_equipo AND fecha_fin IS NULL;
    
    IF v_num_jugadores >= 6
    THEN
    RAISE_APPLICATION_ERROR(-202021, 'ERROR, Maximo de jugadores completado');
    ELSE
    DBMS_OUTPUT.PUT_LINE('Operacion valida');
    END IF;
    
END;

SELECT * FROM jugador_equipo;
INSERT INTO jugador_equipo(id_jugador, id_equipo, fecha_inicio) VALUES(21, 1, '10/01/22');