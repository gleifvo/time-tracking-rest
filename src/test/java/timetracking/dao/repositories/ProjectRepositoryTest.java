package timetracking.dao.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import timetracking.dao.models.Project;
import timetracking.dao.repositories.generic.GenericRepositoryTest;
import timetracking.utils.Constants;
import timetracking.utils.fabrics.EntityFabric;


@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_USER_TYPE_SETUP_SCRIPT),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_USER_SETUP_SCRIPT),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_PROJECT_SETUP_SCRIPT)
})
public class ProjectRepositoryTest extends GenericRepositoryTest<ProjectRepository, Project> {

    @Autowired
    @Qualifier("projectEntityFabric")
    protected EntityFabric fabric;

    @Override
    protected Project getEntity() {
        return fabric.generateEntity(Project.class);
    }
}