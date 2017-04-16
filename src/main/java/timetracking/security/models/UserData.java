package timetracking.security.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserData {

    private String login;

    private Long id;

    private String roleName;

}