package timetracking.security.service;

public interface JwtTokenService {

    String createToken(String login, Long id, String roleName);

}