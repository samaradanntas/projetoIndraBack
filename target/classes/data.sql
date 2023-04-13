CREATE TABLE IF NOT EXISTS cliente_model (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    rendimento_mensal DECIMAL(19, 2) NOT NULL
);

INSERT INTO cliente_model (cpf, nome, telefone, rendimento_mensal) VALUES ('111.111.111-11', 'Cliente 1', '11111-1111', 1000.00);


