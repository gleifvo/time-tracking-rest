package timetracking.security.service.evaluators;

import org.springframework.stereotype.Component;
import timetracking.dao.models.User;

import java.util.List;

@Component(value = "userEvaluator")
public class UserEvaluator {

    public boolean containsUser(List<User> users, Long id) {
        return users.stream()
                .anyMatch(user -> user.getId().equals(id));
    }

}