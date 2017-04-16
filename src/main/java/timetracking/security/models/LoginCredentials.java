package timetracking.security.models;

import lombok.Data;

@Data
public class LoginCredentials {

    private String login;

    private String password;

}