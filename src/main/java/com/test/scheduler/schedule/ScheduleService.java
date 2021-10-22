package com.test.scheduler.schedule;

import com.test.scheduler.schedule.response.ScheduleResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    public Schedule saveSchedule(Schedule newSchedule) {
        return this.repository.save(newSchedule);
    }

    public ScheduleResultResponse getScheduleResult (Integer scheduleId) {
        return this.repository.getScheduleResult(scheduleId);
    }

    public Page<Schedule> findAllPaginated(Integer page) {
        Pageable paginationConfig = PageRequest.of(page, 10);
        return this.repository.findAll(paginationConfig);
    }

}
