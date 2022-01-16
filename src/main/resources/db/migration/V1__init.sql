CREATE TABLE IF NOT EXISTS  alumno (
    id serial,
    cedula NUMERIC (10) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NULL,
    edad VARCHAR (45) NULL,
    discapacidad VARCHAR(45) NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS  docente (
    id serial,
    cedula VARCHAR (10) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NULL,
    edad VARCHAR (45) NULL,
    celular VARCHAR (45) NULL,
    email VARCHAR(45) NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS  asignatura (
    id serial,
    materia VARCHAR (45) NOT NULL,
    PRIMARY KEY (id),
    alumno_id int,
    foreign key (alumno_id) references alumno(id),
    docente_id int,
    foreign key (docente_id) references docente(id)
    );