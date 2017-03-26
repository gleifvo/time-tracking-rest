package timetracking.dao.models;


import io.github.benas.randombeans.annotation.Exclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@MappedSuperclass
@EqualsAndHashCode
@Accessors(chain = true)
public abstract class AbstractEntity {

    @Id
    @Exclude
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

}