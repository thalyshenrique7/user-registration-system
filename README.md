# User Registration System

Backend application built with Java and Spring Boot, designed to simulate a production-ready environment with messaging, containerization, CI/CD, and observability.

---

## Overview

This project was developed to practice and demonstrate how modern backend systems are built and operated, covering not only API development but also infrastructure, messaging, and monitoring.

The application provides a simple user registration flow while integrating with external components such as RabbitMQ and exposing metrics for observability.

---

## Tech Stack

### Backend
- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Spring AMQP  

### Database
- PostgreSQL  

### Messaging
- RabbitMQ  

### Observability
- Spring Boot Actuator  
- Micrometer  
- Prometheus  
- Grafana  

### DevOps / Infrastructure
- Docker  
- Docker Compose  
- Jenkins (CI/CD)  

---

## Architecture

The project follows a modular and layered structure, separating concerns between domain, application, and infrastructure.

### Layers

- Controller layer for HTTP endpoints  
- Service layer for business logic  
- Repository layer for persistence  
- Messaging layer for event publishing (RabbitMQ)  

### Approach

It simulates an event-driven approach where actions in the system can produce asynchronous events.

---

## Features

- User registration API  
- Integration with PostgreSQL  
- Event publishing using RabbitMQ  
- Containerized environment with Docker Compose  
- CI/CD pipeline with Jenkins  
- Metrics exposure via Actuator  
- Monitoring with Prometheus and Grafana  

---

## Running the Project

### Requirements

- Docker  
- Docker Compose  
- Java 17 (optional for local run)  

---

### Run with Docker

```bash
mvn clean package
docker compose up --build
```

---

## Jenkins Setup

After starting the containers, it is necessary to install Maven inside the Jenkins container.

### Access Jenkins container

```bash
docker exec -it jenkins bin/sh
```

### Install Maven

```bash
apt update
apt install -y maven
exit
```

This step ensures that Jenkins can build the project during the CI/CD pipeline execution.

---

## Services

| Service        | URL                              |
|----------------|----------------------------------|
| Application    | http://localhost:9080            |
| Actuator       | http://localhost:8081/actuator   |
| Prometheus     | http://localhost:9090            |
| Grafana        | http://localhost:3000            |
| RabbitMQ UI    | http://localhost:15672           |
| Jenkins        | http://localhost:8080            |

---

## Observability

The application exposes metrics using Spring Boot Actuator and Micrometer.

### Metrics Endpoint

```
/actuator/prometheus
```

### Visualization

Grafana is used to visualize:

- JVM metrics (memory, threads, CPU)  
- HTTP metrics (requests per second, latency, status codes)  

---

## Example Metrics

- `jvm_memory_used_bytes`  
- `jvm_threads_live_threads`  
- `http_server_requests_seconds_count`  
- `http_server_requests_seconds_sum`  

---

## Dashboard

The dashboard provides insights into application behavior in real time.

### Monitored Data

- JVM memory usage (heap and non-heap)  
- CPU usage  
- Active threads  
- Request rate (RPS)  
- Average latency  
- HTTP status distribution  

---

## CI/CD

The project includes a Jenkins pipeline responsible for:

- Building the application  
- Generating the JAR  
- Building the Docker image  

---
