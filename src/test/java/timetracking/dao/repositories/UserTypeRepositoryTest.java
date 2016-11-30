package timetracking.dao.repositories;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import timetracking.dao.models.UserType;
import timetracking.dao.repositories.generic.GenericRepositoryTest;


@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:user/type/setup.sql"),

        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:user/type/cleanup.sql")
})
public class UserTypeRepositoryTest extends GenericRepositoryTest<UserTypeRepository, UserType> {

    @Override
    protected UserType getEntity() {
        return new UserType("newUserType");
    }
}