package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.Project;

@PreAuthorize("isAuthenticated()")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    @Override
    @PreAuthorize("principal.id == #entity.user.id or hasAuthority('ADMIN')")
    <S extends Project> S save(@P("entity") S entity);

    Boolean existsByName(@Param("name") String name);

}