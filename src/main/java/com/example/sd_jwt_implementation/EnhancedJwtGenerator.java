package com.example.sd_jwt_implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.JoseException;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;


import java.util.Date;

public class EnhancedJwtGenerator {
    public static void main(String[] args) throws JoseException {
        // Define the secret key for signing (In production, use a secure key management system)
        String secret = "Replace-with-your-secret"; // Replace with your secret
        Algorithm algorithm = Algorithm.HMAC256(secret); // secret for signing token

        AesKey aesKey = new AesKey(secret.getBytes()); // AES encryption key

        // Define hidden claims
        String hiddenClaimsJson = "{ \"salary\": \"100000\", \"department\": \"Engineering\" }";

        // Encrypt hidden claims using JWE
        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setPayload(hiddenClaimsJson);
        jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A256KW);
        jwe.setEncryptionMethodHeaderParameter("A128CBC-HS256");
        jwe.setKey(aesKey); // For simplicity; use a separate key in production

        String encryptedHiddenClaims = jwe.getCompactSerialization();

        // Create JWT with disclosable claims and include encrypted hidden claims
        String token = JWT.create()
                .withIssuer("issuer-example")
                .withSubject("user123")
                .withClaim("name", "Alice")
                .withClaim("email", "alice@example.com") // Disclosable claim
                .withClaim("hidden", encryptedHiddenClaims) // Encrypted hidden claims
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1 hour expiration
                .sign(algorithm);

        System.out.println("Generated Enhanced JWT with Encrypted Hidden Claims:");
        System.out.println(token);
    }
}
