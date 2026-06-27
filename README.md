# 📩 In-App Notification Center

A Spring Boot REST API that provides an in-app notification system without relying on email or SMS. Users can create notifications, retrieve all notifications, and mark notifications as read. Notifications are stored in a MySQL database using Spring Data JPA and Hibernate.

---

## 🚀 Features

- Create new notifications
- View all notifications
- Mark notifications as read
- Automatic database table creation using Hibernate
- RESTful API implementation
- MySQL database integration
- Layered architecture (Controller → Service → Repository)

---

## 🛠️ Tech Stack

- Java 26
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- VS Code

---

## 📂 Project Structure

```
notificationcenter
│── src
│   ├── main
│   │   ├── java
│   │   │   └── com/shreya/notificationcenter
│   │   │       ├── controller
│   │   │       │      NotificationController.java
│   │   │       ├── service
│   │   │       │      NotificationService.java
│   │   │       ├── repository
│   │   │       │      NotificationRepository.java
│   │   │       ├── model
│   │   │       │      Notification.java
│   │   │       └── NotificationcenterApplication.java
│   │   └── resources
│   │          application.properties
│── pom.xml
│── README.md
```

---

## 🏗️ Architecture

```
Browser / Postman
        │
        ▼
NotificationController
        │
        ▼
NotificationService
        │
        ▼
NotificationRepository
        │
        ▼
      MySQL Database
```

---

## ⚙️ Database Configuration

Update your `application.properties` with your MySQL credentials.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/notificationdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Running the Project

### Clone the repository

```bash
git clone https://github.com/shreyaellendula/notification-center.git
```

### Navigate to the project

```bash
cd notification-center
```

### Build the project

```bash
mvn clean install -DskipTests
```

### Run the application

```bash
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

---

## 📡 REST API Endpoints

### 1. Create Notification

**POST** `/notifications`

#### Request

```json
{
    "message": "Interview at 3PM"
}
```

#### Response

```json
{
    "id": 1,
    "message": "Interview at 3PM",
    "read": false,
    "createdAt": "2026-06-27T15:56:50"
}
```

---

### 2. Get All Notifications

**GET** `/notifications`

#### Response

```json
[
    {
        "id": 1,
        "message": "Interview at 3PM",
        "read": false,
        "createdAt": "2026-06-27T15:56:50"
    }
]
```

---

### 3. Mark Notification as Read

**PATCH** `/notifications/{id}/read`

Example:

```
PATCH /notifications/1/read
```

#### Response

```json
{
    "id": 1,
    "message": "Interview at 3PM",
    "read": true,
    "createdAt": "2026-06-27T15:56:50"
}
```

---

## 🗄️ Database Schema

**Table:** `notifications`

| Column | Type |
|---------|------|
| id | BIGINT |
| message | VARCHAR(255) |
| is_read | BOOLEAN |
| created_at | DATETIME |

---

## 📈 Future Enhancements

- User authentication
- Notification categories
- Delete notifications
- Filter unread notifications
- Pagination and sorting
- Notification priority
- Frontend integration (React/Angular)

