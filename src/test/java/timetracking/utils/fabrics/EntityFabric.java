package timetracking.utils.fabrics;

import timetracking.dao.models.absctract.AbstractEntity;

public interface EntityFabric {
    <ENTITY extends AbstractEntity> ENTITY generateEntity(Class<ENTITY> clazz);
}