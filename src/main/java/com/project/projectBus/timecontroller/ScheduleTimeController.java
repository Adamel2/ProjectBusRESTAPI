package com.project.projectBus.timecontroller;

import com.project.projectBus.schedules.ScheduleTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ScheduleTime")
public class ScheduleTimeController {

    @Autowired
    private ScheduleTimeDataBase scheduleTimeDataBase ;


    @PostMapping("/setNewRowScheduleTime")
    public void setNewRow(@RequestBody ScheduleTime scheduleTime) {
        scheduleTimeDataBase.insert(scheduleTime);
    }

    @GetMapping("/findAll")
    public List<ScheduleTime> getSchedule(){
        return scheduleTimeDataBase.findAll();
    }

    @GetMapping("/findByScheduleTimeId/{id}")
    public ScheduleTime getById(@PathVariable Integer id){
        return scheduleTimeDataBase.findByScheduleBusId(id);
    }

    @GetMapping("/numberRows")
    public int re(){
        return scheduleTimeDataBase.count();
    }

    @GetMapping("/findByScheduleBusNumberLine/{lineNumber}")
    public List<ScheduleTime> getByLineNumber(@PathVariable String lineNumber){
        return scheduleTimeDataBase.findByScheduleBusNumberLine(lineNumber);
    }


}
