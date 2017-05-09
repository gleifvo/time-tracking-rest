package timetracking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import timetracking.dao.models.User;
import timetracking.dao.repositories.UserRepository;
import timetracking.security.configurations.JwtTokenConfiguration;
import timetracking.security.models.LoginCredentials;
import timetracking.security.service.JwtTokenService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RepositoryRestController
@RequestMapping(path = "/api/login")
public class LoginController {

    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;
    private final JwtTokenConfiguration tokenConfiguration;

    @Autowired
    public LoginController(UserRepository userRepository, JwtTokenService jwtTokenService,
                           JwtTokenConfiguration tokenConfiguration) {
        this.userRepository = userRepository;
        this.jwtTokenService = jwtTokenService;
        this.tokenConfiguration = tokenConfiguration;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody LoginCredentials credentials, HttpServletResponse response, PersistentEntityResourceAssembler resourceAssembler) {
        User user = userRepository.findByLogin(credentials.getLogin());

        return Optional.ofNullable(user)
                .filter(usr -> usr.getPassword().equals(credentials.getPassword()))
                .map(usr -> {
                    String token = jwtTokenService.createToken(usr.getLogin(), usr.getId(), user.getUserType().name());
                    response.setHeader(tokenConfiguration.getName(), token);
                    return new ResponseEntity<>(resourceAssembler.toResource(user), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }
}