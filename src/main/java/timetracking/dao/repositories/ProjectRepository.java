package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import timetracking.dao.models.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}