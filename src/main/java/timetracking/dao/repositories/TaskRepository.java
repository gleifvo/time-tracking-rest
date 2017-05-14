package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.Task;
import timetracking.dao.models.projections.TaskPlusUser;

@PreAuthorize("isAuthenticated()")
@RepositoryRestResource(excerptProjection = TaskPlusUser.class)
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    Boolean existsByName(@Param("name") String name);

    @Override
    @PreAuthorize("@userEvaluator.containsUser(#task.project.users,principal.id)")
    <S extends Task> S save(@P("task") S task);

    @Override
    @PreAuthorize("@userEvaluator.containsUser(#task.project.users,principal.id)")
    void delete(@P("task") Task task);

}