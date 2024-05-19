# Arquitectura microservicios - prueba 

## Características implementadas

### El manejo de entidades con JPA

### Se debe aplicar un manejo de excepciones

### Se debe realizar como mínimo una prueba unitaria 
/seniorneodevmicro/micro_account_tx/src/test/java/com/job/micro/accounttx/entity/ClientTest.java

### Se debe realizar como mínimo una prueba de integracion
/seniorneodevmicro/micro_person_client/src/test/java/com/job/micro/personclient/controller/ClientIntegrationTest.java

### La solución se debe desplegar y funcionar en Docker
Compile microservices
	microservice micro_person_client
		mvn clean package -DskipTests
	microservice micro_account_tx
		mvn clean package
Docker Container docker-compose.yml (service = micropc, service 2 = microat and database = mysqldb)
	docker compose up
	docker exec -it micropc bin/sh
	docker exec -it microat bin/sh
	docker exec -it mysqldb bash
		mysql -u root -p
		show databases;
		use neodev_micro
		show tables;
		select * from person;
		select * from client;
		select * from account;
		select * from transaction;
	docker compose down

### Separar en 2 microservicios, agrupando (Cliente, Persona) y (Cuenta, Movimientos) donde se contemple una comunicación asincrónica entre los 2 microservicios
/seniorneodevmicro/micro_account_tx/src/main/java/com/job/micro/accounttx/controller/AccountController.java
Método -> createAccountAsync

### Generación de CRUDS (Crear, editar, actualizar y eliminar registros - Entidades: Cliente,  Cuenta y Movimiento). 
Los nombres de los endpoints a generar son: 
Cliente -> /api/clients
Cuenta -> /api/accounts
Movimiento -> /api/transactions
Reporte estado de cuenta /api/reports
REST API reports
	http://localhost:8081/api/reports?clientId=1&startDate=2024-05-17T09:41:00Z&endDate=2024-05-19T09:42:00Z

### script database schema and tables
	/micro_account_tx/src/main/resources/BaseDatos.sql.sql
	/micro_person_client/src/main/resources/BaseDatos.sql.sql

### Proyecto postman para probar REST API
/seniorneodevmicro/neodev_micro.postman_test_api.collection.json