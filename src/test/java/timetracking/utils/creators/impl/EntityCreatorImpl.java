package timetracking.utils.creators.impl;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.springframework.stereotype.Service;
import timetracking.dao.models.AbstractEntity;
import timetracking.utils.creators.EntityCreator;

import javax.annotation.PostConstruct;

@Service
public class EntityCreatorImpl implements EntityCreator {

    private EnhancedRandom fabric;

    @Override
    public <ENTITY extends AbstractEntity> ENTITY createEntity(Class<ENTITY> clazz) {
        return fabric.nextObject(clazz);
    }

    @PostConstruct
    protected void createFabric() {
        fabric = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .stringLengthRange(5, 20)
                .build();
    }
}