package timetracking.dao.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "report")
public class Report extends AbstractEntity implements Serializable {

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "task_id", referencedColumnName = "id", nullable = false)
    private Task task;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private String description;

    @Column(nullable = false, name = "time")
    private Long time = 0L;

}