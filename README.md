
# BloggingPlatformAPI - Roadmap.sh Challenge

This project was developed as part of the [roadmap.sh](https://roadmap.sh/projects/blogging-platform-api) challenge using **Kotlin** as the main language. The technologies used include **Spring Web** for building the backend, **Spring Data JPA** for data persistence, and **MySQL** as the database. The package manager is **Gradle**, and the project runs with **JDK 21**.

## Requirements

Before running this project, make sure you have the following:

- **JDK 21** or higher
- **Gradle** (optional if you use an IDE like IntelliJ that can handle it automatically)
- **MySQL** (or any other compatible database)

## Database Configuration

It is not necessary to manually create the database or tables, as the project includes the `createDatabaseIfNotExist=true` property to automatically create the database when the application starts. The tables are also automatically generated via **Spring Data JPA**.

Make sure MySQL is installed and configured correctly, then update the credentials in `application.properties`:

```properties
# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/blogging_db?createDatabaseIfNotExist=true
spring.datasource.username=user
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

## Running the Project
1. Clone the repository:

   ```bash
   git clone https://github.com/fedezet/BloggingPlatformAPI.git
   cd BloggingPlatformAPI
   ```

2. Build and run the project using Gradle or from your favorite IDE:
   ```bash
   ./gradlew clean build
   ```

3. Access the API at `http://localhost:8080`.

## Endpoints

The API provides the following endpoints:

- `GET /posts`: Retrieves a list of all posts.
- `GET /posts?term="Search"`: Retrieves a list of all posts that contain the word inside the `term` parameter.
- `GET /posts/{1}`: Retrieves a post by its ID.
- `POST /posts`: Creates a new post.
- `PUT /posts/{id}`: Updates a post by its ID.
- `DELETE /posts/{id}`: Deletes a post by its ID.

## Main Dependencies

- **Spring Boot**: 3.3.3
- **Spring Web**: To build the backend.
- **Spring Data JPA**: For data persistence.
- **MySQL Driver**: For connecting to the MySQL database.

## Contributions

Contributions are welcome to improve the code and help us learn more about **Spring**. If you find areas for improvement, feel free to contribute.
