CREATE TABLE IF NOT EXISTS personalizacion
(
id_personalizacion INT NOT NULL,
colorFondo VARCHAR(25) NOT NULL,
colorBloques VARCHAR(25) NOT NULL,
sonido VARCHAR(25) NOT NULL,
PRIMARY KEY(id_personalizacion)
);

CREATE TABLE IF NOT EXISTS jugador
(
usuario VARCHAR(25) NOT NULL,
correo VARCHAR(60) NOT NULL,
contrasena VARCHAR(25) NOT NULL,
id_personalizacion INT NOT NULL,
id_partidaSF INT,
PRIMARY KEY(usuario)
);

CREATE TABLE IF NOT EXISTS partida
(
id_partida INT NOT NULL,
anchura INT,
altura INT,
puntuacion INT NOT NULL,
nivel INT NOT NULL,
usuario VARCHAR(25),
PRIMARY KEY(id_partida)
);

CREATE TABLE IF NOT EXISTS bloque
(
id_bloque INT NOT NULL,
coordenada INT NOT NULL,
forma VARCHAR(25) NOT NULL,
id_partida INT NOT NULL,
PRIMARY KEY(id_bloque)
);



ALTER TABLE jugador ADD FOREIGN KEY (id_personalizacion) REFERENCES personalizacion(id_personalizacion) ON DELETE CASCADE;
ALTER TABLE jugador ADD FOREIGN KEY(id_partidaSF) REFERENCES partida(id_partida) ON DELETE CASCADE;
ALTER TABLE partida ADD FOREIGN KEY (usuario) REFERENCES jugador(usuario) ON DELETE CASCADE;
ALTER TABLE bloque ADD FOREIGN KEY (id_partida) REFERENCES partida(id_partida) ON DELETE CASCADE;

insert into personalizacion(id_personalizacion, colorFondo, colorBloques, sonido) values (0, '','','');
insert into jugador(usuario, correo, contrasena, id_personalizacion) values ('admin', 'admin', 'admin', 0);
