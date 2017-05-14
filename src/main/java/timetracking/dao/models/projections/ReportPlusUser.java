package timetracking.dao.models.projections;

import org.springframework.data.rest.core.config.Projection;
import timetracking.dao.models.Report;
import timetracking.dao.models.User;

@Projection(name = "user", types = {Report.class})
public interface ReportPlusUser {

    Long getTime();

    User getUser();

}