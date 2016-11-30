package timetracking.utils;

import timetracking.dao.models.absctract.AbstractEntity;

import java.lang.reflect.Field;

public class TestUtils {
    public static void setId(AbstractEntity entity, long id) throws NoSuchFieldException, IllegalAccessException {
        Field field = AbstractEntity.class.getDeclaredField("id");
        field.setAccessible(true);
        field.set(entity, id);
    }
}