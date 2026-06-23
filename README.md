# Spring Security JWT Authentication Project

## Overview

This is my first Spring Security project where I implemented user registration and login functionality using JWT (JSON Web Token) authentication.

The application allows users to:

* Register with a username and password
* Store passwords securely using BCrypt hashing
* Authenticate users using Spring Security
* Generate JWT tokens after successful login
* Validate JWT tokens for protected endpoints
* Access secured APIs without using server-side sessions

All APIs were tested successfully using Postman.

---

## Tech Stack

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* MySQL
* JWT (JSON Web Token)
* Maven
* Postman

---

## Features

### User Registration

* Accepts username and password
* Password is encrypted using BCryptPasswordEncoder
* User details are stored in MySQL database

### User Login

* Authenticates user credentials
* Uses AuthenticationManager and DaoAuthenticationProvider
* Verifies password using BCrypt
* Generates JWT token upon successful authentication

### JWT Authentication

* Stateless authentication
* No server-side session storage
* JWT contains:

  * Subject (Username)
  * Issued Time
  * Expiration Time
* Every protected request requires a valid JWT token

### Protected APIs

* Accessible only with a valid JWT token
* JWT is passed through the Authorization header

Example:

Authorization: Bearer <JWT_TOKEN>

---

## Spring Security Components Used

### AuthenticationManager

Receives login requests and delegates authentication.

### DaoAuthenticationProvider

Authenticates users using:

* UserDetailsService
* BCryptPasswordEncoder

### UserDetailsService

Loads user information from the database.

### BCryptPasswordEncoder

Hashes passwords before storing them and verifies passwords during login.

### JwtFilter

Intercepts every request and:

* Extracts JWT token
* Validates token
* Authenticates user

### SecurityContextHolder

Stores authenticated user information for the current request.

---

## API Endpoints

### Register User

POST /register

Request Body:

```json
{
  "username": "rohan",
  "password": "123"
}
```

---

### Login User

POST /login

Request Body:

```json
{
  "username": "rohan",
  "password": "123"
}
```

Response:

```text
JWT_TOKEN
```

---

### Access Protected Endpoint

GET /students

Headers:

```text
Authorization: Bearer JWT_TOKEN
```

---

## Security Configuration

Implemented:

* Spring Security Filter Chain
* JWT Authentication Filter
* Stateless Session Management
* BCrypt Password Encoding
* Endpoint Authorization

Configuration Highlights:

* /register → Public
* /login → Public
* All other endpoints → Authenticated

---

## Learning Outcomes

Through this project, I learned:

* Spring Security fundamentals
* Authentication vs Authorization
* BCrypt password hashing
* JWT generation and validation
* SecurityFilterChain configuration
* AuthenticationManager workflow
* DaoAuthenticationProvider workflow
* UserDetailsService implementation
* Stateless authentication using JWT
* Request filtering using OncePerRequestFilter

---

## Project Flow

User Registration
↓
BCrypt Password Hashing
↓
Store User in Database
↓
Login Request
↓
AuthenticationManager
↓
DaoAuthenticationProvider
↓
UserDetailsService
↓
BCrypt Verification
↓
JWT Generation
↓
Client Stores JWT
↓
Protected API Request
↓
JWT Validation
↓
Access Granted

---

## Future Improvements

* Role Based Authorization (ADMIN / USER)
* Refresh Tokens
* Exception Handling
* Swagger Documentation
* Docker Deployment
* Unit Testing
* Integration Testing

---

## Author

Vaibhavi Tumsare

First Spring Security + JWT Authentication Project 
