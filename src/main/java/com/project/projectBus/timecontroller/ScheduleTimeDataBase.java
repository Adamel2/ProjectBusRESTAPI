package com.project.projectBus.timecontroller;

import com.project.projectBus.database.ScheduleRepositoryForDataTime;
import com.project.projectBus.schedules.ScheduleTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.sql.Time;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
@Repository
public class ScheduleTimeDataBase implements ScheduleRepositoryForDataTime {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(ScheduleTime scheduleTime) {

        return jdbcTemplate.update("insert into data2 (company,clusternumber," +
                "cluster,subcluster,region,sku,linenumber,direction,alternative,signage,leavingtime) "
                + " values (?,?,?,?,?,?,?,?,?,?,?)", new Object[]{
                scheduleTime.getCompany(), scheduleTime.getClusterNumber(), scheduleTime.getCluster()
                , scheduleTime.getSubCluster(), scheduleTime.getRegion(), scheduleTime.getSku(), scheduleTime.getLinenumber()
                , scheduleTime.getDirection(), scheduleTime.getAlternative(), scheduleTime.getSignage(), scheduleTime.getLeavingTime()});
    }
    public ScheduleTime findByScheduleBusId(int id) {

        String sql = "SELECT * FROM data2 where id = '" + id + "'";
        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) ->
                        new ScheduleTime(
                                rs.getInt("id"),
                                rs.getString("company"),
                                rs.getString("clusternumber"),
                                rs.getString("cluster"),
                                rs.getString("subcluster"),
                                rs.getString("region"),
                                rs.getString("sku"),
                                rs.getString("linenumber"),
                                rs.getString("direction"),
                                rs.getString("alternative"),
                                rs.getString("signage"),
                                rs.getTime("leavingtime")

                        )
        );
    }
    public List<ScheduleTime> findAll() {
        String sql = "SELECT * FROM data2;";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new ScheduleTime(
                                rs.getInt("id"),
                                rs.getString("company"),
                                rs.getString("clusternumber"),
                                rs.getString("cluster"),
                                rs.getString("subcluster"),
                                rs.getString("region"),
                                rs.getString("sku"),
                                rs.getString("linenumber"),
                                rs.getString("direction"),
                                rs.getString("alternative"),
                                rs.getString("signage"),
                                rs.getTime("leavingtime")
                        )
        );

    }
    public int count() {

        return jdbcTemplate.queryForObject("select count(*) from data2", Integer.class);
    }
    @Override
    public List<ScheduleTime> findByScheduleBusNumberLine(String lineNumber) {

        String sql = "SELECT * FROM data2 WHERE linenumber = '"+lineNumber+"'";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new ScheduleTime(
                                rs.getInt("id"),
                                rs.getString("company"),
                                rs.getString("clusternumber"),
                                rs.getString("cluster"),
                                rs.getString("subcluster"),
                                rs.getString("region"),
                                rs.getString("sku"),
                                rs.getString("linenumber"),
                                rs.getString("direction"),
                                rs.getString("alternative"),
                                rs.getString("signage"),
                                rs.getTime("leavingtime")
                        )
        );
    }
}
