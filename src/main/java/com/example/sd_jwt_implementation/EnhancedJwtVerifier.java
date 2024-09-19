package com.example.sd_jwt_implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.keys.AesKey;

import java.nio.charset.StandardCharsets;

public class EnhancedJwtVerifier {
    public static void main(String[] args) throws Exception {
        // The JWT token generated previously
        String token = "YOUR_GENERATED_ENHANCED_JWT_HERE"; // Replace with your generated JWT

        // Define the secret key used for signing
        String signingSecret = "Replace-with-your-secret"; // Must match the signing key used in EnhancedJwtGenerator
        Algorithm signingAlgorithm = Algorithm.HMAC256(signingSecret);

        // Define the secret key used for encryption (exactly 32 characters)
        AesKey encryptionKey = new AesKey(signingSecret.getBytes());

        // Create JWT verifier
        JWTVerifier verifier = JWT.require(signingAlgorithm)
                .withIssuer("issuer-example")
                .build();

        try {
            // Verify the token
            DecodedJWT jwt = verifier.verify(token);

            // Extract and display disclosable claims
            String name = jwt.getClaim("name").asString();
            String email = jwt.getClaim("email").asString();

            System.out.println("Disclosable Claims:");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

            // Extract encrypted hidden claims
            String encryptedHiddenClaims = jwt.getClaim("hidden").asString();

            // Decrypt hidden claims
            JsonWebEncryption jwe = new JsonWebEncryption();
            jwe.setCompactSerialization(encryptedHiddenClaims);
            jwe.setKey(encryptionKey);

            String hiddenClaimsJson = jwe.getPayload();
            System.out.println("\nHidden Claims (Decrypted):");
            System.out.println(hiddenClaimsJson);

        } catch (Exception e) {
            System.out.println("Invalid Token or Decryption Failed");
            e.printStackTrace();
        }
    }
}
