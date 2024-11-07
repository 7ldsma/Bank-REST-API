# Bank REST API
The objective: <br>
- To build a working REST API that emulates a simple banking system and run it on a local server. (Postman).<br>
- The system has 3 types of users: Admins, Holders, Third Party (like ATMs).<br>
- Holders can have 4 types of accounts: Checking, Student Checking, Saving and Credit Card. Each type of account with distictive properties.<br>
- Transactions (money transfers) can be executed between accounts.<br>
- The API allows you to generate a Database to create, store and update information about users and acounts<br>

# Technical Requirements
- Java / Sapring Boot backend.
- Storage in MySQL database.
- Authentication with Spring Security.
- JPA

# Class Diagram
https://github.com/7ldsma/Bank-REST-API-/blob/main/Diagrama%20de%20clases.pdf

# Methods / Http Requests
Admins Can:<br>
-> create Users: admins, holders, Third Partys<br>
-> create Accounts: Checking, Student Checking, Saving and Credit Card.<br>
-> access any account balance.<br>
-> modify any account balance.<br>
Holders can:<br>
-> Holders can access their accounts balances.<br>
-> Execute money transfers with their secret key.<br>
Routes are currently public.<br>

# Process
- Develop UML class diagram.<br>
- Set up Spring Boot Project structure on Intellij Idea.<br>
- Check the Database created in MySQL after running the code. <br>
- Develop the required methods.<br>
- Apply tests.<br>
- Implement Spring Security.<br>
