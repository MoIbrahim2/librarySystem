# Library System

A small Java project that demonstrates how common design patterns can work together in a simple library domain.

## What It Does

This project manages books in a library and supports:

- adding different types of books
- borrowing and returning books
- premium-only access for e-books
- premium books with extra borrowing time
- approval flow for borrowing requests based on requested days
- importing external book data from JSON format

## Design Idea

The system is built to keep responsibilities clear and separated:

- one shared `LibraryService` manages the library
- a factory creates books outside of the main application flow
- decorators extend book behavior without changing the original entity
- a proxy controls access to premium e-books
- a chain of responsibility handles request approvals
- a facade simplifies how the system is used
- an adapter converts external JSON data into internal book objects

## Project Goal

The goal of this project is to show how design patterns can solve real requirements in a clean and readable way, using a small and easy-to-follow Java example.

## Run

```bash
javac src/*.java
java -cp src Main
```
