package com.project.projectBus.organizer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author adhameldda
 */


public class Station implements Comparator<Station> {

    private String stationName;
    private String let_;
    private String long_;
    private List<Bus> listBus= new ArrayList<Bus>();


    public Station(String stationName, String let_, String long_) {
        this.stationName = stationName;
        this.let_ = let_;
        this.long_ = long_;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<Bus> getList() {
        return listBus;
    }

    public void setBus(Bus bus) {
        this.listBus.add(bus);
    }

    public String getLet_() {
        return let_;
    }

    public void setLet_(String let_) {
        this.let_ = let_;
    }

    public String getLong_() {
        return long_;
    }

    public void setLong_(String long_) {
        this.long_ = long_;
    }
    @Override
    public int compare(Station o1, Station o2) {
        return o1.getLet_().compareTo(o2.getLet_());
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationName='" + stationName + '\'' +
                ", let_='" + let_ + '\'' +
                ", long_='" + long_ + '\'' +
                ", listBus=" + listBus +
                '}';
    }
}
