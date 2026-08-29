CREATE TABLE IF NOT EXISTS viagem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    apelido_viagem VARCHAR(255) NOT NULL,
    estacao_do_ano VARCHAR(45) NOT NULL,
    data_ida DATE NOT NULL,
    data_volta DATE NOT NULL,
    dias_no_japao INT NOT NULL,
    reserva_viagem DECIMAL(10,2)
    );