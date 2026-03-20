# TodoRestApi

A simple and structured Todo REST API built using Spring Boot.  
This project is designed to help understand how REST APIs work and how layered architecture is implemented in backend development.

## Features

- Create a new todo
- Get all todos
- Get a todo by ID
- Update an existing todo
- Delete a todo
- Organized layered architecture

## Tech Stack

- Java
- Spring Boot
- Spring MVC
- Maven
- REST API

## Project Structure

This project follows a layered architecture:

- Controller Layer – Handles incoming HTTP requests
- Service Layer – Contains business logic
- Repository Layer – Manages data access
- Model Layer – Represents the todo entity

## API Endpoints

| Method | Endpoint      | Description             |
|--------|---------------|-------------------------|
| GET    | `/todos`      | Fetch all todos         |
| GET    | `/todos/{id}` | Fetch todo by ID        |
| POST   | `/todos`      | Create a new todo       |
| PUT    | `/todos/{id}` | Update an existing todo |
| DELETE | `/todos/{id}` | Delete a todo           |

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java
- Maven
- IDE such as IntelliJ IDEA, Eclipse, or VS Code

### Run the Project

1. Clone the repository
    git clone https://github.com/Katariyajiya/TodoRestApi.git

2. Navigate to the project folder

cd TodoRestApi

3. Run the application

mvn spring-boot:run

## Testing

You can test the API using tools like:

- Postman

- Thunder Client

- cURL

## Future Improvements

- Add database integration

- Add validation

- Add exception handling

- Add Swagger documentation

- Add Spring Security

## Author

Jiya Katariya
- This project was built for learning and practicing Spring Boot REST API development.
