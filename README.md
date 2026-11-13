# Address Book Application

## Overview

The Address Book Application is a Spring Boot REST API project developed as part of the Bridgelabz Java training program.

The application manages contact information such as first name, last name, and phone number. It follows a layered architecture using Controller, Service, Model, and DTO components.

The initial implementation uses an in-memory `ArrayList` to perform CRUD (Create, Read, Update, Delete) operations on contacts.

## Technologies Used

- **Java:** 21
- **Spring Boot:** 4.1.2
- **Maven:** Build and dependency management
- **Spring Web MVC:** REST API development
- **JUnit:** Unit testing
- **Mockito:** Mocking dependencies during testing
- **MockMvc:** Controller/API testing
- **MySQL Connector:** Database connectivity dependency (database persistence is not implemented in the current in-memory CRUD use case)
- **Git and GitHub:** Version control

## Project Structure

```text
AddressBook/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── addressbook/
│   │   │           ├── controller/
│   │   │           │   └── AddressBookController.java
│   │   │           │
│   │   │           ├── dto/
│   │   │           │   └── AddressBookDTO.java
│   │   │           │
│   │   │           ├── model/
│   │   │           │   └── AddressBook.java
│   │   │           │
│   │   │           ├── service/
│   │   │           │   ├── AddressBookService.java
│   │   │           │   └── AddressBookServiceImpl.java
│   │   │           │
│   │   │           └── AddressBookApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── addressbook/
│                   ├── controller/
│                   │   └── AddressBookControllerTest.java
│                   │
│                   └── service/
│                       └── AddressBookServiceImplTest.java
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Implemented Use Cases

### Section 1 – Spring Boot Application Setup

#### UC1 – Spring Boot Project Setup

- Created a Spring Boot project using Spring Initializr.
- Configured Maven dependencies.
- Set up the Java package structure.
- Configured application properties.
- Verified successful application startup.

#### UC2 – REST Controller Implementation

- Created a REST Controller.
- Implemented HTTP endpoints.
- Used `@RestController` and request mapping annotations.
- Tested REST endpoints using MockMvc.

### Section 2 – Address Book Application Development

#### UC1 – Address Book DTO and Model

- Created `AddressBookDTO` to transfer contact information.
- Created `AddressBook` model to represent contact data.
- Implemented DTO-to-model mapping.
- Defined fields:
    - ID
    - First Name
    - Last Name
    - Phone Number

#### UC2 – Service Layer Implementation

- Created the `AddressBookService` interface.
- Created `AddressBookServiceImpl`.
- Implemented business logic separately from the controller.
- Used constructor-based dependency injection.
- Connected the controller to the service layer.

#### UC3 – In-Memory CRUD Operations Using ArrayList

Implemented contact management using Java's `ArrayList`.

Operations:

- **Create:** Add a new contact.
- **Read:** Retrieve all contacts or a contact by ID.
- **Update:** Modify existing contact details.
- **Delete:** Remove a contact using its ID.

Contact records are stored in memory and are reset when the application restarts.

## Application Architecture

```text
             Client
               |
               | HTTP Request
               v
       AddressBookController
               |
               | Method Call
               v
        AddressBookService
               |
               v
       AddressBookServiceImpl
               |
               | CRUD Operations
               v
          ArrayList
               |
               v
          Contact Data
```

### Component Responsibilities

| Component | Responsibility |
|---|---|
| Controller | Handles incoming HTTP requests and sends responses. |
| DTO | Transfers contact data between application layers. |
| Model | Represents the Address Book contact entity. |
| Service | Defines business operation contracts. |
| Service Implementation | Implements CRUD business logic and manages the ArrayList. |

## REST API Endpoints

Base URL:

```text
http://localhost:8080
```

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/addressbook/hello` | Welcome message |
| GET | `/addressbook` | Retrieve all contacts |
| GET | `/addressbook/{id}` | Retrieve a contact by ID |
| POST | `/addressbook/create` | Create a new contact |
| PUT | `/addressbook/update/{id}` | Update an existing contact |
| DELETE | `/addressbook/delete/{id}` | Delete a contact |

### Sample JSON Request

```json
{
  "firstName": "Hemang",
  "lastName": "Sharma",
  "phoneNumber": "9876543210"
}
```

### Sample API Responses

**Create Contact – POST**

```json
{
  "id": 1,
  "firstName": "Hemang",
  "lastName": "Sharma",
  "phoneNumber": "9876543210"
}
```

**Retrieve All Contacts – GET**

```json
[
  {
    "id": 1,
    "firstName": "Hemang",
    "lastName": "Sharma",
    "phoneNumber": "9876543210"
  }
]
```

**Delete Contact – DELETE**

```text
Contact deleted successfully with ID: 1
```

## How to Run the Project

### Prerequisites

Make sure the following are installed:

- Java Development Kit (JDK) 21
- Maven (optional when using the Maven Wrapper)
- Git
- IntelliJ IDEA or another Java IDE

### Step 1 – Clone the Repository

```bash
git clone https://github.com/Hemang71006/BL_AddressBookApp.git
```

### Step 2 – Navigate to the Project

```bash
cd BL_AddressBookApp
```

If your local project folder has a different name, navigate to that folder instead.

### Step 3 – Verify Java Installation

```bash
java -version
```

### Step 4 – Build the Project

On Windows PowerShell:

```powershell
.\mvnw.cmd clean install
```

### Step 5 – Run the Application

```powershell
.\mvnw.cmd spring-boot:run
```

The application starts at:

```text
http://localhost:8080
```

## Testing

The project contains unit tests and controller tests.

### Run All Tests

```powershell
.\mvnw.cmd clean test
```

### Testing Coverage

**Service Layer Tests**

- Retrieve all contacts.
- Retrieve contact by ID.
- Handle invalid contact IDs.
- Create contacts.
- Generate unique contact IDs.
- Update existing contacts.
- Handle updates for invalid IDs.
- Delete existing contacts.
- Handle deletion of invalid IDs.

**Controller Layer Tests**

- Verify welcome endpoint.
- Test GET all contacts.
- Test GET contact by ID.
- Test invalid contact ID response.
- Test POST contact creation.
- Test PUT contact update.
- Test invalid update response.
- Test DELETE contact.
- Test invalid deletion response.

## Git Branching Strategy

The project follows a feature-based Git workflow.

| Branch | Purpose |
|---|---|
| `main` | Stable project branch |
| `develop` | Integration branch |
| `feature/section1-uc1` | Section 1 – UC1 |
| `feature/section1-uc2` | Section 1 – UC2 |
| `feature/section2-uc1` | Section 2 – UC1 |
| `feature/section2-uc2` | Section 2 – UC2 |
| `feature/section2-uc3` | Section 2 – UC3 |

Each use case is developed in its respective feature branch, tested, and merged into the `develop` branch.

## Current Implementation Limitations

- Contact records are stored in an in-memory ArrayList.
- Data is not permanently stored.
- Restarting the application clears the contact list.
- MySQL connectivity is configured as a dependency, but database-backed CRUD persistence is not part of the current implementation.

## Future Scope

Possible future improvements include:

- Integrating MySQL for permanent data storage.
- Adding input validation.
- Implementing exception handling.
- Adding search and sorting capabilities.
- Adding support for multiple address books.

## Author

**Hemang**

Bridgelabz Java Training Program

## Repository

[GitHub – BL_AddressBookApp](https://github.com/Hemang71006/BL_AddressBookApp)
