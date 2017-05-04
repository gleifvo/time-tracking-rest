package timetracking.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import timetracking.security.configurations.JwtTokenConfiguration;

@Configuration
public class CORSConfig extends RepositoryRestConfigurerAdapter {

    private JwtTokenConfiguration jwtTokenConfiguration;

    @Autowired
    public CORSConfig(JwtTokenConfiguration jwtTokenConfiguration) {
        this.jwtTokenConfiguration = jwtTokenConfiguration;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry()
                .addMapping("/**")
                .exposedHeaders(jwtTokenConfiguration.getName());
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