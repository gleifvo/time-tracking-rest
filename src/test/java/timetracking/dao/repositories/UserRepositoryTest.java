package timetracking.dao.repositories;


import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.Randomizer;
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

        fabric = createFabric();
    }

    @Test
    public void shouldFindByLogin() {
        assertEquals(repository.findByLogin("login").getId(), Long.valueOf(1L));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotSaveLoginDuplicate() throws Exception {
        repository.save(new User("firstName", "lastName", "login", "password", userType));
    }

    @Override
    protected User getEntity() {
        return fabric.nextObject(User.class);
    }

    @Override
    protected EnhancedRandom createFabric() {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .randomize(FieldDefinitionBuilder.field().named("userType").ofType(UserType.class).inClass(User.class).get(), (Randomizer<UserType>) () -> userType)
                .maxStringLength(20)
                .build();
    }
}