package timetracking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import timetracking.security.configurations.JwtTokenConfiguration;

import javax.servlet.Filter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationProvider authenticationProvider;
    private final JwtTokenConfiguration tokenConfiguration;

    @Autowired
    public WebSecurityConfig(AuthenticationProvider authenticationProvider, JwtTokenConfiguration tokenConfiguration) {
        this.authenticationProvider = authenticationProvider;
        this.tokenConfiguration = tokenConfiguration;
    }

    public WebSecurityConfig(boolean disableDefaults, AuthenticationProvider authenticationProvider, JwtTokenConfiguration tokenConfiguration) {
        super(disableDefaults);
        this.authenticationProvider = authenticationProvider;
        this.tokenConfiguration = tokenConfiguration;
    }

    @Bean
    protected Filter headerAuthFilter() throws Exception {
        final RequestHeaderAuthenticationFilter filter = new RequestHeaderAuthenticationFilter();
        filter.setExceptionIfHeaderMissing(false);
        filter.setPrincipalRequestHeader(tokenConfiguration.getName());
        filter.setAuthenticationManager(this.authenticationManager());
        return filter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(headerAuthFilter(), RequestHeaderAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}