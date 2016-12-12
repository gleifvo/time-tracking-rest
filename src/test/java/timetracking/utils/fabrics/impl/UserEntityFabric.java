package timetracking.utils.fabrics.impl;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.Randomizer;
import org.springframework.stereotype.Service;
import timetracking.dao.models.User;
import timetracking.dao.models.UserType;
import timetracking.utils.TestUtils;
import timetracking.utils.fabrics.EntityFabric;

@Service("userEntityFabric")
public class UserEntityFabric extends EntityFabricImpl implements EntityFabric {

    protected UserType userType;

    @Override
    public void init() throws Exception {
        userType = new UserType("userType");
        TestUtils.setId(userType, 1L);
        super.init();
    }

    @Override
    protected EnhancedRandom createFabric() {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .randomize(FieldDefinitionBuilder.field().named("userType").ofType(UserType.class).inClass(User.class).get(), (Randomizer<UserType>) () -> userType)
                .maxStringLength(20)
                .build();
    }
}