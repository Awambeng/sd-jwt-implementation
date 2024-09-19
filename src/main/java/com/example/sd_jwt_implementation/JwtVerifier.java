package com.example.sd_jwt_implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtVerifier {
    public static void main(String[] args) {
        // The JWT token generated previously
        String token = "YOUR_GENERATED_JWT_HERE"; // Replace with your JWT

        // Define the secret key used for signing
        String secret = "your-256-bit-secret"; // Same secret used for signing

        // Create the signing algorithm
        Algorithm algorithm = Algorithm.HMAC256(secret);

        // Create JWT verifier
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("issuer-example")
                .build();

        try {
            // Verify the token
            DecodedJWT jwt = verifier.verify(token);

            // Extract disclosable claims
            String name = jwt.getClaim("name").asString();
            String email = jwt.getClaim("email").asString();

            // Extract hidden claims (for demonstration; in SD-JWT, these would remain hidden)
            String salary = jwt.getClaim("salary").asString();
            String department = jwt.getClaim("department").asString();

            // Display only disclosable claims
            System.out.println("Disclosable Claims:");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

            // Uncomment below to display hidden claims (not typical in SD-JWT)
            /*
            System.out.println("\nHidden Claims:");
            System.out.println("Salary: " + salary);
            System.out.println("Department: " + department);
            */

        } catch (Exception e) {
            System.out.println("Invalid Token");
        }
    }
}
