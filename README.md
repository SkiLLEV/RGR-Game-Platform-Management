🎮 RGR Project – Game & Platform Management 🎮
📌 Description

This project is a web application for managing platforms, games, and user reviews.

User roles:

USER – can view platforms, games, and reviews

ADMIN – can add and delete platforms, games, and reviews

⚙️ Requirements

Java 17+

Maven 3+

PostgreSQL

Spring Boot 3.x

🚀 Clone & Run
1️⃣ Clone the repository
git clone <REPOSITORY_URL>
cd project.lab3

2️⃣ Database configuration

Create a PostgreSQL database:

CREATE DATABASE lab3db;


Create a database user and grant permissions.

Configure application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/lab3db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update


🔐 Database credentials must be provided as environment variables.

3️⃣ Build & Run the project
mvn clean install
mvn spring-boot:run

4️⃣ Open in browser
http://localhost:8080

🗄️ Data Initialization

On the first run, the database schema is generated automatically.

Initial data can be inserted using SQL scripts if needed.

Duplicate entries are not allowed (platforms, games, and reviews must be unique).

To access full CRUD functionality, an ADMIN user can be created manually in the database.

🔐 Authorization & Roles
Role	Permissions
USER	View platforms, games, and reviews
ADMIN	View, add, edit, and delete platforms, games, and reviews
⚠️ Important Notes

❌ User passwords must not be stored in the README or source code.

✔ Platform, game, and review identifiers must be unique.

✔ All add/delete operations are performed through the web interface (Admin access only).

🧑‍💻 Author

RGR Project – Game & Platform Management
Spring Boot Web Applicationпанелі.
