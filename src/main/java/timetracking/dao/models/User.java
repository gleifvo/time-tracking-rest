package timetracking.dao.models;

import io.github.benas.randombeans.annotation.Exclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    private UserType userType;

    @Exclude
    @ManyToMany(targetEntity = Task.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "user_2task", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private List<Task> tasks;
}