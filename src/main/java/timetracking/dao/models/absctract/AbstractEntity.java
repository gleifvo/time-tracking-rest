package timetracking.dao.models.absctract;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
@EqualsAndHashCode
public abstract class AbstractEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
}
