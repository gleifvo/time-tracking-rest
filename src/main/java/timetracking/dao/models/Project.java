package timetracking.dao.models;

import io.github.benas.randombeans.annotation.Exclude;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Project extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_creator_id", referencedColumnName = "id")
    private User user;

    @Exclude
    @ManyToMany(targetEntity = User.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "user_projects", joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;

}
