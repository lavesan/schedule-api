package com.test.scheduler.vote;

import com.test.scheduler.vote.request.SaveNewVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    @Autowired
    VoteService voteService;

    @PostMapping("/vote")
    public Object saveNewVote(@RequestBody SaveNewVote newVote) {
        return this.voteService.saveOne(newVote);
    }
}
