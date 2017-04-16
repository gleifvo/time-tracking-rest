package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.Task;

@PreAuthorize("isAuthenticated()")
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}