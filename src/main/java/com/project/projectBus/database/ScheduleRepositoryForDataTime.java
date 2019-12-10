package com.project.projectBus.database;

import com.project.projectBus.schedules.ScheduleTime;
import java.util.List;
/**
 *
 * @author adhameldda
 */
public interface ScheduleRepositoryForDataTime {
    public int insert(ScheduleTime scheduleTime);
    public ScheduleTime findByScheduleBusId(int id);
    public List<ScheduleTime> findAll();
    public int count();
    public List<ScheduleTime> findByScheduleBusNumberLine(String numberLine);

}
