package timetracking.dao.repositories.generic;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import timetracking.dao.models.absctract.AbstractEntity;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class GenericRepositoryTest<REPOSITORY extends CrudRepository<ENTITY, Long>, ENTITY extends AbstractEntity> {

    @Autowired
    protected REPOSITORY repository;

    @Test
    public void shouldBeSave() throws Exception {
        ENTITY entity = getEntity();
        assertEquals(entity, repository.save(entity));
    }

    protected abstract ENTITY getEntity();
}