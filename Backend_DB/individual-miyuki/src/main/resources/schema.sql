CREATE TABLE IF NOT EXISTS viagem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    apelidoViagem VARCHAR(255) NOT NULL,
    estacaoAno VARCHAR(45) NOT NULL,
    dataIda DATE NOT NULL,
    dataVolta DATE NOT NULL,
    diasNoJapao INT NOT NULL,
    dinheiroViagem DECIMAL(10,2)
    );