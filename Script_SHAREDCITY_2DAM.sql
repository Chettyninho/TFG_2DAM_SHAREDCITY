/*DROP DATABASE SharedCity*/
CREATE database SharedCity;

CREATE TABLE USUARIO(
ID integer auto_increment primary key,
Nombre varchar(50),
Apellido varchar(50),
Fecha_Nacimeinto date,
Numero_de_rutas int,
Pais varchar(25),
Localidad varchar(30),
email varchar(50),
Username varchar(20),
Password varchar(255),
Salt BINARY,
Foto_perfil blob,
Guia boolean
);

CREATE TABLE RUTA(
ID integer auto_increment primary key,
Nombre varchar(50),
Distancia float,
Fecha_Creacion date,
ID_UsuarioPropietario integer,

foreign key (ID_UsuarioPropietario) REFERENCES Usuario(ID)
);

CREATE TABLE PUNTO_INTERES(
ID integer auto_increment primary key,
Nombre varchar(50),
Latitud double,
Longitud double,
ID_Ruta integer,

foreign key (ID_Ruta) REFERENCES Ruta(ID)
);

CREATE TABLE VALORACION_RUTA(
ID integer auto_increment primary key,
ID_USUARIO_VALORANTE integer,
Titulo_valoracion varchar (20),
Valoracion varchar (200),
Puntos_Estrellas double,
ID_Ruta integer,

FOREIGN KEY (ID_Ruta) REFERENCES Ruta(ID)
);


CREATE TABLE VALORACION_USUARIO(
ID integer auto_increment primary key,
ID_USUARIO_VALORANTE integer,
ID_USUARIO_VALORADO integer,
Titulo_valoracion varchar (20),
Valoracion varchar (200),
Puntos_Estrellas double,

FOREIGN KEY (ID_USUARIO_VALORANTE) REFERENCES USUARIO(ID),
FOREIGN KEY (ID_USUARIO_VALORADO) REFERENCES USUARIO(ID)
);

CREATE TABLE CHAT(
ID integer auto_increment primary key,
ID_EMISOR integer,
ID_RECEPTOR integer,
Mensaje text,
FechaHora timestamp,

FOREIGN KEY (ID_EMISOR) REFERENCES USUARIO(ID),
FOREIGN KEY (ID_RECEPTOR) REFERENCES USUARIO(ID)
);