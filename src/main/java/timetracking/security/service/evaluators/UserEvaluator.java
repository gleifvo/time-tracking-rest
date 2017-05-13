package timetracking.security.service.evaluators;

import org.springframework.stereotype.Component;
import timetracking.dao.models.User;
import timetracking.security.models.UserData;

import java.util.List;

@Component(value = "userEvaluator")
public class UserEvaluator {

    public boolean containsUser(List<User> users, UserData userData) {
        return users.stream()
                .anyMatch(user -> user.getId().equals(userData.getId()));
    }

}