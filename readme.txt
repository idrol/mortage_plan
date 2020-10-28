- Code test - Mortage plan
Coded with latest JDK 15

- Run
To start the application go to the project root and type ./gradlew.bat run
To run application tests ./gradlew.bat test

- Run with database source
To use a database as source type ./gradlew runDatabase

- Notes
The application bundles the provided prospects.txt as a resource
The application uses doubles for calculating the mortage formula.
Ideally i would use BigDecimal from java.math to avoid floating point precision errors.
The database server should be localhost and the database should be named mortage_plan and the table should be named prospects
The database username and password should be root, password

- Database
The prospects table was created with the following query
CREATE TABLE `prospects` (
  `id` int NOT NULL,
  `customer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `total_loan` decimal(20,10) NOT NULL,
  `interest` decimal(20,10) NOT NULL,
  `years` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;