package timetracking.dao.models.projections;

import org.springframework.data.rest.core.config.Projection;
import timetracking.dao.models.Report;
import timetracking.dao.models.User;

import java.util.Date;

@Projection(name = "user", types = {Report.class})
public interface ReportPlusUser {

    Long getTime();

    User getUser();

    Date getDate();

    String getDescription();

}