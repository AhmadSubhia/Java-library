# Library Management System

A simple command-line library management system written in Java.

## Features

- Add books
- Register members
- Borrow books using ISBN
- Return books
- Search books by title or author
- Display all books sorted by title
- Handle invalid input
- Dynamically expand arrays when they are full

## Technologies

- Java
- Maven
- Git
- GitHub
- IntelliJ IDEA

## Project Structure

- `Book` - Record containing ISBN, title and author
- `Member` - Class representing a library member
- `Library` - Handles books, members, borrowing and returning
- `Main` - Command-line menu and user interaction

## Error Handling

The program handles invalid menu choices and invalid number input without crashing.

## Arrays

The project uses regular Java arrays instead of the Collections Framework, as required by the assignment.

When the arrays become full, new larger arrays are created manually and the existing data is copied over.

## Lessons Learned

During this project I practiced:

- Java syntax
- Variables and data types
- Methods
- Classes and objects
- Constructors
- Encapsulation
- Records
- Arrays
- Loops
- Error handling
- Searching and sorting
- Git and GitHub
- Maven
- Command-line applications

## How to Run

Run the `Main` class to start the application.

## Author

Ahmad