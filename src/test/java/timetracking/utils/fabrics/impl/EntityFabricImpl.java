package timetracking.utils.fabrics.impl;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.springframework.stereotype.Service;
import timetracking.dao.models.AbstractEntity;
import timetracking.utils.fabrics.EntityFabric;

import javax.annotation.PostConstruct;

@Service("entityFabric")
public class EntityFabricImpl implements EntityFabric {

    protected EnhancedRandom fabric;

    @PostConstruct
    public void init() throws Exception{
        fabric = createFabric();
    }

    @Override
    public <ENTITY extends AbstractEntity> ENTITY generateEntity(Class<ENTITY> clazz) {
        return fabric.nextObject(clazz);
    }

    protected EnhancedRandom createFabric() {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .maxStringLength(20)
                .build();
    }
}