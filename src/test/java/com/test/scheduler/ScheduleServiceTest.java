package com.test.scheduler;

import com.test.scheduler.schedule.Schedule;
import com.test.scheduler.schedule.ScheduleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ScheduleRepositoryTest {

    @Autowired
    private ScheduleRepository repository;

    @Test
    public void testAddNew() {
        Schedule schedule = new Schedule();
        schedule.setTitle("Título teste");

        Schedule savedSchedule = this.repository.save(schedule);

        Assertions.assertTrue(savedSchedule != null);
        Assertions.assertTrue(savedSchedule.getId() != null && savedSchedule.getId() > 0);
    }
}
