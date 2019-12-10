package com.project.projectBus.organizer;

import com.project.projectBus.schedules.ScheduleTableBus;
import com.project.projectBus.schedules.ScheduleTime;

import java.sql.Time;
/**
 *
 * @author adhameldda
 */
public class FinalSchedule   {

    private ScheduleTableBus scheduleTableBus;
    private ScheduleTime scheduleTime;
    private Time endTime;


    public FinalSchedule(ScheduleTableBus scheduleTableBus, ScheduleTime scheduleTime, Time endTime) {
        this.scheduleTableBus = scheduleTableBus;
        this.scheduleTime = scheduleTime;
        this.endTime = endTime;
    }
    public ScheduleTableBus getScheduleTableBus() {
        return scheduleTableBus;
    }
    public void setScheduleTableBus(ScheduleTableBus scheduleTableBus) {
        this.scheduleTableBus = scheduleTableBus;
    }
    public ScheduleTime getScheduleTime() {
        return scheduleTime;
    }
    public void setScheduleTime(ScheduleTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
    public Time getEndTime() {
        return endTime;
    }
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    @Override
    public String toString() {
        return "FinalSchedule{" +
                "scheduleTableBus=" + scheduleTableBus +
                ", scheduleTime=" + scheduleTime +
                ", endTime=" + endTime +
                '}';
    }

}
