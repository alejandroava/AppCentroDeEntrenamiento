package com.centro_de_entremiento.App_centro_de_entrenamiento.utils.helpers;

import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTService {

    private final String SECRET_KEY = " bWljb250cmFzZcOxYXNlZ3VyYWVzbXV5c2VndXJhcGFyYXF1ZW5hZGllbGF2ZWE=";
    // micontraseñaseguraesmuyseguraparaquenadielavea


    //Metodo
    public SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Map<String,Object> claims, User user){
        return Jwts.builder()
                .claims(claims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ 36000))
                .signWith(getKey())
                .compact();
    }

    public String getToken(User user){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("role",user.getRole());
        return generateToken(claims,user);
    }





}
