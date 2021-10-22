package com.test.scheduler.session;

import com.test.scheduler.schedule.Schedule;
import com.test.scheduler.session.request.SaveNewSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Service
public class SessionService {

    @Autowired
    SessionRepository repository;

    public Session saveOne(SaveNewSession newSession) {
        Date today = new Date();

        if (newSession.activeTime == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 1);
            newSession.activeTime = new Timestamp(calendar.getTimeInMillis());
        }

        Session sessionToSave = new Session();
        sessionToSave.setStartedTime(new Timestamp(today.getTime()));
        sessionToSave.setActiveTime(newSession.activeTime);

        Schedule schedule = new Schedule();
        schedule.setId(newSession.scheduleId);

        sessionToSave.setSchedule(schedule);

        return this.repository.save(sessionToSave);
    }
}
