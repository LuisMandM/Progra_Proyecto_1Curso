------- Creates tables -------

create table Administrador(
id_admin NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_admin_pk PRIMARY KEY ,
contraseña varchar2(20) not null,
usuario varchar2(50) not null
);


--tabla para guardar a los usuarios
CREATE TABLE CLIENTE(
    ID_USUARIO NUMBER(10)GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT ID_USER_PK PRIMARY KEY,
    CONTRASEÑA varchar2(20) not null,
    USUARIO varchar2(50) not null
);

create table Dueño(
id_due o NUMBER(10) GENERATED AS IDENTITY (START WITH 1 
    INCREMENT BY 1 MAXVALUE 9999999999 MINVALUE 0 NOCYCLE) 
    CONSTRAINT id_due o_pk PRIMARY KEY,
nombre varchar2(50) not null,
contraseña varchar2(20) not null,
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
	ID_DUENIO NUMBER(10) CONSTRAINT EQUI_DUENIO_FK REFERENCES DUE O ON DELETE SET NULL
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



