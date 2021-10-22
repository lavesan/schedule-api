package com.test.scheduler.schedule;

import com.test.scheduler.schedule.response.ScheduleResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService service;

    @PostMapping("/schedule")
    public Schedule newSchedule(@RequestBody Schedule body) {
        return this.service.saveSchedule(body);
    }

    @GetMapping("/schedule/{scheduleId}")
    public ScheduleResultResponse getResult(@PathVariable("scheduleId") Integer scheduleId) {
        return this.service.getScheduleResult(scheduleId);
    };

    @GetMapping("/schedule")
    public Page<Schedule> findAllPaginated(@RequestParam("page") Integer page) {
        return this.service.findAllPaginated(page);
    }

}
