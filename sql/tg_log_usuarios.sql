USE helpr;

CREATE TABLE log_usuarios(
idLogUsuario INTEGER PRIMARY KEY AUTO_INCREMENT,
    idUsuarios INTEGER NOT NULL,
    nome VARCHAR(150) NOT NULL,
    novoNome VARCHAR(150) NOT NULL,
    perfil VARCHAR(255) NOT NULL,
    novoPerfil VARCHAR(255) NOT NULL,
    dtype VARCHAR(31) NOT NULL,
    dataAlteracao DATE NOT NULL
);

select * from usuarios;

SELECT * FROM log_usuarios;

UPDATE usuarios
 SET perfil = "FUNCIONARIO"
 WHERE id = 2;
 
 UPDATE usuarios 
SET nome = "Rafael Silva de Lima"  
WHERE id = 1 ;

DELIMITER //

CREATE TRIGGER tg_log_usuarios
BEFORE UPDATE ON usuarios
FOR EACH ROW
	BEGIN
		INSERT INTO log_usuarios VALUES(NULL,OLD.id,OLD.nome,NEW.nome,OLD.perfil,NEW.perfil,OLD.dtype, CURRENT_DATE());
	END//

DELIMITER ;

SELECT * FROM USUARIOS;
SELECT * FROM log_usuarios;

UPDATE usuarios 
SET nome = "Rafael Silva de Lima"  
WHERE id = 1 ;

UPDATE usuarios 
SET perfil = "ADMIN"  
WHERE id = 1 ;
 