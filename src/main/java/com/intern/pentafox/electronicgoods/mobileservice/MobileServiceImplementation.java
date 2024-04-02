package com.intern.pentafox.electronicgoods.mobileservice;

import com.intern.pentafox.electronicgoods.mobileentity.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MobileServiceImplementation implements MobileService{
    @Autowired private JdbcTemplate jdbcTemplate;
    RowMapper rowMapper =(rs ,rowNum)->new Mobile(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getDouble("price"),
            rs.getString("colour")
    );
    @Override
    public List<Mobile> getallMobiles() {
        var sql="SELECT * FROM mobile";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Mobile getMobileById(int id) {
        var sql = "SELECT * FROM mobile WHERE id=?";
        return(Mobile) jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    @Override
    public Mobile getMobileByName(String name) {
        var sql ="SELECT * FROM mobile WHERE name=?";
        return (Mobile) jdbcTemplate.queryForObject(sql, new Object[]{name}, rowMapper);
    }

    @Override
    public void createMobiles(Mobile mobile) {
        var sql="INSERT INTO mobile (id , name , price , colour) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, mobile.getId(),mobile.getName(),mobile.getPrice(),mobile.getColour());

    }

    @Override
    public void updateMobile(int id, Mobile mobile) {
      var sql= "update mobile SET name=? , price=? ,colour=? WHERE id=?";
      jdbcTemplate.update(sql,mobile.getName(), mobile.getPrice(),mobile.getColour(),id);
    }


    @Override
    public void deleteMobileById( int id) {
        var sql="delete FROM mobile WHERE id=?";
        jdbcTemplate.update(sql,id);

    }
}
