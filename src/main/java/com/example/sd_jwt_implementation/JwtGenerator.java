package com.example.sd_jwt_implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtGenerator {
    public static void main(String[] args) {
        // Define the secret key for signing (In production, use a secure key management system)
        String secret = "your-256-bit-secret"; // Replace with your secret

        // Create the signing algorithm
        Algorithm algorithm = Algorithm.HMAC256(secret);

        // Define claims
        String token = JWT.create()
                .withIssuer("issuer-example")
                .withSubject("user123")
                .withClaim("name", "Alice")
                .withClaim("email", "alice@example.com") // Disclosable claim
                .withClaim("salary", "100000")           // Hidden claim
                .withClaim("department", "Engineering")  // Hidden claim
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1 hour expiration
                .sign(algorithm);

        System.out.println("Generated JWT:");
        System.out.println(token);
    }
}