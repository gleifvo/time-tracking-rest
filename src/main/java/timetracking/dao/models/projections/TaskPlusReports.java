package timetracking.dao.models.projections;

import org.springframework.data.rest.core.config.Projection;
import timetracking.dao.models.Task;

import java.util.List;

@Projection(name = "reports", types = {Task.class})
public interface TaskPlusReports {

    String getName();

    String getDescription();

    List<ReportPlusUser> getReports();

}