# Car Rental System

## Project Overview
The **Car Rental System** is a robust Java-based desktop application designed to streamline the operations of a car rental business. It provides a user-friendly graphical interface to manage car inventory, customer records, and the complete lifecycle of car rentals and returns. 

The primary purpose of this project is to eliminate manual record-keeping, reduce errors, and automate renting processes. It is highly useful for car rental agencies looking for a reliable, offline computerized system to track their assets and clients efficiently.

---

## Features
1. **Admin Authentication**: 
   - Secure login system for authorized personnel to access the dashboard.
2. **Car Management (CRUD)**: 
   - Add, edit, and delete car details including Registration Number, Brand, Model, and Availability status.
   - Auto-generation of Car IDs.
3. **Customer Management (CRUD)**: 
   - Register new customers with their Name, Address, and Mobile Number.
   - Update or delete existing customer records.
   - Auto-generation of Customer IDs.
4. **Car Rental Processing**: 
   - Rent a car to a registered customer.
   - Select rent dates (Date Out and Date Due In) using an integrated calendar.
   - Input rental fees and automatically mark the selected car as "Unavailable".
5. **Car Return & Fine Calculation**: 
   - Process car returns using the Car ID.
   - Automatically calculate "Days Elapsed" if returned late and compute the corresponding "Fine".
   - Restores car availability status in the inventory.

---

## Technologies Used
- **Programming Language**: Java
- **UI Framework**: Java Swing & AWT (Built using NetBeans GUI Builder)
- **Database**: SQLite (Lightweight, serverless relational database)
- **Database Connectivity**: JDBC (Java Database Connectivity)
- **External Libraries**: 
  - `sqlite-jdbc-3.36.0.3.jar`: SQLite JDBC Driver for database operations.
  - `JCalendar`: For date selection in the rental process (`JDateChooser`).
- **IDE**: NetBeans IDE (implied by the `nbproject/` directory and `.form` files)

---

## Project Structure
```text
car_rental_system/
│
├── src/carrentalsystemproject/      # Contains all Java source code and UI form files
│   ├── Main.java                    # Dashboard & navigation hub
│   ├── LogIn.java                   # Authentication UI and logic
│   ├── CarRegistration.java         # Car Management module
│   ├── Customer.java                # Customer Management module
│   ├── Rent.java                    # Rental processing module
│   ├── Returncar.java               # Car returning & fine calculation module
│   ├── InitDB.java                  # Database initialization script
│   ├── Tables.java                  # SQL Table creation schemas
│   └── DBConncetion.java            # Database connection utility
│
├── lib/                             # External dependencies
│   └── sqlite-jdbc-3.36.0.3.jar     # SQLite JDBC driver
│
├── carrental.db                     # The SQLite database file
└── build.xml / nbproject/           # Ant build scripts and NetBeans project configuration
```

---

## How It Works
1. **Initialization**: When the app starts (or via `InitDB`), it ensures the database `carrental.db` and all required tables exist. It inserts a default test admin account (`admin` / `admin`).
2. **Authentication**: The user logs in via the `LogIn` JFrame. Upon success, they are redirected to the `Main` dashboard.
3. **Dashboard Navigation**: The dashboard provides quick access to Car Registration, Customer Registration, Rent Car, and Return Car.
4. **Data Grid Views**: Most modules (Cars, Customers, Returns) display records in a live `JTable` connected to the SQLite database, reflecting real-time data.
5. **Transactions**: 
   - When renting, it validates if the Customer ID exists and updates the Car's availability to "No".
   - When returning, it queries the rental record, calculates any overdue fines using `DATEDIFF`, removes the rental record, logs the return, and resets the Car's availability to "Yes".

---

## Installation and Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed.
- NetBeans IDE (recommended) or IntelliJ IDEA / Eclipse.

### Steps to Run Locally
1. **Clone/Download the Repository**: Extract the project files to your local machine.
2. **Open in IDE**: Open NetBeans IDE, go to `File > Open Project`, and select the `car_rental_system` folder.
3. **Add Libraries**:
   - Right-click on the `Libraries` folder in your project explorer.
   - Choose `Add JAR/Folder`.
   - Select the `sqlite-jdbc-3.36.0.3.jar` file located in the `lib/` directory.
   - (If needed, add the `jcalendar` jar dependency similarly for the date picker to compile).
4. **Database Setup**: The project uses SQLite, which doesn't require a separate server installation. The database `carrental.db` is already present.
5. **Run the Project**: 
   - Locate and right-click `LogIn.java` or `Main.java` inside `src/carrentalsystemproject/`.
   - Click **Run File** (or Shift+F6).
6. **Login Credentials**: 
   - **Username**: admin
   - **Password**: admin

---

## Database Logic & Schema
The project uses SQLite with the following core tables:
- `Group16_LogIn`: Stores admin `Username` and `Password`.
- `Group16_CarRegistrationTable`: Stores `CarRegNo` (PK), `Brand`, `Model`, and `Available` (Yes/No).
- `Group16_CustomerRegistrationTable`: Stores `CustomerID` (PK), `Name`, `Address`, `Mobile`.
- `Group16_Rents`: Tracks active rentals with `CarID`, `CustomerID`, `Fee`, `DateOut`, `DateDueIn`.
- `Group16_ReturnCar`: Logs completed transactions with `CarID`, `CustomerID`, `ReturnDate`, `DaysElapsed`, `Fine`.

---

## Key Concepts & Technical Details
- **Object-Oriented Programming (OOP)**: Clear separation of concerns with distinct classes for specific functionalities (e.g., UI vs Database Connection).
- **CRUD Operations**: Complete implementation of Create, Read, Update, and Delete operations using JDBC `PreparedStatement`.
- **Event-Driven Programming**: Utilization of `MouseListener` and `ActionListener` for UI interactions like table-row clicking and button presses.
- **Dynamic ID Generation**: Auto-incrementing string IDs (e.g., C001, C002, A001) parsed and calculated from database max IDs.

---

## Challenges and Solutions
- **Handling Dates in Java UI**: Capturing user-friendly dates could lead to parsing errors. **Solution**: Integrated the `JCalendar` plugin (`JDateChooser`) to ensure standardized `yyyy-MM-dd` date formats before saving them to the database.
- **Relational Integrity without Foreign Keys**: Maintaining correct states (Car Availability) when a car is rented out. **Solution**: Used bundled SQL `UPDATE` queries during the Rent and Return transactions to instantly toggle availability flags.

---

## Future Improvements
- **Password Encryption**: Implement hashing (e.g., BCrypt) for stored passwords instead of plain text.
- **Role-Based Access Control**: Add user roles such as "Admin" and "Employee" with different dashboard permissions.
- **Reporting**: Add a module to generate visual charts or PDF reports for monthly earnings and most rented cars.
- **Search capabilities**: Implement a search bar to instantly filter Car and Customer Tables.

---


