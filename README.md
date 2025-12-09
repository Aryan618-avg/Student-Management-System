# Student Management System (JavaFX + MySQL)
A simple and efficient Student Management System built using JavaFX, MySQL, and JDBC.
This desktop application allows users to add, view, and manage student records with a clean and responsive UI.
## 🚀 Features
🎨 JavaFX UI with modern styling  
➕ Add new students  
👁 View all students in a table  
📝 Store student records in a MySQL database  
🔄 MVC structure (Controllers, DAO, Model)  
📦 JDBC MySQL Connector integration  
⚙ Works with XAMPP or standalone MySQL server
## 🛠 Tech Stack
| Component  | Technology                    |
| ---------- | ----------------------------- |
| Frontend   | JavaFX (FXML)                 |
| Backend    | Java 17+                      |
| Database   | MySQL (XAMPP or local server) |
| Build Tool | Manual CLI (javac/java)       |
| Connector  | mysql-connector-j-8.x.x.jar   |
## 📁 Project Structure
```
StudentManagementSystem/
│
├── lib/
│ └── mysql-connector-j-8.0.33.jar
│
├── out/ (compiled .class files)
│
├── src/
│ ├── Main.java
│ ├── DBConnection.java
│ ├── Student.java
│ ├── StudentDAO.java
│ │
│ ├── controllers/
│ │ ├── DashboardController.java
│ │ ├── AddStudentController.java
│ │ └── ViewStudentsController.java
│ │
│ └── views/
│ ├── dashboard.fxml
│ ├── add_student.fxml
│ └── view_students.fxml
│
└── resources/
└── styles.css
```
## Database Setup (MySQL)
1. Start MySQL from XAMPP  
2. Open phpMyAdmin  
3. Create database:  
   CREATE DATABASE student_db;
4. Create table:  
   CREATE TABLE students (  
    id INT AUTO_INCREMENT PRIMARY KEY,  
    name VARCHAR(100) NOT NULL,  
    age INT NOT NULL,  
    gender VARCHAR(10) NOT NULL,  
    course VARCHAR(50) NOT NULL,  
    email VARCHAR(100) NOT NULL,  
    phone VARCHAR(15) NOT NULL  
);    
## 🔌 Database Connection  
DBConnection.java  
private static final String URL = "jdbc:mysql://localhost:3306/student_db";  
private static final String USER = "root";  
private static final String PASSWORD = "";  
## ▶ Running the Project  
1️⃣ Set JavaFX path  
$env:PATH_TO_FX="D:\javafx-sdk-21.0.1\lib"  
2️⃣ Compile  
javac --module-path $env:PATH_TO_FX --add-modules javafx.controls,javafx.fxml `  
-cp "lib/mysql-connector-j-8.0.33.jar" `  
-d out `  
(Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })          
3️⃣ Run  
java --module-path $env:PATH_TO_FX --add-modules javafx.controls,javafx.fxml `  
-cp "out;lib/mysql-connector-j-8.0.33.jar" `  
Main  
## 🎯 Screenshots  
<img width="1919" height="1007" alt="image" src="https://github.com/user-attachments/assets/103d03b1-8aa7-49b7-895b-3975f1be410e" />  
<img width="1919" height="1003" alt="image" src="https://github.com/user-attachments/assets/d1a0660b-fc20-406f-bc04-df6e47ec59ad" />  
<img width="1900" height="890" alt="image" src="https://github.com/user-attachments/assets/67f2b007-d7f4-428f-b965-0064665473ee" />  

## ✨ Future Enhancements  
- Edit student details  
- Delete student  
- Search functionality  
- Login & authentication  
- Export to Excel/PDF  
- Dark mode UI  



 

