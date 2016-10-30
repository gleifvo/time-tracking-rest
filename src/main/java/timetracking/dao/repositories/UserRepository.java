package timetracking.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import timetracking.dao.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByFirstName(String firstName);
}