package com.test.scheduler.session;

import com.test.scheduler.session.request.SaveNewSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @Autowired
    SessionService service;

    @PostMapping("/session")
    public Session saveNewSession(@RequestBody SaveNewSession body) {
        return this.service.saveOne(body);
    }
}
