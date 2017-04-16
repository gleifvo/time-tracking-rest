package timetracking.security.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;
import timetracking.security.configurations.JwtTokenConfiguration;
import timetracking.security.models.UserData;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final JwtTokenConfiguration tokenConfiguration;
    private final JwtParser parser;

    @Autowired
    public AuthenticationProviderImpl(JwtTokenConfiguration tokenConfiguration) {
        this.tokenConfiguration = tokenConfiguration;
        parser = Jwts.parser().setSigningKey(tokenConfiguration.getKey());
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String token = (String) authentication.getPrincipal();
        Claims claims = parser.parseClaimsJws(token).getBody();

        String login = claims.get("login", String.class);
        Long id = claims.get("id", Number.class).longValue();
        List<GrantedAuthority> roles = Stream.of(claims.get("roleName", String.class))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        Assert.notNull(login);
        Assert.notNull(id);

        return new PreAuthenticatedAuthenticationToken(
                new UserData()
                        .setId(id)
                        .setLogin(login),
                authentication.getCredentials(),
                roles
        );

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
    }

}