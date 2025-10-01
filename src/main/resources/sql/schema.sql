CREATE TABLE agencia(
    id_agencia INT PRIMARY KEY auto_increment,
    nome_agencia VARCHAR(255) NOT NULL,
    lng FLOAT, --X
    lat FLOAT, --Y
    id_zona INT NOT NULL
);

CREATE TABLE zona(
    id_zona INT PRIMARY KEY auto_increment,
    nome_zona VARCHAR(255)
);

ALTER TABLE agencia
    ADD CONSTRAINT UQ_agencia_nome_agenica UNIQUE (nome_agencia);

ALTER TABLE agencia
    ADD CONSTRAINT FK_agencia_zona FOREIGN KEY (id_zona) REFERENCES zona(id_zona);
