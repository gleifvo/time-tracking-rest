package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.Project;

@PreAuthorize("isAuthenticated()")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    @Override
    @PreAuthorize("principal.id == #entity.user.id")
    Project save(@P("entity") Project entity);

}