CREATE TABLE agencia(
    id_agencia INT auto_increment,
    nome_agencia VARCHAR(255) NOT NULL,
    lng FLOAT, --X
    lat FLOAT --Y
);

ALTER TABLE agencia
    ADD CONSTRAINT UQ_agencia_nome_agenica UNIQUE (nome_agencia);

INSERT INTO agencia (nome_agencia, lat, lng)
    VALUES
        ('AGENCIA_1', 10.0, 4.0),
        ('AGENCIA_2', -2.0, 2.0),
        ('AGENCIA_3', -5.0, -2.0),
        ('AGENCIA_4', 10.0, -7.0);