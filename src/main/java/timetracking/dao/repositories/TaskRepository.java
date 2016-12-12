package timetracking.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import timetracking.dao.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}