package timetracking.dao.repositories.generic;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import timetracking.dao.models.AbstractEntity;
import timetracking.utils.creators.EntityCreator;

import java.lang.reflect.ParameterizedType;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@WithMockUser(roles = {"ADMIN"})
public abstract class GenericRepositoryTest<REPOSITORY extends CrudRepository<ENTITY, Long>, ENTITY extends AbstractEntity> {

    @Autowired
    protected REPOSITORY repository;

    @Autowired
    private EntityCreator fabric;

    private Class<ENTITY> clazz = (Class<ENTITY>) (
            (ParameterizedType) getClass().getGenericSuperclass()
    ).getActualTypeArguments()[1];

    @Test
    public void shouldSaveEntity() throws Exception {
        ENTITY entity = getEntity();
        assertEquals(entity, repository.save(entity));
    }

    protected ENTITY getEntity() {
        return fabric.createEntity(clazz);
    }
}