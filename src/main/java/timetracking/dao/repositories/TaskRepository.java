package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.Task;
import timetracking.dao.models.projections.TaskPlusUser;

@PreAuthorize("isAuthenticated()")
@RepositoryRestResource(excerptProjection = TaskPlusUser.class)
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}