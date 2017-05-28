package timetracking.dao.repositories;


import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import timetracking.dao.models.User;
import timetracking.dao.repositories.generic.GenericRepositoryTest;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest extends GenericRepositoryTest<UserRepository, User> {

    @Test
    public void shouldFindByLogin() {
        User entity = this.createEntity();

        repository.save(entity);
        User persistent = repository.findByLogin(entity.getLogin());

        assertThat(persistent, samePropertyValuesAs(persistent));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotSaveLoginDuplicate() throws Exception {
        User entity = this.createEntity();

        repository.save(entity);
        repository.save(createEntity().setLogin(entity.getLogin()));
    }

}