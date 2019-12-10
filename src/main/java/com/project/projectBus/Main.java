package com.project.projectBus;

import com.project.projectBus.organizer.Organizer;
import com.project.projectBus.result.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adhameldda
 */
@CrossOrigin
@RestController
@RequestMapping("result")
public class Main {


    private Organizer organizer ;
    private List<Result> results;

    public Main(Organizer organizer){
        this.organizer = organizer;
        this.organizer.algorithm();
        results = this.organizer.getResults();
    }

    @GetMapping("getInformation")
    public List<Result> testing(){

        return results;
    }







}
