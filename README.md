
 Customer Support Ticketing System

A secure, role-based customer support ticketing system built using Spring Boot and JWT, enabling users to create tickets and admins to assign or resolve them.

---

 Technologies Used

* **Java 17+**
* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Tokens)**
* **Hibernate (JPA)**
* **MySQL**
* **Lombok**
* **Postman** (for testing APIs)

---

 Project Architecture

```text
Controller ➡ Service ➡ Repository ➡ Database
```

---

 Security

* **JWT-based Authentication**
* **Role-based Authorization**

---

 Features

* **User:**

  * Register and login
  * Create a new support ticket
  * View their own tickets

* **Admin:**

  * Assign tickets to agents
  * Mark tickets as resolved

---

 API Endpoints

* `/register` – Register a new user
* `/login` – Login and receive a JWT token
* `/tickets` – Create or view own tickets (Requires JWT)
* `/admin/assign` – Assign a ticket to an agent (Admin only)
* `/admin/resolve` – Mark a ticket as resolved (Admin only)

> All endpoints (except login/register) require a **valid JWT token** in the header.

---

 Ticket Lifecycle

```
Create ➡ Assign ➡ Resolve
```

---

 Project Setup

1. Clone the repository

   ```bash
   git clone https://github.com/YourUsername/YourRepoName.git
   cd YourRepoName
   ```

2. Set up the database in MySQL:

   ```sql
   CREATE DATABASE support_ticketing;
   ```

3. Update `application.properties` with your DB credentials.

4. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

5. Test using Postman or any HTTP client.

---

 Notes

* JWT token is returned upon successful login and must be sent in headers for secured APIs.
* Use `@PreAuthorize("hasRole('ADMIN')")` to restrict admin-specific operations.

---

Conclusion
1 Mojor Work flow of project
<img width="909" height="804" alt="image" src="https://github.com/user-attachments/assets/30e897ad-0fab-47d1-a209-01fa39d51677" />

Project Flow (Layer by Layer): 
1. Frontend or Postman sends HTTP Requests to your Controllers. 
2. AuthController handles login (/login) and registration (/register) 
requests. After login, it generates a JWT token. 
3. Every other API call (like creating a ticket, assigning a ticket) must send 
the JWT token in the header for authorization. 
4. JwtFilter checks the token, extracts the username, and sets user 
authentication into SecurityContextHolder. 
5. TicketController handles normal user actions: 
o Create a ticket (POST /tickets) 
o View user’s own tickets (GET /tickets/mine) 
6. AdminController is protected by role checks 
(@PreAuthorize("hasRole('ADMIN')")) and allows only Admins to: 
o Assign tickets to agents (POST /admin/assign) 
o Mark tickets as resolved (POST /admin/resolve) 
7. Service Layer (TicketServiceImpl) contains the business logic — it talks to 
the Repository Layer. 
8. Repository Layer (TicketRepository, UserRepository) interacts with the 
database using JPA to fetch or save data. 
9. Model Layer (User, Ticket) defines your table structure (Entity classes). 
Final Flow Summary: 
Controller ➡ Service ➡ Repository ➡ Database 
Secure authentication with JWT 
Role-based authorization

Ticket lifecycle: Create ➔ Assign ➔ Resolve


 Contact

For any queries, feel free to reach out at Email: rakeshbathina206@gmail.com
