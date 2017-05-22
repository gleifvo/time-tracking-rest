package timetracking.dao.repositories.generic;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import timetracking.dao.models.AbstractEntity;
import timetracking.utils.creators.EntityCreator;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages = "timetracking.utils")
@AutoConfigureTestDatabase(replace = NONE)
public abstract class GenericRepositoryTest<REPOSITORY extends CrudRepository<ENTITY, Long>, ENTITY extends AbstractEntity> {

    @Autowired
    protected REPOSITORY repository;

    @Autowired
    protected EntityManager entityManager;

    @Autowired
    private EntityCreator fabric;

    private Class<ENTITY> clazz = (Class<ENTITY>) (
            (ParameterizedType) getClass().getGenericSuperclass()
    ).getActualTypeArguments()[1];

    @Test
    public void shouldSaveEntity() throws Exception {
        ENTITY entity = createEntity();
        assertEquals(entity, repository.save(entity));
    }

    protected ENTITY createEntity() {
        return fabric.createEntity(clazz);
    }

}