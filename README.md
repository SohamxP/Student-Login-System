# 🎓 Student Login System

A robust and extensible Student Login System built with Java. This project enables easy management of student authentication, registration, and session handling, crafted for clarity, security, and extensibility.

---

## 📚 Table of Contents

- 🌟[Features](#-features)
- 🗂️[Project Structure](#️-project-structure)
- 🛠️[Technologies Used](#️-technologies-used)
- 🚀[Setup & Installation](#-setup--installation)
- 💡[Usage](#-usage)
- 🤝[Contributing](#-contributing)
- [📬Contact](#-contact)

---

## 🌟 Features

- 🔐 Student registration and login with secure password handling
- 🗝️ Session management for authenticated users
- ❌ Input validation and error messaging
- 🧩 Modular, extensible code structure
- 💻 Simple and clean UI (in `webapp/`)
- 🛢️ Easy integration with databases (extendable)
- 🏃‍♂️ Ready for deployment on servlet containers (e.g., Tomcat)

---

## 🗂️ Project Structure

```
Student-Login-System/
│
├── .gitignore
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/                
│       └── webapp/
│           ├── login.html
│           ├── register.html
│           └── WEB-INF/
│               └── web.xml
```

### 📄 Source Files

#### HTML Files

| Path                                    | Description           |
|-----------------------------------------|-----------------------|
| `src/main/webapp/login.html`            | Login form            |
| `src/main/webapp/register.html`         | Registration form     |

#### Java Files
| Path                                                          | Description           |
|---------------------------------------------------------------|-----------------------|
| `src/main/java/com/student/login/HomeServlet.java`            | Student home page     |
| `src/main/java/com/student/login/LoginServlet.java`           | Login form handler    |
| `src/main/java/com/student/login/LogoutServlet.java`          | Logout handler        |
| `src/main/java/com/student/login/PasswordUtil.java`           | Pasword hashing tool  |
| `src/main/java/com/student/login/RegistrationServlet.java`    | Registration Handler  |
| `src/main/java/com/student/login/User.java`                   | User data model       |
| `src/main/java/com/student/login/Userstore.java`              | User storage manager  |

#### Config & Other Files

| Path                                | Description                        |
|-------------------------------------|------------------------------------|
| `.gitignore`                        | Git ignore rules                   |
| `pom.xml`                           | Maven dependencies & build config  |
| `src/main/webapp/WEB-INF/web.xml`   | Web application deployment config  |

---

## 🛠️ Technologies Used

- **Java** (backend logic)
- **Servlet/JSP** (web layer)
- **Maven** (project management, dependency resolution)
- **HTML** (frontend, in `webapp/`)
- **Git** (version control)

---

## 🚀 Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/SohamxP/Student-Login-System.git
   cd Student-Login-System
   ```

2. **Build with Maven**
   ```bash
   mvn clean install
   ```

3. **Deploy to Server**
   - Deploy the generated WAR file (`target/*.war`) to your servlet container (e.g., Apache Tomcat).

4. **Configure Database** (if required)
   - Update database connection settings in configuration files if integrating with a database.

---

## 💡 Usage

- Launch your servlet container and access the app via your browser.
- Register a new student account or log in with existing credentials.
- Manage your session securely.

---

## 🤝 Contributing

Contributions are welcome!  
To get started:

1. **Fork** this repository.
2. **Create a branch** (`git checkout -b feature/your-feature`).
3. **Commit** your changes (`git commit -am 'Add new feature'`).
4. **Push** to your branch (`git push origin feature/your-feature`).
5. **Open a Pull Request**.

---

## 📬 Contact

**Repository Owner:** [SohamxP](https://github.com/SohamxP)  
For questions, suggestions, or contributions, please open an issue or submit a pull request.

---
