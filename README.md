# 📝 Online Examination Platform (Microservices)

A scalable **Online Examination Platform** built using **Java, Spring Boot, Spring Cloud, JWT Authentication, MySQL, and Microservices Architecture**. The platform allows teachers to create and publish exams, students to attempt them, and automatically generates results after submission.

---

# 🚀 Features

### Authentication

* User Registration
* User Login
* JWT Authentication
* Role-based access (Admin, Teacher, Student)
* Secure REST APIs

### Exam Management

* Create Exam
* Add Questions and Answer Options
* Publish Exam
* View Exam Details
* Delete Exam
* Get Exam Answer Key (Internal API)

### Exam Attempt

* Start Exam
* Submit Answers
* View Attempt Details
* Internal Attempt API for Result Service

### Result Management

* Generate Result
* Calculate Correct Answers
* Calculate Percentage
* PASS / FAIL Status
* View Student Results

---

# 🏗️ Microservices

## 1. Auth Service

Responsible for authentication and authorization.

### APIs

* Register User
* Login User
* Get Logged-in User

---

## 2. Exam Service

Responsible for exam management.

### APIs

* Create Exam
* Get Exam
* Get All Exams
* Publish Exam
* Delete Exam
* Internal Answer Key API

---

## 3. Submission Service

Responsible for exam attempts.

### APIs

* Start Exam
* Submit Exam
* Get Attempt
* Internal Attempt Details API

---

## 4. Result Service

Responsible for result generation.

### APIs

* Generate Result
* Get Result
* Get Results By Student

---

# 🛠 Tech Stack

## Backend

* Java 21
* Spring Boot
* Spring MVC
* Spring Data JPA
* Spring Security
* JWT
* Hibernate

## Microservices

* Spring Cloud
* Eureka Server
* Spring Cloud Gateway
* OpenFeign

## Database

* MySQL

## Documentation

* Swagger / OpenAPI

## Build Tool

* Maven

---

# 🏛️ Architecture

Client

⬇

API Gateway

⬇

Eureka Discovery Server

⬇

Auth Service

Exam Service

Submission Service

Result Service

⬇

MySQL Databases

---

# 🔐 Authentication Flow

1. Register User
2. Login
3. Receive JWT Token
4. Authorize using Swagger or frontend
5. Access secured APIs

---

# 📝 Exam Workflow

Teacher

Create Exam

↓

Add Questions

↓

Publish Exam

↓

Student Starts Exam

↓

Student Submits Answers

↓

Result Service Generates Result

↓

Student Views Result

---

# 📚 API Documentation

Each microservice provides Swagger UI documentation.

* Auth Service → `/swagger-ui/index.html`
* Exam Service → `/swagger-ui/index.html`
* Submission Service → `/swagger-ui/index.html`
* Result Service → `/swagger-ui/index.html`

JWT authentication is supported through the **Authorize** button in Swagger.

---

# ✅ Validation & Exception Handling

Implemented:

* Bean Validation (`@Valid`, `@Validated`)
* Global Exception Handling
* BusinessException
* ResourceNotFoundException
* MethodArgumentNotValidException

---

# 🔒 Security

* JWT Authentication
* Password Encryption (BCrypt)
* Stateless Authentication
* Protected REST APIs

---

# 📂 Project Structure

```text
online-examination-platform
│
├── eureka-server
├── api-gateway
├── auth-service
├── exam-service
├── submission-service
└── result-service
```

---

# 🔄 Complete API Flow

1. Register User
2. Login
3. Create Exam
4. Publish Exam
5. Start Exam Attempt
6. Submit Exam
7. Generate Result
8. View Result

---

# 🚧 Future Improvements

* React Frontend
* Teacher Dashboard
* Student Dashboard
* Timer-Based Exams
* Docker & Docker Compose
* Kubernetes Deployment
* Redis Caching
* Kafka Event Streaming
* Unit & Integration Testing
* CI/CD Pipeline
* Monitoring with Prometheus & Grafana

---

# 👨‍💻 Author

**Abhish Tarhekar**

If you found this project helpful, feel free to ⭐ the repository.
