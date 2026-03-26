# 📚 Library Management System (JDBC - Java + MySQL)

 📌 Project Overview

The **Library Management System** is a console-based Java application developed using **JDBC (Java Database Connectivity)** to perform fundamental library operations. This project demonstrates how a Java application can interact with a relational database (**MySQL**) to manage records efficiently.

The system enables users to perform essential tasks such as adding new books, viewing available records, issuing books, returning books, and deleting entries. It follows a simple and structured approach suitable for academic learning and practical understanding of database connectivity.

---

 🎯 Objectives

* To understand the implementation of JDBC in Java.
* To perform CRUD (Create, Read, Update, Delete) operations using MySQL.
* To design a simple real-world application using a console-based interface.
* To demonstrate database-driven application logic using Java.

---

## ⚙️ Technologies Used

* **Java (JDK 8 or above)**
* **JDBC API**
* **MySQL Database**
* **MySQL Connector/J (JDBC Driver)**

---

 🏗️ Project Structure

The project is implemented using a **single package structure** for simplicity:

```
com.lib
│
├── DBConnection.java   // Handles database connection
├── Book.java           // Model class representing Book entity
├── BookDAO.java        // Data Access Object (CRUD operations)
└── MainApp.java        // Main class with menu-driven interface
```

---

 🗄️ Database Design

 Database Name:

`library_db`

 Table: `books`

| Column | Type         | Description                     |
| ------ | ------------ | ------------------------------- |
| id     | INT (PK)     | Unique Book ID (Auto Increment) |
| title  | VARCHAR(100) | Name of the book                |
| author | VARCHAR(100) | Author of the book              |
| status | VARCHAR(20)  | Book availability status        |

Status Values:

* `Available`
* `Issued`

---

 Features

 1. Add Book

Allows the user to insert a new book record into the database.

 2. View Books

Displays all books along with their details and availability status.

 3. Issue Book

Marks a book as **Issued**, indicating it is currently borrowed.

 4. Return Book

Updates the book status back to **Available**.

 5. Delete Book

Removes a book record from the database.

---

 Working Flow

1. The application starts with a menu-driven interface.
2. The user selects an operation.
3. The request is processed through the `BookDAO` class.
4. JDBC connects to MySQL via `DBConnection`.
5. SQL queries are executed using **PreparedStatement**.
6. Results are displayed on the console.

---

 Key Concepts Used

* **JDBC API**
* **PreparedStatement** (prevents SQL injection)
* **ResultSet** (retrieves data from database)
* **DAO (Data Access Object) Design Pattern**
* **Separation of Concerns**

---

 How to Run the Project

1. Install MySQL and create the database using:

   ```sql
   CREATE DATABASE library_db;
   ```

2. Create the table:

   ```sql
   CREATE TABLE books (
       id INT PRIMARY KEY AUTO_INCREMENT,
       title VARCHAR(100),
       author VARCHAR(100),
       status VARCHAR(20)
   );
   ```

3. Add MySQL Connector/J JAR file to your project.

4. Update database credentials in `DBConnection.java`:

   ```java
   private static final String USER = "root";
   private static final String PASSWORD = "your_password";
   ```

5. Compile and run `MainApp.java`.

---

 Future Enhancements

* Add user authentication (Admin/Login system)
* Implement GUI using Java Swing or JavaFX
* Introduce book search functionality
* Add fine calculation for late returns
* Maintain user and transaction history

---

 Academic Relevance

This project is ideal for students learning:

* Database connectivity in Java
* Basic software architecture (DAO pattern)
* Real-world CRUD applications

---

