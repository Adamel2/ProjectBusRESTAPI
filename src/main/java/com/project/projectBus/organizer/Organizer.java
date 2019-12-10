package com.project.projectBus.organizer;


import com.project.projectBus.ConnectionTwoFile.GetInformation;
import com.project.projectBus.result.Result;
import com.project.projectBus.schedules.ScheduleTableBus;
import com.project.projectBus.schedules.ScheduleTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author adhameldda
 */
@Component
public class Organizer {

    @Autowired
    private Stations stations;
    @Autowired
    private GetInformation getInformation;
    private List<Station> allStations;
    private List<ScheduleTableBus> scheduleTableBuses;
    private List<ScheduleTime> scheduleTime;
    private List<FinalSchedule> finalSchedules;
    private List<Bus> bussInTrip = new ArrayList<Bus>();
    private List<Result> results =new ArrayList<Result>();
    private Double distance=0.0;//
    private float wasteTime=0;
    private float realTotalTimeWork=0;
    private float allTimeBusWest=0;
    public int numberBus=0;
    public void managementStations() {
        finalSchedules = new ArrayList<>();
        scheduleTableBuses = getInformation.tableBus();
        allStations = stations.getStationsList();
        scheduleTime = getInformation.getScheduleTimes();
        for (int j = 0; j <scheduleTime.size()-26; j++) {

            for (int i = 0; i < scheduleTableBuses.size(); i++) {

                if (scheduleTableBuses.get(i).getDirection().equals(scheduleTime.get(j).getDirection()) &&
                        scheduleTableBuses.get(i).getAlternative().equals(scheduleTime.get(j).getAlternative()) &&
                        scheduleTableBuses.get(i).getLineNumber().equals(scheduleTime.get(j).getLinenumber()) &&
                        scheduleTableBuses.get(i).getSku().equals(scheduleTime.get(j).getSku()) &&
                        scheduleTableBuses.get(i).getCompany().equals(scheduleTime.get(j).getCompany())
                       ) {
                    Time time = (Time) scheduleTime.get(j).getLeavingTime().clone();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(time);
                    calendar.add(Calendar.MINUTE, (int) Double.parseDouble(scheduleTableBuses.get(i).getTimeTrip()) + 20);
                    time.setTime(calendar.getTimeInMillis());
                    finalSchedules.add(new FinalSchedule(scheduleTableBuses.get(i), scheduleTime.get(j), time));
                } } } }
    public int calDiff(Time time1,Time time2){
        return (int)(((time2.getTime()-time1.getTime())/(1000))/60);
    }
    public void algorithm() {
        managementStations();
        int index = -1;
        for (int i = 0; i < finalSchedules.size(); i++) {
            index = search(finalSchedules.get(i).getScheduleTableBus().getStartStation());
            clearTripsArray(finalSchedules.get(i));
            checkSearchBus(allStations.get(index), finalSchedules.get(i));
        }
        calculateWasteTime();
        float resultPercent=(((allTimeBusWest-(numberBus*20))/realTotalTimeWork)*100);
        System.out.println("the bus working start at:"+scheduleTime.get(0).getLeavingTime()+" end at:"+finalSchedules.get(finalSchedules.size()-1).getScheduleTime().getLeavingTime());
        System.out.println("number of trips:"+finalSchedules.size());
        System.out.println("the waste time for all the buses in stopping:"+resultPercent+"%");
        System.out.println("the number of buses:"+numberBus);
        System.out.println("the waste time in trip empty:"+(int)wasteTime+" Minutes");

    }
    public void clearTripsArray(FinalSchedule finalSchedule) {
        int index = -1;
        String nameStation = "";
        for (int i = 0; i < bussInTrip.size(); i++) {
            if (finalSchedule.getScheduleTime().getLeavingTime().after(bussInTrip.get(i).getEndTrip())) {
//                System.out.println(bussInTrip.get(i)+" is arrive");
                nameStation = bussInTrip.get(i).getEndLocation();
                index = search(nameStation);
                bussInTrip.get(i).setStartLocation(null);
                bussInTrip.get(i).setEndLocation(null);
                bussInTrip.get(i).setNumberLineInService(null);
                bussInTrip.get(i).setStartTrip(null);
                allStations.get(index).setBus(bussInTrip.get(i));
                bussInTrip.remove(bussInTrip.get(i));
                i = -1;
            }
        }

    }
    public void checkSearchBus(Station station, FinalSchedule finalSchedule) {

        double time = 0;
        int index = getMinDistance(station);
        if (!station.getList().isEmpty()) {
            Bus bus = station.getList().get(0);
            allTimeBusWest=allTimeBusWest+calDiff(bus.getEndTrip(),finalSchedule.getScheduleTime().getLeavingTime());
            bus.setStartLocation(finalSchedule.getScheduleTableBus().getStartStation());
            bus.setEndLocation(finalSchedule.getScheduleTableBus().getEndStation());
            bus.setNumberLineInService(finalSchedule.getScheduleTableBus().getLineNumber());
            bus.setStartTrip(finalSchedule.getScheduleTime().getLeavingTime());
            bus.setEndTrip(finalSchedule.getEndTime());
            //(int serialBus, int numberLine, Time startTime, Time endTime, String startStation, String endStation)
            results.add(new Result(bus.getSerial(),(int)Double.parseDouble(finalSchedule.getScheduleTableBus().getLineNumber()),finalSchedule.getScheduleTime().getLeavingTime(),finalSchedule.getEndTime(),finalSchedule.getScheduleTableBus().getStartStation(),finalSchedule.getScheduleTableBus().getEndStation()));
            bussInTrip.add(bus);


            station.getList().remove(0);

        } else if (station.getList().isEmpty() && index != -1) {

            time = calculateSpeed(station);
            index = getMinDistance(station);
            Time timeNew = (Time) allStations.get(index).getList().get(0).getEndTrip().clone();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(timeNew);
            calendar.add(Calendar.MINUTE, (int) time);
            timeNew.setTime(calendar.getTimeInMillis());
            if (timeNew.before(finalSchedule.getScheduleTime().getLeavingTime())) {
                wasteTime+=time;
                Bus bus2 = allStations.get(index).getList().get(0);
                allTimeBusWest=allTimeBusWest+calDiff(bus2.getEndTrip(),finalSchedule.getScheduleTime().getLeavingTime());
                allStations.get(index).getList().remove(0);
                bus2.setStartLocation(finalSchedule.getScheduleTableBus().getStartStation());
                bus2.setEndLocation(finalSchedule.getScheduleTableBus().getEndStation());
                bus2.setNumberLineInService(finalSchedule.getScheduleTableBus().getLineNumber());
                bus2.setStartTrip(finalSchedule.getScheduleTime().getLeavingTime());
                bus2.setEndTrip(finalSchedule.getEndTime());
                results.add(new Result(bus2.getSerial(),(int)Double.parseDouble(finalSchedule.getScheduleTableBus().getLineNumber()),finalSchedule.getScheduleTime().getLeavingTime(),finalSchedule.getEndTime(),finalSchedule.getScheduleTableBus().getStartStation(),finalSchedule.getScheduleTableBus().getEndStation()));

                bussInTrip.add(bus2);



            } else {
                Bus bus3= new Bus(finalSchedule.getScheduleTableBus().getStartStation(),
                        finalSchedule.getScheduleTableBus().getEndStation(),
                        finalSchedule.getScheduleTableBus().getLineNumber(),
                        finalSchedule.getScheduleTime().getLeavingTime(),
                        finalSchedule.getEndTime());
                numberBus++;
                results.add(new Result(bus3.getSerial(),(int)Double.parseDouble(finalSchedule.getScheduleTableBus().getLineNumber()),finalSchedule.getScheduleTime().getLeavingTime(),finalSchedule.getEndTime(),finalSchedule.getScheduleTableBus().getStartStation(),finalSchedule.getScheduleTableBus().getEndStation()));

                bussInTrip.add(bus3);
//                System.out.println(bus3);

            }
        } else {
           Bus bus4= new Bus(finalSchedule.getScheduleTableBus().getStartStation(),
                    finalSchedule.getScheduleTableBus().getEndStation(),
                    finalSchedule.getScheduleTableBus().getLineNumber(),
                    finalSchedule.getScheduleTime().getLeavingTime(),
                    finalSchedule.getEndTime());
            numberBus++;
            results.add(new Result(bus4.getSerial(),(int)Double.parseDouble(finalSchedule.getScheduleTableBus().getLineNumber()),finalSchedule.getScheduleTime().getLeavingTime(),finalSchedule.getEndTime(),finalSchedule.getScheduleTableBus().getStartStation(),finalSchedule.getScheduleTableBus().getEndStation()));

            bussInTrip.add(bus4);
//            System.out.println(bus4);

        }

    }
    public Double calculateSpeed(Station station) {
        double time = 0;
        int index;
        index = getMinDistance(station);
        if (distance < 7&&index!=-1) {
            time = distance / 60;
            time *= 60;

            return time;
        } else if(distance>=10&&index!=-1){
            time = distance / 100;
            time *= 60;

            return time;
        }
        return time;
    }
    public int search(String nameStation) {
        for (int i = 0; i < allStations.size(); i++) {

            if (allStations.get(i).getStationName().equals(nameStation)) {
                return i;
            }
        }
        return -1;

    }
    public int getMinDistance(Station station) {
         int index = -1;
        double min = 0,d=0.0;


        for (int i = 0; i < allStations.size() ; i++) {

            if (!station.getStationName().equals(allStations.get(i).getStationName())) {

                d = distanceKm(Double.parseDouble(station.getLet_()), Double.parseDouble(station.getLong_()), Double.parseDouble(allStations.get(i).getLet_()), Double.parseDouble(allStations.get(i).getLong_()), "K" );
                if (min == 0 && !allStations.get(i).getList().isEmpty()) {
                    min = d;
                    index = i;
                    distance=min;

                } else {
                    if (d < min && !allStations.get(i).getList().isEmpty()) {
                        min = d;
                        index = i;
                        distance=min;
                    }

                }
            }
        }

    return index;

        }
    public double distanceKm(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0.0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit == "K") {
                dist = dist * 1.609344;
            } else if (unit == "N") {
                dist = dist * 0.8684;
            }
            return (dist);
        }

    }
    public void calculateWasteTime(){
        realTotalTimeWork=calDiff(scheduleTime.get(0).getLeavingTime(),finalSchedules.get(finalSchedules.size()-1).getScheduleTime().getLeavingTime());
        realTotalTimeWork=realTotalTimeWork*(numberBus);
        for(int j=0;j<allStations.size();j++){
            if(!allStations.get(j).getList().isEmpty()){
                for(int i=0;i<allStations.get(j).getList().size();i++){
                    Bus bus=allStations.get(j).getList().get(i);
                    allTimeBusWest=allTimeBusWest+calDiff(bus.getEndTrip(),finalSchedules.get(finalSchedules.size()-1).getScheduleTime().getLeavingTime());
                }}
        }


    }
    public List<Result> getResults() {
        return results;
    }
}
