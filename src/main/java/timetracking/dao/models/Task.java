package timetracking.dao.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Task extends AbstractEntity {

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_creator_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private String name;

    @Exclude
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Report> reports;

}
