**Create a backend application with the following details:**

- Tech stack:
    - Programming Language: Either `Java` or `Kotlin`.
    - Web Framework: Spring Boot.

- Application Requirements:
    - Service should expose a REST API to accept money transfers to other accounts. Money transfers should persist with the new balance of accounts.
    - The service should expose a REST API for getting the account details. You can disregard currencies at this time.

- Points to consider:
    - Keep the design simple and to the point. The architecture should be scalable for adding new features.
    - Proper handling of concurrent transactions for the accounts (with unit tests).
    - The datastore should run in-memory for the tests.
    - Proper unit testing and decent coverage is a must.
    - Upload the code to a repository.
    - Disregard Currency or Rate Conversion.
    - Improvise where details are not provided.

- Plus Points:
    - Assignment implemented in `Kotlin`
    - Documentation of API (e.g. `Swagger`)
    - Dockerized app
