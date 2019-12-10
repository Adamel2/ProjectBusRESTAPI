package com.project.projectBus.database;
import com.project.projectBus.schedules.ScheduleBus;
import java.util.List;

/**
 *
 * @author adhameldda
 */
public interface ScheduleRepositoryForDataBus {
    public int insert(ScheduleBus scheduleBus);
    public ScheduleBus findByScheduleBusId(int id);
    public List<ScheduleBus> findAll();
    public int count();
    public List<ScheduleBus> findByScheduleBusNumberLine(String numberLine);
    public List<String> getStations();
    public List<String> getNumberLine();

}
