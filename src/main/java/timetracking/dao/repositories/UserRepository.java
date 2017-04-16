package timetracking.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.User;


@PreAuthorize("isAuthenticated()")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @RestResource(exported = false)
    @PreAuthorize("permitAll")
    User findByLogin(@Param("login") String login);

    @Override
    @PostAuthorize("returnObject.login == principal.login or hasRole('ADMIN')")
    User findOne(Long id);

    @Override
    @PostAuthorize("hasRole('ADMIN')")
    Iterable<User> findAll(Sort sort);

    @Override
    @PostAuthorize("hasRole('ADMIN')")
    Page<User> findAll(Pageable pageable);

    @Override
    @PostAuthorize("hasRole('ADMIN')")
    Iterable<User> findAll();

    @Override
    @PostAuthorize("hasRole('ADMIN')")
    Iterable<User> findAll(Iterable<Long> longs);

}