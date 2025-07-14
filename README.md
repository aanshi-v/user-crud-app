# User Management API - Spring Boot Application

This is a simple Spring Boot REST API for managing users using:

- Java
- Spring Boot
- Hibernate / JPA
- MySQL (or any RDBMS)
- DTO-based input/output
- Method Query & HQL support
- Validation using Hibernate Validator
- Pagination support
- ModelMapper for object mapping

---

## 🚀 Features

- ✅ Create, Read, Update, Delete (CRUD) Users
- ✅ Use of DTO for request and response
- ✅ Hibernate validation annotations (`@NotBlank`, `@Email`)
- ✅ Method queries like:
  - `findByFirstName`
  - `findByFirstNameContains`
  - `findByFirstNameAndLastName`
  - `findByFirstNameOrLastName`
- ✅ Custom HQL using `@Query`
- ✅ Pagination with `page` and `size` parameters
- ✅ ModelMapper for entity <-> DTO conversion

---

## ⚙️ Technologies Used

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL
- ModelMapper
- Jakarta Validation (Hibernate Validator)
- Maven

---

## 🧪 Sample Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| `POST` | `/api/users` | Create a user |
| `PUT` | `/api/users/{id}` | Update user by ID |
| `DELETE` | `/api/users/{id}` | Delete user by ID |
| `GET` | `/api/users` | Get all users |
| `GET` | `/api/users/paginated?page=0&size=5` | Paginated users |
| `GET` | `/api/users/by-first-name?firstName=John` | Filter by first name |
| `GET` | `/api/users/custom?fn=John&ln=Doe` | Custom HQL query |

