package com.test.scheduler.vote;

import com.test.scheduler.vote.response.CanVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    @Query("SELECT DISTINCT vo.cpf as cpf FROM Vote vo " +
            "LEFT JOIN Session se " +
            "ON se.id = vo.session.id " +
            "WHERE vo.cpf = ?1 " +
            "AND vo.session.id = ?2")
    CanVote hasVote(String cpf, Integer sessionId);
}
