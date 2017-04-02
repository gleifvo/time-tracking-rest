package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import timetracking.dao.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @PostAuthorize("returnObject.login == principal.username or hasRole('ADMIN')")
    User findByLogin(@Param("login") String login);

    @Override
    @PostAuthorize("returnObject.login == principal.username or hasRole('ADMIN')")
    User findOne(Long aLong);

}