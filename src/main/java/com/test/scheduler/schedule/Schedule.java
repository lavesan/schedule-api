package com.test.scheduler.schedule;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.test.scheduler.session.Session;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sc_schedule")
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sc_id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 50)
    private String title;

    @JsonManagedReference
    @OneToMany(mappedBy = "schedule")
    private Set<Session> sessions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
