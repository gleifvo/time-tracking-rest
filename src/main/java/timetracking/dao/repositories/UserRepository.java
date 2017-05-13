package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.User;


@PreAuthorize("hasAuthority('ADMIN')")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @RestResource(exported = false)
    @PreAuthorize("permitAll")
    User findByLogin(@Param("login") String login);

    @Override
    @PreAuthorize("isAuthenticated()")
    @PostAuthorize("returnObject.login == principal.login or hasAuthority('ADMIN')")
    User findOne(Long id);

    Boolean existsByLogin(@Param("login") String login);

}