package timetracking.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import timetracking.security.configurations.JwtTokenConfiguration;

@Configuration
public class CORSConfig {

    private JwtTokenConfiguration jwtTokenConfiguration;

    @Autowired
    public CORSConfig(JwtTokenConfiguration jwtTokenConfiguration) {
        this.jwtTokenConfiguration = jwtTokenConfiguration;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .exposedHeaders(jwtTokenConfiguration.getName());
            }
        };
    }
}