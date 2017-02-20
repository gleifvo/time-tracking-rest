package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import timetracking.dao.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByLogin(String login);

}