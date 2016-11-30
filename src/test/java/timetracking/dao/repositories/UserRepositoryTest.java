package timetracking.dao.repositories;


import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import timetracking.dao.models.User;
import timetracking.dao.models.UserType;
import timetracking.dao.repositories.generic.GenericRepositoryTest;
import timetracking.utils.Constants;
import timetracking.utils.TestUtils;

import static org.junit.Assert.assertEquals;


@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_USER_TYPE_SETUP_SCRIPT),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_USER_SETUP_SCRIPT),

        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = Constants.PATH_TO_USER_CLEANUP_SCRIPT),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = Constants.PATH_TO_USER_TYPE__CLEANUP_SCRIPT)
})
public class UserRepositoryTest extends GenericRepositoryTest<UserRepository, User> {

    private UserType userType;

    @Before
    public void setUp() throws Exception {
        userType = new UserType("userType");
        TestUtils.setId(userType, 1L);
    }

    @Test
    public void findByName() {
        assertEquals(repository.findByFirstName("firstName").getId().longValue(), 1L);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void insertWithSameLogin() throws Exception {
        User user = new User("firstName", "lastName", "login", "password", userType);

        repository.save(user);
    }

    @Override
    protected User getEntity() {
        return new User("firstName", "lastName", "uniqueLogin", "password", userType);
    }
}