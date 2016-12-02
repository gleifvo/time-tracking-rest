package timetracking.dao.repositories;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import timetracking.dao.models.User;
import timetracking.dao.repositories.generic.GenericRepositoryTest;
import timetracking.utils.Constants;
import timetracking.utils.fabrics.EntityFabric;

import static org.junit.Assert.assertEquals;


@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_USER_TYPE_SETUP_SCRIPT),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = Constants.PATH_TO_USER_SETUP_SCRIPT),
})
public class UserRepositoryTest extends GenericRepositoryTest<UserRepository, User> {

    @Autowired
    @Qualifier("userEntityFabric")
    protected EntityFabric fabric;

    @Test
    public void shouldFindByLogin() {
        assertEquals(repository.findByLogin("login").getId(), Long.valueOf(1L));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotSaveLoginDuplicate() throws Exception {
        repository.save(new User("firstName", "lastName", "login", "password", this.getEntity().getUserType()));
    }

    @Override
    protected User getEntity() {
        return fabric.generateEntity(User.class);
    }
}