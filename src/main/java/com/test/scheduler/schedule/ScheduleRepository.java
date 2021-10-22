package com.test.scheduler.schedule;

import com.test.scheduler.schedule.response.ScheduleResultResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>, PagingAndSortingRepository<Schedule, Integer> {
    @Query("select sum(case vo.agree when true then 1 else 0 end) as votesYes, sum(case vo.agree when false then 1 else 0 end) as votesNo, " +
            "(sum(case vo.agree when true then 1 else 0 end) > sum(case vo.agree when false then 1 else 0 end)) as agreeable " +
            "from Schedule sc " +
            "left join Session se " +
            "on sc.id = se.schedule.id " +
            "left join Vote vo " +
            "on se.id = vo.session.id " +
            "where sc.id = ?1")
    ScheduleResultResponse getScheduleResult(Integer scheduleId);
}
