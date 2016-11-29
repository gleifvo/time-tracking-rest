package timetracking.dao.repositories;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import timetracking.dao.models.User;
import timetracking.dao.models.UserType;
import timetracking.utils.TestUtils;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:users_setup.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:users_cleanup.sql")
})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private UserType userType;

    @Before
    public void setUp() throws Exception {
        userType = new UserType("userType");
        TestUtils.setId(userType, 1L);
    }

    @Test
    public void findByName() {
        assertEquals(userRepository.findByFirstName("firstName").getId().longValue(), 1L);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void insertWithSameLogin() throws Exception {
        User user = new User("firstName", "lastName", "login", "password", userType);

        userRepository.save(user);
    }

    @Test
    public void shouldBeSaveUser() throws Exception {
        User user = new User("firstName", "lastName", "uniqueLogin", "password", userType);
        
        assertEquals(userRepository.save(user), user);
    }
}
