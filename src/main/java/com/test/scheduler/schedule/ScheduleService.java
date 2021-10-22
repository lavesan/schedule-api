package com.test.scheduler.service;

import com.test.scheduler.model.ScheduleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public class ScheduleService {

    private final ScheduleRepository repository;

    ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    ScheduleRepository saveSchedule(ScheduleRepository newSchedule) {
        return this.repository.save(newSchedule);
    }

}
