package com.example.sd_jwt_implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Arrays;
import java.util.List;

public class SelectiveJwtVerifier {
    public static void main(String[] args) {
        // The JWT token generated previously
        String token = "YOUR_GENERATED_ENHANCED_JWT_HERE"; // Replace with your JWT

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

            // Define which claims to disclose
            List<String> claimsToDisclose = Arrays.asList("name", "email");

            // Iterate and display only selected claims
            System.out.println("Disclosed Claims:");
            for (String claim : claimsToDisclose) {
                String value = jwt.getClaim(claim).asString();
                System.out.println(capitalize(claim) + ": " + value);
            }

        } catch (Exception e) {
            System.out.println("Invalid Token");
        }
    }

    // Helper method to capitalize the first letter
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

