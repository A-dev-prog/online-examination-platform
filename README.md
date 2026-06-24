# Online Examination Platform

A microservices-based Online Examination Platform built using Java, Spring Boot, Spring Cloud, and MySQL.

## Overview

This project allows teachers/admins to create and manage online exams, while students can attempt and submit exams through a scalable microservices architecture.

---

## Architecture

```
Online Examination Platform

├── Eureka Server
├── Auth Service
├── Exam Service
└── Submission Service
```

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring Cloud
- Eureka Server
- OpenFeign
- MySQL
- Swagger / OpenAPI
- Maven
- Git & GitHub

---

## Implemented Services

### 1. Auth Service

#### Features

- User Registration
- User Login
- Password Encryption using BCrypt
- JWT Authentication
- Custom UserDetailsService
- Role-Based User Management

#### APIs

```http
POST /api/auth/register
POST /api/auth/login
```

---

### 2. Exam Service

#### Features

- Create Exam
- Publish Exam
- Delete Exam
- Get Exam Details
- Get All Exams
- Business Validation
- Global Exception Handling
- Swagger Documentation

#### Entities

- Exam
- Question
- Option

#### APIs

```http
POST   /api/exams
GET    /api/exams
GET    /api/exams/{id}
PUT    /api/exams/{id}/publish
DELETE /api/exams/{id}
```

---

### 3. Submission Service

#### Features

- Start Exam Attempt
- Submit Exam
- Get Attempt Details
- Exam Validation via OpenFeign
- Global Exception Handling
- Request Validation
- Swagger Documentation

#### Entities

- ExamAttempt
- StudentAnswer

#### APIs

```http
POST /api/attempts/start
POST /api/attempts/{attemptId}/submit
GET  /api/attempts/{attemptId}
```

---

## Service Communication

### Submission Service → Exam Service

Using OpenFeign Client.

Purpose:

- Verify exam exists before creating an attempt.
- Prevent invalid exam submissions.

---

## Current Progress

### Completed

- ✅ Eureka Server
- ✅ Auth Service
- ✅ Exam Service
- ✅ Submission Service
- ✅ JWT Authentication
- ✅ Swagger Integration
- ✅ Global Exception Handling
- ✅ Validation
- ✅ OpenFeign Communication

---

## Next Immediate Task

### Result Service

Planned Features:

- Calculate Exam Score
- Generate Result
- Percentage Calculation
- Pass/Fail Evaluation
- Result APIs

---

## Running the Project

### Start Services in Order

1. Eureka Server
2. Auth Service
3. Exam Service
4. Submission Service

### Eureka Dashboard

```text
http://localhost:8761
```

### Swagger URLs

#### Auth Service

```text
http://localhost:8081/swagger-ui/index.html
```

#### Exam Service

```text
http://localhost:8082/swagger-ui/index.html
```

#### Submission Service

```text
http://localhost:8083/swagger-ui/index.html
```

---

## Learning Goals

This project is being built to gain hands-on experience with:

- Spring Boot
- Microservices Architecture
- Service Discovery
- API Communication using OpenFeign
- Authentication & Authorization
- REST API Design
- Production-Oriented Backend Development

---

## Author

**Abhish Tarhekar**

Java Backend Developer | Spring Boot | Microservices | REST APIs | MySQL | DSA