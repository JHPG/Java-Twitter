CREATE TABLE usuarios 
(
id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY ( START WITH 1, INCREMENT BY 1),
nome VARCHAR(255),
login VARCHAR(255) NOT NULL,
senha VARCHAR(255),
PRIMARY KEY(id)
);

CREATE TABLE mensagens 
(
id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY ( START WITH 1, INCREMENT BY 1),
login VARCHAR(255) NOT NULL,
nome VARCHAR(255),
texto VARCHAR(255),
hora VARCHAR(255),    
PRIMARY KEY(id)
);

INSERT INTO usuarios (nome, login, senha) VALUES ('Jorge', 'jhpg', '123');
INSERT INTO usuarios (nome, login, senha) VALUES ('Raphael', 'rma', '123');
INSERT INTO usuarios (nome, login, senha) VALUES ('Fabio', 'fabio', '123');