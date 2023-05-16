

CREATE TABLE EQUIPO(
	ID_EQUIPO INTEGER(10) CONSTRAINT EQUI_ID_PK PRIMARY KEY,
	NOMBRE VARCHAR2(100) CONSTRAINT EQUI_NOM_UK UNIQUE,
	SALARIO_TOTAL NUMBER(10),
	ID_DUENIO NUMBER(10) CONSTRAINT EQUI_DUENIO_FK REFERENCES DUEÑO ON DELETE CASCADE,
	CONSTRAINT EQUI_NN NOT NULL(NOMBRE,SALARIO_TOTAL)
);

CREATE TABLE PARTIDO(
	ID_PARTIDO NUMBER(10) CONSTRAINT PART_ID_PK PRIMARY KEY,
	GANADOR NUMBER(10),
	MARCADOR_LOCAL NUMBER(10),
	MARCADOR_VISITANTE NUMBER(10),
	EQUIPO_LOCAL NUMBER(10) CONSTRAINT PART_LOCAL_FK REFERENCES EQUIPO ON DELETE SET NULL,
	EQUIPO_VISITANTE NUMBER(10)CONSTRAINT PART_VISITAL_FK REFERENCES EQUIPO ON DELETE SET NULL,
	JORNADA NUMBER(10) CONSTRAINT PART_JOR_FK REFERENCES JORNADA	
);
