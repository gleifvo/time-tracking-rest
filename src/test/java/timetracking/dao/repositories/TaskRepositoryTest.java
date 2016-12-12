package timetracking.dao.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import timetracking.dao.models.Task;
import timetracking.dao.repositories.generic.GenericRepositoryTest;
import timetracking.utils.Constants;
import timetracking.utils.fabrics.EntityFabric;


@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_USER_TYPE_SETUP_SCRIPT),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_USER_SETUP_SCRIPT),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_PROJECT_SETUP_SCRIPT)
})
public class TaskRepositoryTest extends GenericRepositoryTest<TaskRepository, Task> {

    @Autowired
    @Qualifier("taskEntityFabric")
    protected EntityFabric fabric;

    @Override
    protected Task getEntity() {
        return fabric.generateEntity(Task.class);
    }
}