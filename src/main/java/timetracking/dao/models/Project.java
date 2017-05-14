package timetracking.dao.models;

import io.github.benas.randombeans.annotation.Exclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class Project extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_creator_id", referencedColumnName = "id")
    private User user;

    @Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_projects", joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;

    @Exclude
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks;

}
