# 🎓 Student Management System (Java + JDBC + MySQL + Swing)

## 📌 Project Overview

This is a **Student Management System** developed using **Java**, **JDBC**, **MySQL**, and **Java Swing (GUI)**.
The application allows users to perform full **CRUD operations** (Create, Read, Update, Delete) on student data with a user-friendly interface.

---

## 🚀 Features

### 🔐 Authentication

* User login system (username & password)
* Secure validation using database

### 👨‍🎓 Student Management

* ➕ Add new student
* 📋 View all students (table format)
* 🔍 Search student by name
* 🧾 Get student by ID
* ✏️ Update student details
* ❌ Delete student

### 📊 Additional Features

* Sort students by percentage
* Input validation
* Exception handling
* Clean layered architecture (DAO pattern)

---

## 🛠️ Technologies Used

| Technology         | Purpose               |
| ------------------ | --------------------- |
| Java               | Core programming      |
| JDBC               | Database connectivity |
| MySQL              | Database              |
| Swing              | GUI (Desktop UI)      |
| Eclipse / IntelliJ | IDE                   |

---

## 📁 Project Structure

```
com.sjprogramming
 ├── db          → Database connection
 ├── model       → Student class
 ├── dao         → Data access logic
 ├── util        → Validation
 ├── main        → Console app
 └── gui         → Swing UI
```

---

## 🗄️ Database Setup

### 1. Create Database

```sql
CREATE DATABASE student_db;
USE student_db;
```

### 2. Create Tables

```sql
CREATE TABLE student_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sname VARCHAR(100),
    cname VARCHAR(100),
    city VARCHAR(100),
    percentage DOUBLE
);

CREATE TABLE users (
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users VALUES ('admin','admin123');
```

---

## ⚙️ Setup & Run

### 1. Clone Repository

```
git clone https://github.com/your-username/student-management-system.git
```

### 2. Add MySQL Connector

* Download MySQL Connector JAR
* Add to project build path

### 3. Update DB Credentials

In `DBConnection.java`:

```java
String user = "root";
String pass = "your_password";
```

---

## ▶️ How to Run

### 🔹 GUI Version (Recommended)

Run:

```
LoginFrame.java
```

### 🔹 Console Version

Run:

```
Client.java
```

---

## 🎯 Learning Outcomes

* JDBC & database connectivity
* DAO design pattern
* CRUD operations
* Java Swing GUI development
* Input validation & exception handling

---

## 🚀 Future Improvements

* Convert to Spring Boot (REST API)
* Add payment system
* Deploy on cloud
* Add React frontend

---

## 👨‍💻 Author

**Arun Kumar**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
