package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.Report;

@PreAuthorize("isAuthenticated()")
public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {

    @Override
    @PreAuthorize("@userEvaluator.containsUser(#entity.task.project.users,#entity.user.id)")
    <S extends Report> S save(@Param("entity") S entity);

}
