# PolovniAutomobili Car Parts REST API

Allows users to retrieve car parts by make and model and order specific parts.
The API is built using Kotlin and Sprng Boot and is accessible by any language that has HTTP support.

---

## Endpoints

### **1. GET /partsForModel**
Retrieve all available parts for a specific car make and model.

#### **Request**
- **URL:** `/partsForModel`
- **Method:** `GET`
- **Query Parameters:**
  - `make` (string, required): Car make (e.g., "BMW").
  - `model` (string, required): Car model (e.g., "X5").

#### **Response**
- **Status Codes:**
  - `200 OK`: Returns a JSON array of parts.
  - `404 Not Found`: No parts found for the specified make and model.

---

### **2. PUT /order**
Order a specific car part.

#### **Request**
- **URL:** `/order`
- **Method:** `PUT`
- **Content-Type:** `application/json`
- **Request Body:**
  ```json
  {
    "make": "BMW",
    "model": "X5",
    "name": "Akumulator"
  }

#### **Response**
- **Status Codes:**
  - `200 OK`: Part ordered successfully.
  - `400 Bad Request`: The part is not available.
  - `404 Not Found`: No parts found for the specified make and model.
