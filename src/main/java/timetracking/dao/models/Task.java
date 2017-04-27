package timetracking.dao.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Task extends AbstractEntity {

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_creator_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;

    @Column(nullable = false)
    private String description;

}
