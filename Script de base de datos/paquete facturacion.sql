CREATE OR REPLACE PACKAGE BODY PKG_FACTURACION
AS
 
PROCEDURE insertRegister (id_transaction  NUMBER,id_client  NUMBER, dateTransaction  DATE, process_rode  VARCHAR2, rode  NUMBER, states out VARCHAR2 )

IS 
   rate VARCHAR(10);
   surcharge NUMBER(15,0);
   discount NUMBER(15,0);
BEGIN
  states     :='No se  encuentra registro';
 
  select c.TIPO_TARIFA ,dt.descuento_numerico,dt.recargo_numerico  INTO rate,discount,surcharge
  from clientes c, tarifas t, detalle_tarifas dt
  where id_cliente = id_client
  and c.tipo_tarifa = t.tipo_tarifa
  and t.tipo_tarifa = dt.tipo_tarifa
  and dt.TIPO_TRANSACCION=process_rode;
  
  IF rate='BASICA'  THEN
   INSERT INTO SERVICIOS_PRESTADOS VALUES(id_transaction,id_client, sysdate , rode, rode);
   COMMIT;
   states     :='Exitoso';
  ELSIF rate='PLENA' THEN
    SELECT de.DESCUENTO_NUMERICO INTO discount FROM DETALLE_TARIFAS de WHERE de.TIPO_TARIFA='PLENA' AND ROWNUM<=1;
    INSERT INTO SERVICIOS_PRESTADOS VALUES(id_transaction,id_client, sysdate , rode, rode-discount);
    COMMIT;
    states     :='Exitoso';
  ELSIF rate='PLUS' THEN
    SELECT de.DESCUENTO_NUMERICO, de.RECARGO_NUMERICO INTO discount, surcharge FROM DETALLE_TARIFAS de WHERE de.TIPO_TARIFA='PLUS' AND ROWNUM<=1;
    INSERT INTO SERVICIOS_PRESTADOS VALUES(id_transaction,id_client, sysdate , rode, (rode-discount)*surcharge);
    COMMIT;
    states     :='Exitoso';
  END IF;
  
EXCEPTION
WHEN NO_DATA_FOUND THEN
  states:='Fallo';
WHEN OTHERS THEN
  states:='Fallo';
END insertRegister;


END PKG_FACTURACION;
/
