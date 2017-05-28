package timetracking.dao.models.projections;

import org.springframework.data.rest.core.config.Projection;
import timetracking.dao.models.Project;
import timetracking.dao.models.Task;

@Projection(name = "project", types = {Task.class})
public interface TaskPlusProject {

    String getName();

    String getDescription();

    Project getProject();

}