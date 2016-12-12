package timetracking.utils.fabrics.impl;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.Randomizer;
import org.springframework.stereotype.Service;
import timetracking.dao.models.Project;
import timetracking.dao.models.Task;
import timetracking.dao.models.User;
import timetracking.utils.TestUtils;
import timetracking.utils.fabrics.EntityFabric;

@Service("taskEntityFabric")
public class TaskEntityFabric extends ProjectEntityFabric implements EntityFabric {

    private Project project;

    @Override
    public void init() throws Exception {
        project = new Project();
        TestUtils.setId(project, 1L);
        super.init();
    }

    @Override
    protected EnhancedRandom createFabric() {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .randomize(FieldDefinitionBuilder.field().named("user").ofType(User.class).inClass(Task.class).get(), (Randomizer<User>) () -> user)
                .randomize(FieldDefinitionBuilder.field().named("project").ofType(Project.class).inClass(Task.class).get(), (Randomizer<Project>) () -> project)
                .maxStringLength(200)
                .build();
    }
}