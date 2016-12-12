package timetracking.dao.models;


import io.github.benas.randombeans.annotation.Exclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
@EqualsAndHashCode
public abstract class AbstractEntity {

    @Id
    @Exclude
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
}
