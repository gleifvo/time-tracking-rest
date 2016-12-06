package timetracking.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import timetracking.dao.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}