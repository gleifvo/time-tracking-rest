package timetracking.utils.fabrics.impl;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.Randomizer;
import org.springframework.stereotype.Service;
import timetracking.dao.models.Project;
import timetracking.dao.models.User;
import timetracking.utils.TestUtils;
import timetracking.utils.fabrics.EntityFabric;

@Service("projectEntityFabric")
public class ProjectEntityFabric extends UserEntityFabric implements EntityFabric {

    private User user;

    @Override
    public void init() throws Exception {
        user = new User();
        TestUtils.setId(user, 1L);
        super.init();
    }

    @Override
    protected EnhancedRandom createFabric() {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .randomize(FieldDefinitionBuilder.field().named("user").ofType(User.class).inClass(Project.class).get(), (Randomizer<User>) () -> user)
                .maxStringLength(40)
                .build();
    }
}