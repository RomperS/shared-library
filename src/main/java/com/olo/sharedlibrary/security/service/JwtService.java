package com.olo.sharedlibrary.security.service;

import com.olo.sharedlibrary.security.authorities.Role;
import com.olo.sharedlibrary.security.authorities.Title;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtService {

    @Value("${jwt.secret.key}")
    private String secretKey;

    public Role getRole(String token) {
        String roleName = extractClaim(token, claims -> claims.get("role", String.class));
        return Role.valueOf(roleName);
    }

    public List<Title> getTitles(String token) {
        List<String> rawTitles = extractClaim(token, claims -> claims.get("titles", List.class));
        return rawTitles.stream()
                .map(Title::valueOf)
                .toList();
    }

    public String getUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Long getServiceId(String token) {
        return extractClaim(token, claims -> claims.get("serviceId", Long.class));
    }

    public Long getAuthId(String token) {
        return extractClaim(token, claims -> claims.get("authId", Long.class));
    }

    public String getTokenType(String token) {
        return extractClaim(token, claims -> claims.get("type", String.class));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
