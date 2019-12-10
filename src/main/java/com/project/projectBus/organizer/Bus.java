package com.project.projectBus.organizer;

import java.sql.Time;
/**
 *
 * @author adhameldda
 */
public class Bus {
    private String startLocation;
    private String endLocation;
    private String numberLineInService;
    private Time startTrip;
    private Time endTrip;
    private static int number =0;
    private int serial;

    public Bus(String startLocation, String endLocation, String numberLineInService, Time startTrip, Time endTrip) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.numberLineInService = numberLineInService;
        this.startTrip = startTrip;
        this.endTrip = endTrip;
        this.serial=number++;
    }
    public int getSerial() {
        return serial;
    }
    public void setSerial(int serial) {
        this.serial = serial;
    }
    public String getNumberLineInService() {
        return numberLineInService;
    }
    public void setNumberLineInService(String numberLineInService) {
        this.numberLineInService = numberLineInService;
    }
    public Time getStartTrip() {
        return startTrip;
    }
    public void setStartTrip(Time startTrip) {
        this.startTrip = startTrip;
    }
    public Time getEndTrip() {
        return endTrip;
    }
    public void setEndTrip(Time endTrip) {
        this.endTrip = endTrip;
    }
    public String getStartLocation() {
        return startLocation;
    }
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }
    public String getEndLocation() {
        return endLocation;
    }
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
    public int getSerialGlobalLimit(){
        return number;
    }
    @Override
    public String toString() {
        return "Bus{" +
                "startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", numberLineInService='" + numberLineInService + '\'' +
                ", startTrip=" + startTrip +
                ", endTrip=" + endTrip +
                ", serial=" + serial +
                '}';
    }
}