package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import timetracking.dao.models.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}