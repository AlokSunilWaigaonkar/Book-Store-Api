# 📚 Bookstore Management System - Spring Boot API

A RESTful web service built with **Spring Boot** for managing books and authors in a bookstore.  
It supports full CRUD operations, pagination, and relational data handling using **MySQL** as the backend database.

---

## 🚀 Features

- ➕ Create Authors  
- ➕➖✏️ Create, Update & Delete Books  
- 📄 View Paginated List of Books  
- 🔁 Nested JSON response with embedded Author info  
- 🧪 Postman-tested APIs  
- ⚠️ Global Exception Handling with custom error response  

---

## ⚙️ Tech Stack

- **Java 17**  
- **Spring Boot 3.5**  
- **Spring Data JPA**  
- **MySQL**  
- **Postman** (for API testing)

---

## 🛠️ Project Setup

### ✅ Prerequisites

- Java 17+  
- Maven  
- MySQL Server  

### 📥 Clone & Run

```bash
git clone https://github.com/YOUR_USERNAME/bookstore-api.git
cd bookstore-api
```

---

## 🗄️ Configure MySQL

Update the `application.properties` file as shown below:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/book-store-db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

> Make sure to replace `YOUR_PASSWORD` with your MySQL root password.

---

## 📡 Sample API Requests

### ➕ Add Author  
**Endpoint:** `POST /author`  
**Request Body:**

```json
{
  "name": "Joshua Bloch",
  "bio": "Author of 'Effective Java', former Java architect at Google.",
  "dateOfBirth": "1961-08-28"
}
```

---

### ➕ Add Book  
**Endpoint:** `POST /books/addBook`  
**Request Body:**

```json
{
  "title": "Harry Potter and the Philosopher's Stone",
  "description": "The first book in the Harry Potter series.",
  "price": 499.99,
  "publishedDate": "1997-06-26",
  "authorId": 2
}
```

---

### 📄 Get Paginated Books  
**Endpoint:** `GET /book?page=0&size=2`  
**Sample Response:**

```json
{
  "success": true,
  "message": "Books fetched successfully",
  "data": {
    "books": [
      {
        "id": 4,
        "title": "1984",
        "description": "A dystopian novel about totalitarianism and surveillance.",
        "price": 299.5,
        "publishedDate": "1949-06-08T00:00:00.000+00:00",
        "author": {
          "id": 1,
          "name": "George Orwell",
          "bio": "English novelist and journalist, known for '1984' and 'Animal Farm'.",
          "dateOfBirth": "1903-06-25T00:00:00.000+00:00"
        }
      },
      {
        "id": 5,
        "title": "Harry Potter and the Philosopher's Stone",
        "description": "The first book in the Harry Potter series.",
        "price": 499.99,
        "publishedDate": "1997-06-26T00:00:00.000+00:00",
        "author": {
          "id": 2,
          "name": "J.K. Rowling",
          "bio": "British author best known for the Harry Potter series.",
          "dateOfBirth": "1965-07-31T00:00:00.000+00:00"
        }
      }
    ],
    "currentPage": 1,
    "totalPages": 2,
    "totalElements": 4
  }
}
```

---

## 📸 Screenshots

### ✅ Postman Test Results

> *(Add your Postman screenshots by replacing the placeholders below)*

![Postman Screenshot 1](link-to-screenshot1)
![Postman Screenshot 2](link-to-screenshot2)
![Postman Screenshot 3](link-to-screenshot3)
![Postman Screenshot 4](link-to-screenshot4)
![Postman Screenshot 5](link-to-screenshot5)
![Postman Screenshot 6](link-to-screenshot6)

---
