package com.test.scheduler.vote;

import com.test.scheduler.session.Session;
import com.test.scheduler.vote.request.SaveNewVote;
import com.test.scheduler.vote.response.CanVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class VoteService {

    @Autowired
    VoteRepository repository;

    private boolean canVote(String cpf, Integer sessionId) {
        return this.repository.hasVote(cpf, sessionId) == null;
    }

    public Object saveOne(SaveNewVote newVote) {
        boolean canVote = this.canVote(newVote.cpf, newVote.sessionId);

        if (!canVote) {
            // TODO: Handler não pode votar
            return null;
        }

        Vote voteToSave = new Vote();
        voteToSave.setCpf(newVote.cpf);
        voteToSave.setAgree(newVote.agree);

        Session sessionToAdd = new Session();
        sessionToAdd.setId(newVote.sessionId);

        voteToSave.setSession(sessionToAdd);

        return this.repository.save(voteToSave);
    }
}
