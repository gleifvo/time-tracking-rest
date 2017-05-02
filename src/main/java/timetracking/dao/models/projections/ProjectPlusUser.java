package timetracking.dao.models.projections;

import org.springframework.data.rest.core.config.Projection;
import timetracking.dao.models.Project;
import timetracking.dao.models.User;

@Projection(name = "user", types = {Project.class})
public interface ProjectPlusUser {

    String getName();

    User getUser();

}