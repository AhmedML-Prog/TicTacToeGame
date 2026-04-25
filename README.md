````md
# Multithreaded Tic-Tac-Toe Game (Java Swing)

A desktop Tic-Tac-Toe game developed using **Java Swing** with **Multithreading / Parallel Processing** concepts.

This project demonstrates how two player threads synchronize turns using Java thread communication methods such as:

- `Thread`
- `synchronized`
- `wait()`
- `notifyAll()`

---

## Features

- 3x3 Tic-Tac-Toe board
- Java Swing GUI
- Two-player mode (X / O)
- Turn status display
- Win detection
- Draw detection
- Restart button
- Multithreaded game logic

---

## Technologies Used

- Java
- Java Swing
- NetBeans IDE
- Multithreading

---

## Project Files

```text
Board.java
Game.java
PlayerThread.java
TicTacToe.java
Main.java
````

---

## How It Works

Two separate threads are created:

* Player X Thread
* Player O Thread

Only one player can move at a time. Threads are synchronized to avoid conflicts and ensure correct turn order.

---

## How to Run

1. Open the project in NetBeans / IntelliJ / Eclipse
2. Run `Main.java`
3. Start playing

---

## Concepts Used

* Java GUI Programming
* Event Handling
* Threads
* Synchronization
* Shared Resources
* Parallel Processing Basics

---
## Author

Ahmed Saleh
