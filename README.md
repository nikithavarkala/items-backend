## Item Management REST API

A simple Spring Boot REST API for managing items (similar to ecommerce products).
Built to demonstrate clean REST design, validation, and exception handling.

## Tech Stack
- **Language:** Java 21
- **Framework:** Spring Boot 4.x
- **Utilities:** Spring Web, Lombok, Jakarta Validation
- **Build Tool:** Maven

## Features
- Create a new item
- Retrieve item by ID
- Retrieve all items
- Request validation with meaningful error messages
- Global exception handling using `@RestControllerAdvice`
- In-memory data storage using `ArrayList`

## 📌 API Endpoints

### ➕ Create Item
**POST** 
`/api/items`

- **Request Body(JSON):**
  ```json
  {
    "name": "Laptop",
    "description": "Gaming Laptop",
    "price": 1200.0,
    "quantity": 10,
    "category": "Electronics"
  }

- Response:
   - `201 Created` – Item successfully created
     ```json
     {
       "message": "Item added successfully",
       "data": {
           "name": "Laptop",
           "description": "Gaming Laptop",
           "price": 1200.0,
           "quantity": 10,
           "category": "Electronics"
           }
      } 
   - `400 Bad Request` – Validation errors
   ```json
   {
    "timestamp": "2026-02-05T09:11:09.193145759",
    "status": 400,
    "errors": {
         "name": "Name is required",
         "price": "Price must be positive"
      }
   }

### 🔍 Get Item by ID
**GET** 
`/api/items/{id}`

  Response:
  - `200 OK` – Item found
  - `404 Not Found` – Item does not exist with Id `${id}`
    ```json
    {
      "status": 404,
      "error": "Item not found with ID 2"
    }

### 📄 Get All Items
  **GET**
  `/api/items`
  
  Response:
   - 200 OK – List of all items
     
## Validation Rules
- `name` – Required, must not be empty
- `price` – Must be greater than 0
- `quantity` – Must be a non-negative integer
- `category` – Required

## How to Run
1. Clone the repository
2. Run the Spring Boot application `mvn spring-boot:run`
3. Access APIs using Postman or browser

## Notes
- Data is stored in-memory and will reset on application restart
- No database is used(as per task requirement)
