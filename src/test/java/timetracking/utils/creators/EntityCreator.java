package timetracking.utils.creators;

import timetracking.dao.models.AbstractEntity;

public interface EntityCreator {

    <ENTITY extends AbstractEntity> ENTITY createEntity(Class<ENTITY> clazz);

}