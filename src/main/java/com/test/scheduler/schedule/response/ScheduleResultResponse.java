package com.test.scheduler.schedule.response;

public interface ScheduleResultResponse {
    public boolean isAgreeable();
    public Integer getVotesYesQuant();
    public Integer getVotesNoQuant();
}
