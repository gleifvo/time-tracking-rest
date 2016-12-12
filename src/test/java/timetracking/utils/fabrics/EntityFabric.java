package timetracking.utils.fabrics;

import timetracking.dao.models.AbstractEntity;

public interface EntityFabric {
    <ENTITY extends AbstractEntity> ENTITY generateEntity(Class<ENTITY> clazz);
}