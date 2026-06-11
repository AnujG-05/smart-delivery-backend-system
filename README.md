# 🚚 Smart Delivery Backend System

A production-ready food delivery backend built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **MySQL**, and **Swagger OpenAPI**.

This project simulates the backend architecture of platforms like Swiggy and Zomato.

---

## 🌐 Live API

### Health Check
https://smart-delivery-backend-system-production.up.railway.app/api/health

### Swagger Documentation
https://smart-delivery-backend-system-production.up.railway.app/swagger-ui/index.html

---

## 🚀 Features

### Authentication
- User Signup
- User Login
- BCrypt password encryption
- JWT token generation

### Role-Based Access Control
- CUSTOMER
- DRIVER
- ADMIN

### Driver Management
- Add drivers
- Driver availability tracking

### Order Management
- Place order
- Automatic driver assignment
- Track order status
- Update delivery stages

### Delivery Analytics
- Total orders
- Delivered orders
- Active orders
- Cancelled orders

### Exception Handling
- Global exception handler
- Custom exceptions
- Structured error responses

### API Documentation
- Swagger UI integration

---

## 🛠 Tech Stack

| Layer | Technology |
|---------|------------|
| Language | Java |
| Framework | Spring Boot |
| Security | Spring Security + JWT |
| Database | MySQL |
| ORM | Spring Data JPA + Hibernate |
| Documentation | Swagger OpenAPI |
| Build Tool | Maven |
| Deployment | Railway |

---

## 📁 Project Structure

```text
src/main/java/com/smartdelivery
│
├── config
├── controller
├── dto
├── exception
├── model
├── repository
├── security
├── service
└── SmartDeliverySystemApplication.java
```

---

## 🔐 Authentication Flow

```text
Signup
   ↓
Password encrypted using BCrypt
   ↓
Login
   ↓
JWT Token generated
   ↓
Token sent in Authorization Header
   ↓
Protected APIs accessed
```

---

## 📦 Order Lifecycle

```text
PLACED
   ↓
PREPARING
   ↓
OUT_FOR_DELIVERY
   ↓
DELIVERED
```

---

## 📌 Sample APIs

### Signup

```http
POST /api/auth/signup
```

```json
{
  "name": "Anuj",
  "email": "anuj@gmail.com",
  "password": "123456"
}
```

---

### Login

```http
POST /api/auth/login
```

```json
{
  "email": "anuj@gmail.com",
  "password": "123456"
}
```

Returns:

```json
{
  "token": "JWT_TOKEN"
}
```

---

### Add Driver

```http
POST /api/drivers
```

```json
{
  "name": "Rahul",
  "available": true
}
```

---

### Place Order

```http
POST /api/orders/place
```

```json
{
  "userId": 1,
  "restaurantName": "Dominos",
  "deliveryAddress": "Mumbai"
}
```

---

### Get User Orders

```http
GET /api/orders/user/{userId}
```

---

### Update Order Status

```http
PUT /api/orders/{id}/status
```

Example:

```text
PREPARING
OUT_FOR_DELIVERY
DELIVERED
CANCELLED
```

---

### Delivery Analytics

```http
GET /api/orders/stats
```

---

## ▶ Running Locally

Clone repository:

```bash
git clone https://github.com/YOUR_USERNAME/smart-delivery-backend-system.git
```

Go inside project:

```bash
cd smart-delivery-backend-system
```

Run:

```bash
mvn spring-boot:run
```

Open:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🎯 Concepts Implemented

- Layered Architecture
- DTO Pattern
- Repository Pattern
- Dependency Injection
- JWT Authentication
- Spring Security
- Exception Handling
- REST APIs
- MySQL Integration
- Swagger Documentation

---

## 📈 Future Improvements

- Email notifications
- Redis caching
- Docker support
- Kafka event streaming
- Payment gateway integration
- Microservices architecture

---

## 👨‍💻 Author

**Anuj Gupta**

Interested in:
- Backend Development
- Java & Spring Boot
- Distributed Systems
- Software Engineering
