use helpr;
CREATE TABLE bkp_usuarios(
	idBkpUsuarios INTEGER PRIMARY KEY AUTO_INCREMENT,
    idUsuarios INTEGER NOT NULL,
    nome VARCHAR(150) NOT NULL,
    perfil VARCHAR(255) NOT NULL,
    dtype VARCHAR(31) NOT NULL,
    dataAlteracao DATE NOT NULL
);

DELIMITER //

CREATE TRIGGER tg_bkp_usuarios
BEFORE DELETE ON usuarios
FOR EACH ROW
BEGIN
	INSERT INTO bkp_usuarios VALUES(NULL,OLD.id, OLD.nome, OLD.perfil, OLD.dtype, CURRENT_DATE());
END//

DELIMITER ;

-- Não é possivel deletar um usuário devido ao seu relacionamento. Foi desabilitado a verificação da chave estrangeira para testes.
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM usuarios WHERE id = 2;

select * from bkp_usuarios;
