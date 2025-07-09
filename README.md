# 🏦 Check Writer for Felbel Trading Corporation

Built a comprehensive financial management REST API using Spring Boot to handle check transactions between payers and payees.

## 🛠️ Tech Stack:

- Spring Boot 3.5 (Web, Data JPA, Security, Validation)
- MySQL Database with JPA/Hibernate
- Docker Compose for containerization
- Lombok for boilerplate reduction

## 📚 Key Learnings:

- Layered Architecture: Implemented clean separation of concerns across controllers, services, and repositories
- RESTful API Design: Created paginated endpoints with search functionality
- Database Relationships: Designed entity mappings with proper foreign key constraints
- JPA/Hibernate: Created entities that maps to tables and vice versa.
- Error Handling: Built global exception handling with validation feedback
- Data Seeding: Automated realistic test data generation using Faker
- Security Configuration: Configured CORS and Spring Security
- DTO Pattern: Implemented proper data transfer objects with mappers
- Features include CRUD operations for payers/payees, paginated check listings with search, and robust validation with custom ID generation using NanoID.