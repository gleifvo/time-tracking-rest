package timetracking.dao.models.projections;

import org.springframework.data.rest.core.config.Projection;
import timetracking.dao.models.Report;

import java.util.Date;

@Projection(name = "project", types = {Report.class})
public interface ReportPlusTaskProject {

    Long getTime();

    Date getDate();

    String getDescription();

    TaskPlusProject getTask();

}