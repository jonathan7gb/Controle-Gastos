CREATE DATABASE controle_financeiro;
USE controle_financeiro;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE movimentacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    categoria_id INT NOT NULL,
    tipo ENUM('RECEITA', 'DESPESA') NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    descricao VARCHAR(255),
    data DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

CREATE VIEW saldo_usuario AS
SELECT 
    u.id AS usuario_id,
    u.nome,
    SUM(CASE WHEN m.tipo = 'RECEITA' THEN m.valor ELSE 0 END) -
    SUM(CASE WHEN m.tipo = 'DESPESA' THEN m.valor ELSE 0 END) AS saldo
FROM usuarios u
LEFT JOIN movimentacoes m ON u.id = m.usuario_id
GROUP BY u.id, u.nome;

INSERT INTO categorias (nome) VALUES
('Salário'),
('Freelance'),
('Alimentação'),
('Transporte'),
('Lazer');

