package timetracking.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timetracking.security.configurations.JwtTokenConfiguration;
import timetracking.security.service.JwtTokenService;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private final JwtTokenConfiguration tokenConfiguration;

    @Autowired
    public JwtTokenServiceImpl(JwtTokenConfiguration tokenConfiguration) {
        this.tokenConfiguration = tokenConfiguration;
    }

    @Override
    public String createToken(String login, Long id, String roleName) {

        Claims claims = Jwts.claims();
        claims.put("login", login);
        claims.put("id", id);
        claims.put("roleName", roleName);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, tokenConfiguration.getKey())
                .compact();
    }

}