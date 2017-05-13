package timetracking.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import timetracking.dao.models.Report;

@PreAuthorize("isAuthenticated()")
public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {
}
