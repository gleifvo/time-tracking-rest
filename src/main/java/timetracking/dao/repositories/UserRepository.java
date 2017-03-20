package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import timetracking.dao.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByLogin(@Param("login") String login);

}