USE helpr;
DELIMITER //

CREATE PROCEDURE ajuste_salarial(base Decimal)
BEGIN
	UPDATE cargo SET salario = salario + (salario * base/100);
END//

DELIMITER ;

CALL reajuste_salarial(10);


