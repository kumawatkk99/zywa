Overview
This project is aimed at creating a backend service for Zywa, providing an internal API to retrieve the status of a user's card. The service integrates data from partner companies and offers a convenient way for team members to query and track card statuses.

Features
Internal API:

Endpoint: /get_card_status
Accepts user's phone number or card ID
Returns the card's status
Data Sources:

Utilizes data from partner companies provided in separate CSV files:
Pickup.csv
Delivery_exceptions.csv
Delivered.csv
Returned.csv
Database:

Implemented database (MongoDB) to store and manage card status information.

Docker support: Includes a Dockerfile for easy deployment.
Getting Started
Clone the Repository:

bash
Copy code
git clone https://github.com/kumawatkk99/zywa.git
Navigate to Project Folder:

bash
Copy code
cd zywa
Build and Run the Project:

bash
Copy code
./mvnw clean install
java -jar target/zywa-server.jar
API Endpoint:

Endpoint: http://localhost:8080/get_card_status
Method: POST
Payload: JSON or Form Data with user's phone number or card ID
Docker (Bonus):

bash
Copy code
docker build -t zywa-backend .
docker run -p 8080:8080 zywa-backend
API Usage
Request:

Endpoint: /get_card_status
Method: POST
Payload:
JSON: { "phoneNumber": "123456789" }
Form Data: phoneNumber=123456789
Response:

JSON format: { "cardId": "ZYW123", "status": "Delivered" }


Contributors
[Kushal Kumawat]
