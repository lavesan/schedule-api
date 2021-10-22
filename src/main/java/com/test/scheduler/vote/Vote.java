package com.test.scheduler.vote;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.test.scheduler.schedule.Schedule;
import com.test.scheduler.session.Session;

import javax.persistence.*;

@Entity
@Table(name = "vo_vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vo_id", nullable = false)
    private Integer id;

    @Column(name="agree")
    private boolean agree;

    @Column(name="cpf", length = 11)
    private String cpf;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="se_id")
    private Session session;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
