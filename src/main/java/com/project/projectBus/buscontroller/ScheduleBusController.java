package com.project.projectBus.buscontroller;
import com.project.projectBus.schedules.ScheduleBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author adhameldda
 */
@CrossOrigin
@RestController
@RequestMapping("/ScheduleBus")
public class ScheduleBusController {

    @Autowired
    private ScheduleBusDataBase scheduleDataBase ;

    @PostMapping("/setNewRowSchedule")
    public void setNewRow(@RequestBody ScheduleBus scheduleBus) {
        scheduleDataBase.insert(scheduleBus);
    }

    @GetMapping("/findAll")
    public List<ScheduleBus> getSchedule(){
        return scheduleDataBase.findAll();
    }

    @GetMapping("/findByScheduleBusId/{id}")
    public ScheduleBus getById(@PathVariable Integer id){
        return scheduleDataBase.findByScheduleBusId(id);
    }

    @GetMapping("/numberRows")
    public int re(){
        return scheduleDataBase.count();
    }

    @GetMapping("/findByScheduleBusNumberLine/{lineNumber}")
    public List<ScheduleBus> getByLineNumber(@PathVariable String lineNumber) {
        return scheduleDataBase.findByScheduleBusNumberLine(lineNumber);
    }

}
