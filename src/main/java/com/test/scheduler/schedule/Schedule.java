package com.test.scheduler.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sc_schedule")
@SequenceGenerator(name = "seq_schedule", sequenceName = "seq_schedule", allocationSize = 1, initialValue = 1)
public class ScheduleRepository implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_schedule")
    @Column(name = "sc_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = true, length = 50)
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
