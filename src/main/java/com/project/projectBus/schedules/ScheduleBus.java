package com.project.projectBus.schedules;

/**
 *
 * @author adhameldda
 */

public class ScheduleBus {

    private int id;
    private String company;
    private String clusterNumber;
    private String sku;
    private String lineNumber;
    private String direction;
    private String alternative;
    private String arranging;
    private String stationName;
    private String timeTrip;
    private String let_;
    private String long_;
    private String cityCode;
    private String cityName;
    private String status;
    private String areaCode;

    public ScheduleBus(String company, String clusterNumber, String sku, String lineNumber, String direction, String alternative, String arranging, String stationName,String timeTrip, String let_, String long_, String cityCode, String cityName, String status, String areaCode) {
        this.company = company;
        this.clusterNumber = clusterNumber;
        this.sku = sku;
        this.lineNumber = lineNumber;
        this.direction = direction;
        this.alternative = alternative;
        this.arranging = arranging;
        this.stationName = stationName;
        this.timeTrip = timeTrip;
        this.let_ = let_;
        this.long_ = long_;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.status = status;
        this.areaCode = areaCode;
    }
    public ScheduleBus(int id, String company, String clusterNumber, String sku, String lineNumber, String direction, String alternative, String arranging, String stationName,String timeTrip, String let_, String long_, String cityCode, String cityName, String status, String areaCode) {
        this.id = id;
        this.company = company;
        this.clusterNumber = clusterNumber;
        this.sku = sku;
        this.lineNumber = lineNumber;
        this.direction = direction;
        this.alternative = alternative;
        this.arranging = arranging;
        this.stationName = stationName;
        this.timeTrip = timeTrip;
        this.let_ = let_;
        this.long_ = long_;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.status = status;
        this.areaCode = areaCode;
    }

    public ScheduleBus(String title, String content) {
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
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

    public String getArranging() {
        return arranging;
    }

    public void setArranging(String arranging) {
        this.arranging = arranging;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
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

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTimeTrip() {
        return timeTrip;
    }

    public void setTimeTrip(String timeTrip) {
        this.timeTrip = timeTrip;
    }

    @Override
    public String toString() {
        return "scheduleBus{" +
                ", company='" + company + '\'' +
                ", clusterNumber='" + clusterNumber + '\'' +
                ", sku='" + sku + '\'' +
                ", lineNumber='" + lineNumber + '\'' +
                ", direction='" + direction + '\'' +
                ", alternative='" + alternative + '\'' +
                ", arranging='" + arranging + '\'' +
                ", stationName='" + stationName + '\'' +
                ", let_='" + let_ + '\'' +
                ", long_='" + long_ + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", status='" + status + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
