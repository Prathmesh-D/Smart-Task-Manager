# 🧠 Smart Task Manager 🗂️  
> A minimalist desktop app to plan, prioritize, and manage your daily tasks effectively.

---

<p align="center">
  <img src="https://img.shields.io/badge/Status-🚧%20Under%20Construction-yellow?style=for-the-badge&logo=progress&logoColor=black" />
  <img src="https://img.shields.io/badge/Built%20With-Java-blue?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/UI-Swing%20+%20FlatLaf-lightgrey?style=for-the-badge&logo=windows&logoColor=black" />
  <img src="https://img.shields.io/badge/Database-SQLite-green?style=for-the-badge&logo=sqlite&logoColor=white" />
</p>

---

## ⚠️ UNDER CONSTRUCTION ZONE  
<p align="center">
  <img src="https://media.giphy.com/media/VbnUQpnihPSIgIXuZv/giphy.gif" height="400" alt="Caution Tape" />
  <img src="https://media.giphy.com/media/xT9IgzoKnwFNmISR8I/giphy.gif" height="400" alt="Bug Fixing" />
</p>





🛠️ Work in progress!  
The foundations are being laid, wires are being connected, and buttons are coming to life.  
  
**🚧 This project is actively being developed. Expect sawdust, glitches, and sparks flying! 🚧**

---

## 🎯 Project Overview

The **Smart Task Manager** is a lightweight desktop productivity tool designed to help users:

- 📋 Create, edit, and delete tasks
- 🏷️ Assign priorities to tasks
- ⏰ Get notified of upcoming deadlines
- 💾 Store tasks using SQLite database (with `ArrayList` for runtime handling)
- 🎨 Enjoy a modern and clean UI using Swing + FlatLaf

---

## 🛠️ Current Features

- ✅ Add Task with title, description, and due date
- ✅ Task priority tagging (High, Medium, Low)
- ✅ Task storage using `ArrayList`
- 🚧 Swing UI with FlatLaf for modern look
- 🚧 SQLite integration (in progress)
- 🚧 Notification/reminder system (coming soon)
- 🚧 Task status filters (All / Completed / Pending)

---

## 🔜 Planned Features

- [ ] Task editing & deletion
- [ ] Due-date based sorting
- [ ] System tray support
- [ ] Export tasks to CSV
- [ ] Dark/Light theme toggle
- [ ] Daily summary popup

---

## 📦 Tech Stack

| Component     | Technology      |
|---------------|-----------------|
| Language       | Java            |
| GUI Framework  | Swing + FlatLaf |
| Database       | SQLite (via JDBC) |
| IDE            | VS Code         |
| Build Tool     | Manual (no Maven/Gradle) |

---

## 📁 Project Structure

```bash
SmartTaskManager/
├── src/
│   ├── ui/           # Swing UI Components
│   ├── model/        # Task Class & Priorities
│   ├── db/           # SQLite Connection Utilities
│   └── logic/        # Task Manager logic
├── resources/
│   └── icons/        # App icons
└── README.md
