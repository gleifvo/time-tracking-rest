package timetracking.dao.repositories;


import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import timetracking.dao.models.User;
import timetracking.dao.repositories.generic.GenericRepositoryTest;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest extends GenericRepositoryTest<UserRepository, User> {

    @Test
    public void shouldFindByLogin() {
        User entity = this.getEntity();
        repository.save(entity);
        assertEquals(repository.findByLogin(entity.getLogin()), entity);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotSaveLoginDuplicate() throws Exception {
        User entity = this.getEntity();

        repository.save(entity);
        repository.save(getEntity().setLogin(entity.getLogin()));
    }

}