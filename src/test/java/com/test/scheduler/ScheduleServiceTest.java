package com.test.scheduler;

import com.test.scheduler.schedule.Schedule;
import com.test.scheduler.schedule.ScheduleRepository;
import com.test.scheduler.schedule.ScheduleService;
import com.test.scheduler.schedule.response.ScheduleResultResponse;
import com.test.scheduler.session.SessionRepository;
import com.test.scheduler.vote.VoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
@ExtendWith(MockitoExtension.class)
public class ScheduleServiceTest {

    @MockBean
    ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleService scheduleService;

    @Test
    public void testAddSchedule() {
        Schedule schedule = new Schedule();
        schedule.setTitle("Título teste");

        Mockito.when(this.scheduleRepository.save(schedule)).thenReturn(schedule);
        Schedule savedSchedule = this.scheduleService.saveSchedule(schedule);

        Assertions.assertTrue(savedSchedule != null);
    }

    @Test
    public void testFindAllPaginated() {
        Page<Schedule> schedules = Mockito.mock(Page.class);
        Pageable paginationConfig = PageRequest.of(0, 10);
        Mockito.when(this.scheduleRepository.findAll(paginationConfig)).thenReturn(schedules);
        Page<Schedule> results = this.scheduleService.findAllPaginated(0);

        Assertions.assertTrue(results != null);
    }

    @Test
    public void testGetScheduleResult() {
        ScheduleResultResponse mockedRes = new ScheduleResultResponse() {
            @Override
            public boolean isAgreeable() {
                return true;
            }

            @Override
            public Integer getVotesYesQuant() {
                return 2;
            }

            @Override
            public Integer getVotesNoQuant() {
                return 1;
            }
        };

        Mockito.when(this.scheduleRepository.getScheduleResult(0)).thenReturn(mockedRes);

        ScheduleResultResponse result = this.scheduleService.getScheduleResult(0);

        Assertions.assertTrue(result != null);
        Assertions.assertTrue(result.isAgreeable());
        Assertions.assertTrue(result.getVotesYesQuant() == 2);
        Assertions.assertTrue(result.getVotesNoQuant() == 1);
    }
}
