package com.project.projectBus.result;

import java.sql.Time;
/**
 *
 * @author adhameldda
 */
public class Result {

    private int serialBus;
    private int numberLine;
    private Time startTime;
    private Time endTime;
    private String startStation;
    private String endStation;


    public Result(int serialBus, int numberLine, Time startTime, Time endTime, String startStation, String endStation) {
        this.serialBus = serialBus;
        this.numberLine = numberLine;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public int getSerialBus() {
        return serialBus;
    }

    public void setSerialBus(int serialBus) {
        this.serialBus = serialBus;
    }

    public int getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    @Override
    public String toString() {
        return "Result{" +
                "serialBus=" + serialBus +
                ", numberLine=" + numberLine +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startStation='" + startStation + '\'' +
                ", endStation='" + endStation + '\'' +
                '}';
    }
}
