# SD-JWT Demo in Java
## Overview
Welcome to my SD-JWT Demo project! This Java application demonstrates a simplified implementation of
Selective Disclosure JSON Web Tokens (SD-JWT). The project showcases how to create, sign, verify, and 
selectively disclose JWT claims using Java. While it simplifies some aspects of SD-JWT, it provides a 
foundational understanding of the core concepts and functionalities involved.

# Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
  1. Generating a JWT
  2. Verifying a JWT
  3. Selective Disclosure
  4. Enhanced JWT with Encrypted Hidden Claims
- [Further Improvements](#further_improvements)
- [References](#references)

## Features
- **JWT Generation**: Create JSON Web Tokens with both disclosable and hidden claims.

- **JWT Signing**: Sign tokens using HMAC SHA-256 to ensure integrity and authenticity.

- **JWT Verification**: Verify the authenticity of tokens using the corresponding public key.

- **Selective Disclosure**: Display only selected claims from the JWT.

- **Enhanced Security (Optional)**: Encrypt hidden claims using JSON Web Encryption (JWE) for added security.

## Prerequisites
Before you begin, ensure you have the following installed on your system:

- Java Development Kit (JDK): Version 8 or higher.
- Maven: For dependency management and building the project.
- IDE (Optional): Integrated Development Environment like IntelliJ IDEA or VS Code for easier development and testing.
- Libraries:

  Java JWT (Auth0): For handling JWT operations.

  JSON Processing Library (Optional): For handling JSON data if needed.

## Installation
1. Clone the Repository and move to the project directory:
```bash
git clone git@github.com:Awambeng/sd-jwt-implementation.git && cd sd-jwt-implementation
```
2. Build the Project:
```bash
 mvn clean install
```

## Usage
1. **Generating a JWT**:
   The JwtGenerator class creates a JWT containing both disclosable (name, email) and hidden (salary, department) claims.

Steps:
- Open JwtGenerator.java.
- Replace the secret variable with your own secret key.
- Run the JwtGenerator class.

2. **Verifying a JWT**:
   The JwtVerifier class verifies the JWT's signature and extracts the claims.

Steps:
- Open JwtVerifier.java.
- Replace "YOUR_GENERATED_JWT_HERE" with the JWT generated from JwtGenerator.
- Ensure the secret variable matches the one used in JwtGenerator.
- Run the JwtVerifier class.

3. **Selective Disclosure**:
   The SelectiveJwtVerifier class demonstrates how to display only selected claims from the JWT.

Steps:
- Open SelectiveJwtVerifier.java.
- Replace "YOUR_GENERATED_JWT_HERE" with the JWT generated from JwtGenerator.
- Ensure the secret variable matches the one used in JwtGenerator.
- Run the SelectiveJwtVerifier class.

4. **Enhanced JWT with Encrypted Hidden Claims**:
   For added security, hidden claims can be encrypted using JSON Web Encryption (JWE). This ensures that hidden claims remain confidential even if the JWT is intercepted.

  a. **Generating an Enhanced JWT**:
      The EnhancedJwtGenerator class creates a JWT with encrypted hidden claims.

    Steps:
      - Open EnhancedJwtGenerator.java.
      - Replace the secret variable with your own secret key.
      - Run the EnhancedJwtGenerator class.

  b. **Verifying and Decrypting the Enhanced JWT**:
      The EnhancedJwtVerifier class verifies the JWT's signature and decrypts the hidden claims.

    Steps:
      - Open EnhancedJwtVerifier.java.
      - Replace "YOUR_GENERATED_ENHANCED_JWT_HERE" with the enhanced JWT generated from EnhancedJwtGenerator.
      - Ensure the secret variable matches the one used in EnhancedJwtGenerator.
      - Run the EnhancedJwtVerifier class.

## Further Improvements (Work)
1. **Implement True SD-JWT Features**:
    - Integrate zero-knowledge proofs for authenticating claims without revealing them.
    - Use more sophisticated encryption methods for hidden claims.
2. **Use Asymmetric Cryptography**:
    - Replace HMAC with RSA or ECDSA for signing JWTs, enhancing security by separating signing and verification keys.

3. **Add Claim Encryption Keys**:
    - Implement separate encryption keys for each hidden claim, allowing more granular control over claim disclosure.

4. **Build a User Interface**:
    - Create a frontend application to interact with the JWT generation and verification processes.

5. **Integrate with Databases**:
    - Store and manage JWTs in a database, enabling persistent storage and retrieval.

6. **Enhance Logging and Monitoring**:
    - Implement logging for token generation, verification, and disclosure actions for auditing and monitoring purposes.

## References
1. SD-JWT GitHub Repository: https://github.com/sd-jwt/sd-jwt
2. Java JWT (Auth0): https://github.com/auth0/java-jwt
3. JOSE4J Library: https://bitbucket.org/b_c/jose4j/wiki/Home
4. Zero-Knowledge Proofs: https://en.wikipedia.org/wiki/Zero-knowledge_proof
5. JSON Web Tokens (JWT) Specification: https://datatracker.ietf.org/doc/html/rfc7519
6. JSON Web Encryption (JWE) Specification: https://datatracker.ietf.org/doc/html/rfc7516
7. JSON Web Signature (JWS) Specification: https://datatracker.ietf.org/doc/html/rfc7515
