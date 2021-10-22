package com.test.scheduler.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.test.scheduler.schedule.Schedule;
import com.test.scheduler.vote.Vote;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "se_session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "se_id", nullable = false)
    private Integer id;

    @Column(name = "started_time", nullable = false)
    private Timestamp startedTime;

    @Column(name = "active_time", nullable = false)
    private Timestamp activeTime;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="sc_id")
    private Schedule schedule;

    @JsonManagedReference
    @OneToMany(mappedBy = "session")
    private Set<Vote> votes;

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(Timestamp startedTime) {
        this.startedTime = startedTime;
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}
