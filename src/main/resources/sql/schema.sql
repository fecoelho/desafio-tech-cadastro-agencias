CREATE TABLE agencia(
    id_agencia INT auto_increment,
    nome_agencia VARCHAR(255) NOT NULL,
    lng FLOAT, --X
    lat FLOAT --Y
);

ALTER TABLE agencia
    ADD CONSTRAINT UQ_agencia_nome_agenica UNIQUE (nome_agencia);
