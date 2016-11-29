package timetracking.dao.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import timetracking.dao.models.absctract.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserType extends AbstractEntity {

    @Column(nullable = false)
    private String roleName;
}