package com.project.projectBus.schedules;
/**
 *
 * @author adhameldda
 */

import java.sql.Time;
import java.util.Comparator;

public class ScheduleTime  {


    private int id;
    private String company ;
    private String clusterNumber;
    private String cluster ;
    private String subCluster  ;
    private String region ;
    private String sku  ;
    private String linenumber ;
    private String direction ;
    private String alternative ;
    private String signage   ;
    private Time leavingTime  ;

    public ScheduleTime(int id, String company, String clusterNumber, String cluster, String subCluster, String region, String sku, String linenumber, String direction, String alternative, String signage, Time leavingTime) {
        this.id = id;
        this.company = company;
        this.clusterNumber = clusterNumber;
        this.cluster = cluster;
        this.subCluster = subCluster;
        this.region = region;
        this.sku = sku;
        this.linenumber = linenumber;
        this.direction = direction;
        this.alternative = alternative;
        this.signage = signage;
        this.leavingTime = leavingTime;
    }

    public ScheduleTime(String company, String clusterNumber, String cluster, String subCluster, String region, String sku, String linenumber, String direction, String alternative, String signage, Time leavingTime) {
        this.company = company;
        this.clusterNumber = clusterNumber;
        this.cluster = cluster;
        this.subCluster = subCluster;
        this.region = region;
        this.sku = sku;
        this.linenumber = linenumber;
        this.direction = direction;
        this.alternative = alternative;
        this.signage = signage;
        this.leavingTime = leavingTime;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getClusterNumber() {
        return clusterNumber;
    }

    public void setClusterNumber(String clusterNumber) {
        this.clusterNumber = clusterNumber;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getSubCluster() {
        return subCluster;
    }

    public void setSubCluster(String subCluster) {
        this.subCluster = subCluster;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(String linenumber) {
        this.linenumber = linenumber;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getSignage() {
        return signage;
    }

    public void setSignage(String signage) {
        this.signage = signage;
    }

    public Time getLeavingTime() {
        return leavingTime;
    }

    public void setLeavingTime(Time leavingTime) {
        this.leavingTime = leavingTime;
    }

    @Override
    public String toString() {
        return "ScheduleTime{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", clusterNumber='" + clusterNumber + '\'' +
                ", cluster='" + cluster + '\'' +
                ", subCluster='" + subCluster + '\'' +
                ", region='" + region + '\'' +
                ", sku='" + sku + '\'' +
                ", linenumber='" + linenumber + '\'' +
                ", direction='" + direction + '\'' +
                ", alternative='" + alternative + '\'' +
                ", signage='" + signage + '\'' +
                ", leavingTime='" + leavingTime + '\'' +
                '}';
    }



}
