# FirstJob – Job & Company Review Platform

## 📝 Project Description

**FirstJob** is a Java-based backend project developed using the **Spring Boot** framework. It provides a robust and scalable RESTful API for managing job listings, company profiles, and user-generated reviews.

The application models real-world relationships between companies, job opportunities, and feedback to help job seekers make informed decisions.

---

## 🚀 Features

- REST API to manage **companies**, **jobs**, and **reviews**
- Entity relationships:
  - One-to-Many: Company → Job
  - One-to-Many: Company → Review
- Full CRUD support for companies
- Clean layered architecture (Controller → Service → Repository)
- JPA & Hibernate for ORM and database interaction
- Uses annotations like `@RestController`, `@Entity`, `@OneToMany`, `@JsonIgnore`, etc.

---

## 📦 Technologies Used

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven** (or Gradle)
- **Relational Database** (e.g., MySQL or H2)

  
---

## 🛠 Tech Stack Used

- **IDE**:Intellij IDEA
- **Framework**: Spring Boot
- **Database**: H2 (In-Memory Database for testing
- **API Testing**: Postman
- **Build Tool**: Maven
- **Version Control**: Git & GitHub
  
---

## 📁 Project Structure
firstjob/ ├── src/ │ └── main/ │ └── java/ │ └── com/ │ └── embarkx/ │ └── firstjob/ │ ├── FirstjobApplication.java │ ├── company/ │ │ ├── Company.java │ │ └── CompanyController.java │ ├── job/ │ │ └── Job.java │ └── reviews/ │ └── Review.java

---

## 📦 API Endpoints(Company)
Method | Endpoint | Description
GET | /companies | Fetch all companies
GET | /companies/{id} | Get a single company by ID
POST | /companies | Create a new company
PUT | /companies/{id} | Update a company by ID
DELETE | /companies/{id} | Delete a company by ID

## 💼 Job Endpoints
Method	Endpoint	Description
GET	/jobs	Get all jobs
GET	/jobs/{id}	Get a specific job by ID
POST	/jobs	Create a new job (request body should contain job details)
DELETE	/jobs/{id}	Delete a specific job by ID

## 📮 Review Endpoints
Method	Endpoint	Description
GET	/companies/{companyId}/reviews	Get all reviews for a company
POST	/companies/{companyId}/reviews	Create a new review for a company
GET	/companies/{companyId}/reviews/{reviewId}	Get a specific review by ID
PUT	/companies/{companyId}/reviews/{reviewId}	Update a specific review by ID
DELETE	/companies/{companyId}/reviews/{reviewId}	Delete a specific review by ID
