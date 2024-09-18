# SD-JWT Demo in Java
## Overview
Welcome to my SD-JWT Demo project! This Java application demonstrates a simplified implementation of
Selective Disclosure JSON Web Tokens (SD-JWT). The project showcases how to create, sign, verify, and 
selectively disclose JWT claims using Java. While it simplifies some aspects of SD-JWT, it provides a 
foundational understanding of the core concepts and functionalities involved.

# Table of Contents
- Features
- Prerequisites
- Installation
- Usage
  1. Generating a JWT
  2. Verifying a JWT
  3. Selective Disclosure
  4. Enhanced JWT with Encrypted Hidden Claims
- Security Considerations
- Further Improvements
- References

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
