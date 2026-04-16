# 📧 RabbitMQ Email Service (Mailgun)

A simple and practical project to learn **RabbitMQ** and build an **asynchronous email service** using the **Mailgun API**.

---

## 🚀 Features

* 📤 Send messages using RabbitMQ (Producer)
* 📥 Consume messages using RabbitMQ (Consumer)
* ✉️ Send emails via Mailgun API
* ⚡ Asynchronous email processing (non-blocking system)

---

## 🛠️ Tech Stack

* **Java (Spring Boot)**
* **RabbitMQ**
* **Mailgun API**
* **Unirest (HTTP Client)**

---

## 📂 Project Flow

```text
[Client Request]
        ↓
   Producer API
        ↓
   RabbitMQ Queue
        ↓
    Consumer
        ↓
 Mailgun Email API
        ↓
   Email Sent ✅
```

---

## ⚙️ Configuration

Add the following properties in your `application.properties`:

```properties
mailgun.api.key=YOUR_API_KEY
mailgun.domain=YOUR_DOMAIN
mailgun.from.email=YOUR_EMAIL
```

---

## ▶️ How to Run

1. Start **RabbitMQ Server**
2. Run the **Spring Boot Application**
3. Send API request (Producer)
4. Consumer processes the message
5. Email is sent asynchronously via Mailgun

---

## 📌 Purpose

This project is created to understand:

* Event-driven architecture
* Message queues (RabbitMQ)
* Real-world email service integration
* Asynchronous system design

---

## 💡 Future Improvements

* Add retry mechanism for failed emails
* Implement Dead Letter Queue (DLQ)
* Add logging & monitoring
* Replace Unirest with Spring WebClient (production-ready)

---

## 👨‍💻 Author

**Harsh**
Java Backend Developer (Learning Phase 🚀)

---
