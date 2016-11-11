package timetracking.dao.models;

import lombok.Getter;
import timetracking.dao.models.Project;
import timetracking.dao.models.User;
import timetracking.dao.models.absctract.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Task extends AbstractEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_creator_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private String description;
}
