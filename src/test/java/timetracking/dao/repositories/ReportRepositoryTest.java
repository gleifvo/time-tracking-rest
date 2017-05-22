package timetracking.dao.repositories;

import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import timetracking.dao.models.Report;
import timetracking.dao.repositories.generic.GenericRepositoryTest;

public class ReportRepositoryTest extends GenericRepositoryTest<ReportRepository, Report> {

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldSaveOnlyOneReportFromUserToTask() throws Exception {
        Report report = this.createEntity();
        repository.save(report);
        entityManager.detach(report);

        report.setId(null);
        repository.save(report);
    }

}