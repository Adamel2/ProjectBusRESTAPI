package com.project.projectBus.organizer;

import com.project.projectBus.ConnectionTwoFile.GetInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adhameldda
 */

@Component
public class Stations {



    @Autowired
    private GetInformation getInformation;

    private List<Station> stationsList ;

    public List<Station> getStationsList() {

        stationsList = new ArrayList<>();
        stationsList=getInformation.getStations();

        return stationsList;
    }

    public void setStationsList(Station station) {
        this.stationsList.add(station);
    }

    @Override
    public String toString() {
        return "Stations{" +
                "stationsList=" + stationsList +
                '}';
    }
}
