# Apna Wallet - Banking Application

This is a simple **Banking Application** built using **Java** and **Swing**. The application provides a graphical user interface (GUI) for managing basic banking operations, such as logging in, account management, and performing transactions.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [License](#license)

## Features

This application includes the following features:

- **User Login**: Secure login system with account number and PIN authentication.
- **Close Button Interaction**: Custom close button with hover effects.
- **Dynamic UI Components**: User-friendly GUI built with Java Swing components.
- **Error Handling**: Input validation with error dialogs.
- **Seamless Navigation**: Simple navigation between different screens (e.g., Home Page, Register Frame).

## Technologies Used

- **Java**: 17.0.10
- **Swing**: Java's built-in GUI toolkit for creating graphical interfaces.
- **AWT**: Abstract Window Toolkit for UI event handling.

## Project Structure

Here is the directory structure of the project:

```
└──src/
|   └── GraphicsPack/
|   |   ├── LoginFrame.java
|   |   ├── RegisterFrame.java
|   |   ├── UIUtils.java
|   |   └── ...
|   ├── Images/
|   |   ├── close.png
|   |   ├── logo.png
|   |   └── ...
|   └── pack/
|   |   ├── Account.java
|   |   ├── AccountLogin.java
|   |   ├── AccountRegistration.java
|   |   └── ...
|   └── run.java
├── .gitignore
├── LICENSE
└── README.md
```

## Setup and Installation

Follow these steps to set up and run the project:

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Mohammad-Subhan/ApnaWallet-Banking-Application.git
   cd ApnaWallet-Banking-Application
   ```

2. **Setup the Database**:
   Update the database user and password credentials in the src/pack/Database.java file:

   ```java
   // Database.java
   public class Database {
       private static String USER = "your-database-username";
       private static String PASSWORD = "your-database-password";
   }
   ```
   Run the following sql script:
   ```sql
   CREATE DATABASE user_accounts;

   USE user_accounts;

   SET SQL_SAFE_UPDATES = false;

   CREATE TABLE users(
      accountNum varchar(100) PRIMARY KEY,
      fullName varchar(200),
      fatherName varchar(200),
      dob varchar(50),
      cnic varchar(50),
      gender varchar(50),
      email varchar(100),
      phoneNum varchar(100),
      pinCode varchar(50),
      initialDeposit varchar(100),
      balance varchar(100)
   );
   ```

3. **Compile the Code**:
   Change directory to src:

   ```bash
   cd src
   ```

   Use your preferred IDE or compile manually:

   ```bash
   javac run.java
   ```

4. **Run the Application**:
   Execute the main script:

   ```bash
   java run.java
   ```

## Usage

- Launch the application to see the **Login Screen**.
- Input a valid **Account Number** and **PIN** to log in.
- Use the **Register** link to create a new account.
- Navigate through the GUI to access other features.

## License

This project is licensed under the [MIT License](LICENSE).

## Author

Developed by **Mohammad-Subhan**.

Thank you for checking out the project!
