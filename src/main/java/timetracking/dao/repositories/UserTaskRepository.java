package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.UserTask;

@PreAuthorize("isAuthenticated()")
public interface UserTaskRepository extends PagingAndSortingRepository<UserTask, Long> {
}
