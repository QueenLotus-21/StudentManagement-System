package com.act.playground.spring_crud.Token;

public class JwtTokenProvider {

}
// package com.act.playground.spring_crud.Token;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// @Component
// public class JwtTokenProvider {
//     @Value("${jwt.secret}")
//     private String jwtSecret;

//     @Value("${jwt.expiration}")
//     private int jwtExpirationInMs;

//     public String generateToken(Authentication authentication) {
//         UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

//         Map<String, Object> claims = new HashMap<>();
//         claims.put("username", userPrincipal.getUsername());
//         claims.put("authorities", userPrincipal.getAuthorities());

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(userPrincipal.getUsername())
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String getUsernameFromToken(String token) {
//         return getClaimFromToken(token, Claims::getSubject);
//     }

//     private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = getAllClaimsFromToken(token);
//         return claimsResolver.apply(claims);
//     }

//     private Claims getAllClaimsFromToken(String token) {
//         return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//     }
// }
