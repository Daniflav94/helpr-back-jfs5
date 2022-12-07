USE helpr;
CREATE TABLE log_chamado(
	idLogChamado INTEGER PRIMARY KEY AUTO_INCREMENT,
    idChamado INTEGER NOT NULL,
    statusChamadosOld VARCHAR(255),
    statusChamadosNew VARCHAR(255),
    tituloOld VARCHAR(120) NOT NULL,
    tituloNew VARCHAR(120) NOT NULL,
    idFuncionarioOld INTEGER,
    idFuncionarioNew INTEGER,
    idClienteOld INTEGER NOT NULL,
    idClienteNew INTEGER NOT NULL,
    dataAlteracao DATE NOT NULL
);

DELIMITER //

CREATE TRIGGER tg_log_chamado
BEFORE UPDATE ON chamado
FOR EACH ROW
	BEGIN
		INSERT INTO log_chamado VALUES(
        NULL,OLD.id_chamado,
        OLD.status, 
        NEW.status, 
        OLD.titulo, 
        NEW.titulo,
        OLD.id_funcionario, 
        NEW.id_funcionario, 
        OLD.id_cliente, 
        NEW.id_cliente, 
        CURRENT_DATE());
	END//

DELIMITER ;

SELECT * FROM chamado;
SELECT * FROM log_chamado;
desc chamado; 

UPDATE chamado
SET titulo = "Rafael Silva de Lima"  
WHERE id_chamado = 2;

desc chamado;