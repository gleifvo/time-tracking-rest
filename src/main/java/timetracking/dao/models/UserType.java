package timetracking.dao.models;

import lombok.Getter;
import timetracking.dao.models.absctract.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
public class UserType extends AbstractEntity {

    @Column(nullable = false)
    private String roleName;
}