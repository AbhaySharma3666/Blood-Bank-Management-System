# 🩸 Blood Bank Management System  

🚀 **A Java-based Blood Bank Management System** built using **IntelliJ IDEA**.  
This system helps manage blood donors, blood stock, and donations efficiently.  

---

## 📌 Features  

✅ **Donor Management** - Add, update, and search donors  
✅ **Stock Management** - Maintain and track available blood units  
✅ **Secure Database** - Stores data in **MySQL**  
✅ **User-Friendly Interface** - Easy navigation and intuitive UI  

---

## ⚙️ Tech Stack  

- **Java** (Core Java, JDBC)  
- **MySQL** (Database)  
- **IntelliJ IDEA** (IDE)  
- **JavaFX** (GUI - optional)  

---

## 🛠️ Setup & Installation  

### 1️⃣ Clone the Repository  

Run the following command in your terminal:  

```sh
git clone https://github.com/your-username/BloodBankManagement.git 
cd BloodBankManagement
```

---

# 📂 Database Setup

### 2️⃣ Install & Configure MySQL
- Download & install MySQL Server and MySQL Workbench from MySQL Official Website.
- Start MySQL Server and log in using root credentials.

### 3️⃣ Create the Database
Run the following SQL commands in MySQL:

-- Create the database
```mysql
CREATE DATABASE IF NOT EXISTS blood_bank_ms;
```

-- Select the database
```mysql
USE blood_bank_ms;
```

-- Create the donor table
```mysql
CREATE TABLE donor (
    donorId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    fatherName VARCHAR(100) NOT NULL,
    motherName VARCHAR(100) NOT NULL,
    DOB DATE NOT NULL,
    MobileNo VARCHAR(20) NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    email VARCHAR(100) NOT NULL,
    bloodGroup VARCHAR(3) NOT NULL,
    city VARCHAR(100),
    address VARCHAR(255)
);
```
-- Create the stock table
```mysql
CREATE TABLE stock (
    bloodGroup VARCHAR(3) PRIMARY KEY,
    units INT NOT NULL DEFAULT 0
);
```

---

### 🔌 Setting Up MySQL Connector/J 9.0.0 in IntelliJ IDEA

### 4️⃣ Download & Add MySQL Connector/J 9.0.0
- Download MySQL Connector/J 9.0.0 from MySQL Connector Download Page.
- Extract the downloaded ZIP file.
- Copy the mysql-connector-j-9.0.0.jar file.

### 5️⃣ Add MySQL Connector in IntelliJ IDEA
**Method 1: Add as an External Library**
1. Open IntelliJ IDEA and your project.
2. Go to File > Project Structure > Libraries.
3. Click "+" (Add Library) and select Java.
4. Navigate to the folder where mysql-connector-j-9.0.0.jar is located.
5. Select the JAR file and click OK.
6. Click Apply and OK to save changes.

**Method 2: Add Dependency in Maven (If using Maven)**
<p>If your project is using Maven, add this dependency to your pom.xml file:</p>

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.0.0</version>
</dependency>
```
<p>Run the following command to update dependencies:</p>

```sh
mvn clean install
```

---

### 🔗 Connecting Java to MySQL Database
## 6️⃣ Configure Database Connection in Java
Modify the db.properties file with your MySQL credentials and use JDBC to connect:
<p>This file is already provided inside Priject => ConnectionProvider</p>

### 🚀 Running the Project
## 7️⃣ Steps to Run in IntelliJ IDEA
1. Ensure MySQL is running on your system.
2. Run the SQL script in MySQL to create the database.
3. Set up MySQL Connector/J in IntelliJ IDEA (as shown above).
4. Compile & run the Java project in IntelliJ IDEA

### 🎯 Future Enhancements
🔹 Add Admin Dashboard
🔹 Implement Donation History tracking
🔹 Integrate SMS/Email notifications

### 🖼️ Panel Image
![Screenshot 2025-03-27 201552](https://github.com/user-attachments/assets/6dfaaa04-fc51-4260-9243-237680ef2e43)
![Screenshot 2025-03-27 201607](https://github.com/user-attachments/assets/ff099a10-f68f-44f3-8ffe-8371b2c3d244)
![Screenshot 2025-03-27 201623](https://github.com/user-attachments/assets/d9146f2e-f0ab-4369-adc2-ebb736ac5511)
![Screenshot 2025-03-27 201706](https://github.com/user-attachments/assets/d2457b6f-0d58-47f0-9b35-0740155aae76)
![Screenshot 2025-03-27 201722](https://github.com/user-attachments/assets/53ae4127-8c18-4733-b8b6-9e3437dd67b4)
![Screenshot 2025-03-27 201739](https://github.com/user-attachments/assets/57e64ada-3267-40f8-bc73-4e81390a324b)
![Screenshot 2025-03-27 201851](https://github.com/user-attachments/assets/60e6108b-0386-4779-8586-ba32de8712ef)
![Screenshot 2025-03-27 201908](https://github.com/user-attachments/assets/49153df7-f799-408f-bd77-679c8a45c02b)
![Screenshot 2025-03-27 201932](https://github.com/user-attachments/assets/ae4f9ea7-239a-49d9-b253-957dfec24079)


### 🤝 Contributing
Contributions are welcome! Fork the repo, create a branch, and submit a PR.

📜 License
This project is open-source under the MIT License.
