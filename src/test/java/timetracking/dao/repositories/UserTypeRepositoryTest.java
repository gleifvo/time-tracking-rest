package timetracking.dao.repositories;

import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import timetracking.dao.models.UserType;
import timetracking.dao.repositories.generic.GenericRepositoryTest;


@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:user/type/setup.sql"),
})
public class UserTypeRepositoryTest extends GenericRepositoryTest<UserTypeRepository, UserType> {

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotSaveTypeDuplicate() throws Exception {
        repository.save(new UserType("userType"));
    }

    @Override
    protected UserType getEntity() {
        return fabric.generateEntity(UserType.class);
    }
}