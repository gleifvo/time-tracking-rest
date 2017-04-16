package timetracking.security.configurations;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JwtTokenConfiguration {

    @Value("${jwt.token.key}")
    private String key;

    @Value("${jwt.token.name}")
    private String name;

}