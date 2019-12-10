package com.project.projectBus.ConnectionTwoFile;

import com.project.projectBus.buscontroller.ScheduleBusDataBase;
import com.project.projectBus.organizer.Station;
import com.project.projectBus.schedules.ScheduleBus;
import com.project.projectBus.schedules.ScheduleTableBus;
import com.project.projectBus.schedules.ScheduleTime;
import com.project.projectBus.timecontroller.ScheduleTimeDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adhameldda
 */
@Component
public class GetInformation {

    private List<ScheduleTableBus> listTableBus = new ArrayList<>() ;
    private List<ScheduleBus> scheduleBuses = new ArrayList<>() ;
    private List<ScheduleTime> scheduleTimes  = new ArrayList<>() ;
    private List<Station> stations = new ArrayList<>() ;
    private List<String> lineNumbers = new ArrayList<>() ;
    @Autowired
    private ScheduleBusDataBase scheduleBusDataBase ;
    @Autowired
    private ScheduleTimeDataBase scheduleTimeDataBase;

    public List<ScheduleTableBus> tableBus(){
        List<ScheduleBus> listBus ;
        listBus = scheduleBusDataBase.findAll();


        int j=0;
        listTableBus.add(new ScheduleTableBus(listBus.get(0).getCompany(),
                listBus.get(0).getClusterNumber(),
                listBus.get(0).getSku(),
                listBus.get(0).getLineNumber(),
                listBus.get(0).getDirection(),
                listBus.get(0).getAlternative(),
                listBus.get(0).getStationName(),
                null,
                null,
                listBus.get(0).getLet_(),
                listBus.get(0).getLong_(),
                listBus.get(0).getCityCode(),
                listBus.get(0).getCityName(),
                listBus.get(0).getStatus(),
                listBus.get(0).getAreaCode(),
                null,
                null));

        for (int i = 1; i < listBus.size(); i++) {

            if (listBus.get(i).getArranging().equals(Double.toString(1.0))) {

                listTableBus.add(new ScheduleTableBus(listBus.get(i).getCompany(),
                        listBus.get(i).getClusterNumber(),
                        listBus.get(i).getSku(),
                        listBus.get(i).getLineNumber(),
                        listBus.get(i).getDirection(),
                        listBus.get(i).getAlternative(),
                        listBus.get(i).getStationName(),
                        null,
                        null,
                        listBus.get(i).getLet_(),
                        listBus.get(i).getLong_(),
                        listBus.get(i).getCityCode(),
                        listBus.get(i).getCityName(),
                        listBus.get(i).getStatus(),
                        listBus.get(i).getAreaCode(),null,null));

                        listTableBus.get(j).setEndStation(listBus.get(i-1).getStationName());
                        listTableBus.get(j).setTimeTrip(listBus.get(i-1).getTimeTrip());
                        listTableBus.get(j).setLet_End(listBus.get(i-1).getLet_());
                        listTableBus.get(j).setLong_End(listBus.get(i-1).getLong_());


                j++;
                }


            }
        listTableBus.get(j).setEndStation(listBus.get(listBus.size()-1).getStationName());
        listTableBus.get(j).setTimeTrip(listBus.get(listBus.size()-1).getTimeTrip());
        listTableBus.get(j).setLet_End(listBus.get(listBus.size()-1).getLet_());
        listTableBus.get(j).setLong_End(listBus.get(listBus.size()-1).getLong_());

        return listTableBus;


    }
    public List<ScheduleBus> getScheduleBuses() {
        this.scheduleBuses = scheduleBusDataBase.findAll();
        return scheduleBuses;
    }
    public List<ScheduleTime> getScheduleTimes() {
        this.scheduleTimes = scheduleTimeDataBase.findAll();
        return scheduleTimes;
    }
    public List<Station> getStations() {
        List<ScheduleTableBus> list = getListTableBus();
        List<String> s = new ArrayList<>(); //for check contains

        for (int i = 0; i < list.size() ; i++) {


            if (!s.contains(list.get(i).getStartStation())) {
                s.add(list.get(i).getStartStation());
                stations.add( new Station(list.get(i).getStartStation(),list.get(i).getLet_(),list.get(i).getLong_()));
            }
        }
        for (int i = 0; i <list.size() ; i++) {
            if (!s.contains(list.get(i).getEndStation())) {
                s.add(list.get(i).getEndStation());
                stations.add( new Station(list.get(i).getEndStation(),list.get(i).getLet_End(),list.get(i).getLong_End()));
            }
        }

        return stations;
    }
    public List<String> getLineNumbers() {
        this.lineNumbers = scheduleBusDataBase.getNumberLine();
        return lineNumbers;
    }
    public List<ScheduleTableBus> getListTableBus() {
        return listTableBus;
    }
    @Override
    public String toString() {
        return "GetInformation{" +
                "listTableBus=" + listTableBus +
                ", scheduleBuses=" + scheduleBuses +
                ", scheduleTimes=" + scheduleTimes +
                ", stations=" + stations +
                ", lineNumbers=" + lineNumbers +
                '}';
    }
}
