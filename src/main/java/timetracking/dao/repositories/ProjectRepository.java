package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.Project;

@PreAuthorize("isAuthenticated()")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}