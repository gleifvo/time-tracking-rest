package timetracking.dao.models;


import io.github.benas.randombeans.annotation.Exclude;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@MappedSuperclass
@Accessors(chain = true)
public abstract class AbstractEntity {

    @Id
    @Exclude
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

}