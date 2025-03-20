# Drone Delivery System

## **📖 Overview**
This is a **Spring Boot REST API** for managing drone-based medication deliveries. The system allows users to:
- **Register drones**
- **Load drones with medications**
- **Check loaded medications**
- **Check available drones for loading**
- **Monitor drone battery levels**
- **Automatically reduce battery percentage on deliveries**
- 
## **Technologies Used**
- Java 17
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Spring Scheduler
- JUnit and Mockito

## **Build Run Test Instructions**
### **1. Clone the repository**
```sh
git clone https://github.com/your-repo/drone-delivery.git
cd drone-delivery
```

### **2. Clone the repository**
```sh
mvn clean install
mvn spring-boot:run
```

### **3. Access H2 Database**
#### URL: http://localhost:8080/h2-console
#### jdbc url: jdbc:h2:mem:droneDB
#### Username: sa
#### password:

### **4. Test**
```sh
mvn test
```

### 4.1. Register a Drone
```http request
POST
/api/drones/register
```
```json
{
  "serialNumber": "DRONE123",
  "model": "LIGHTWEIGHT",
  "weightLimit": 500,
  "batteryCapacity": 80,
  "state": "IDLE"
}
```
```shell
curl -X POST "http://localhost:8080/api/drones/register" -H "Content-Type: application/json" -d '{
  "serialNumber": "DRONE123",
  "model": "LIGHTWEIGHT",
  "weightLimit": 500,
  "batteryCapacity": 80,
  "state": "IDLE"
}'
```
### 4.2. Load a Drone with Medication
```http request
POST
/api/drones/{droneId}/load
```
```json
[1, 2, 3]
```
```shell
curl -X POST "http://localhost:8080/api/drones/1/load" -H "Content-Type: application/json" -d '[1, 2, 3]'
```

### 4.3. Get Loaded Medications for a Drone
```http request
GET
/api/drones/{droneId}/medications
```
```shell
curl -X GET "http://localhost:8080/api/drones/1/medications"
```
### 4.4. Check Available Drones
```http request
GET
/api/drones/available
```
```shell
curl -X GET "http://localhost:8080/api/drones/available"
```
### 4.5. Check Drone Battery Status
```http request
GET
/api/drones/{droneId}/battery
```
```shell
curl -X GET "http://localhost:8080/api/drones/1/battery"
```


