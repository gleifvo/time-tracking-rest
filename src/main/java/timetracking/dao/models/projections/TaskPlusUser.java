package timetracking.dao.models.projections;

import org.springframework.data.rest.core.config.Projection;
import timetracking.dao.models.Task;
import timetracking.dao.models.User;

@Projection(name = "user", types = {Task.class})
public interface TaskPlusUser {

    String getName();

    String getDescription();

    User getUser();

}