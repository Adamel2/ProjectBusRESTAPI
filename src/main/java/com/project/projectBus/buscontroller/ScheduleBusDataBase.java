package com.project.projectBus.buscontroller;

import com.project.projectBus.database.ScheduleRepositoryForDataBus;
import com.project.projectBus.schedules.ScheduleBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 *
 * @author adhameldda
 */

@Component
@Repository
public class ScheduleBusDataBase implements ScheduleRepositoryForDataBus {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(ScheduleBus scheduleBus) {

        return jdbcTemplate.update("insert into data (company,clusternumber,sku,linenumber,direction,alternative,arranging,stationname,timetrip,let_,long_,citycode,cityname,status,areacode) "
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{
                scheduleBus.getCompany(), scheduleBus.getClusterNumber(),
                scheduleBus.getSku(), scheduleBus.getLineNumber(), scheduleBus.getDirection(),
                scheduleBus.getAlternative(), scheduleBus.getArranging(), scheduleBus.getStationName(),
                scheduleBus.getLet_(), scheduleBus.getLong_(), scheduleBus.getCityCode(),
                scheduleBus.getCityName(), scheduleBus.getStatus(), scheduleBus.getAreaCode()});
    }
    @Override
    public ScheduleBus findByScheduleBusId(int id) {

        String sql="SELECT * FROM data where id = '" + id + "'";
        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) ->
                        new ScheduleBus(
                                rs.getInt("id"),
                                rs.getString("company"),
                                rs.getString("clusternumber"),
                                rs.getString("sku"),
                                rs.getString("linenumber"),
                                rs.getString("direction"),
                                rs.getString("alternative"),
                                rs.getString("arranging"),
                                rs.getString("stationname"),
                                rs.getString("timetrip"),
                                rs.getString("let_"),
                                rs.getString("long_"),
                                rs.getString("citycode"),
                                rs.getString("cityname"),
                                rs.getString("status"),
                                rs.getString("areacode")
                        )
        );
    }
    @Override
    public List<ScheduleBus> findAll() {

        String sql="SELECT * FROM data;";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new ScheduleBus(
                                rs.getInt("id"),
                                rs.getString("company"),
                                rs.getString("clusternumber"),
                                rs.getString("sku"),
                                rs.getString("linenumber"),
                                rs.getString("direction"),
                                rs.getString("alternative"),
                                rs.getString("arranging"),
                                rs.getString("stationname"),
                                rs.getString("timetrip"),
                                rs.getString("let_"),
                                rs.getString("long_"),
                                rs.getString("citycode"),
                                rs.getString("cityname"),
                                rs.getString("status"),
                                rs.getString("areacode")
                        )
                        );

    }
    @Override
    public int count() {

        return jdbcTemplate.queryForObject("select count(*) from data", Integer.class);
    }
    @Override
    public List<ScheduleBus> findByScheduleBusNumberLine(String numberLine) {
        String sql = "SELECT * FROM data WHERE linenumber ='" + numberLine + "'";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new ScheduleBus(
                                rs.getInt("id"),
                                rs.getString("company"),
                                rs.getString("clusternumber"),
                                rs.getString("sku"),
                                rs.getString("linenumber"),
                                rs.getString("direction"),
                                rs.getString("alternative"),
                                rs.getString("arranging"),
                                rs.getString("stationname"),
                                rs.getString("timetrip"),
                                rs.getString("let_"),
                                rs.getString("long_"),
                                rs.getString("citycode"),
                                rs.getString("cityname"),
                                rs.getString("status"),
                                rs.getString("areacode")
                        )
        );
    }
    @Override
    public List<String> getNumberLine(){

        String sql ="SELECT DISTINCT linenumber FROM data;";
            return jdbcTemplate.query(
                    sql,
                    (rs, rowNum) ->
                            new String(
                                    rs.getString("linenumber")
                            )
            );




    }
    @Override
    public List<String> getStations(){

        String sql ="SELECT DISTINCT stationname FROM data;";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new String(
                                rs.getString("stationname")
                        )
        );




    }



}
