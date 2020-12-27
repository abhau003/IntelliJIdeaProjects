package com.fuels.visops.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserActivityRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserActivityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String ALL_USER_ACTIVITIES_SQL = "select * from User_Activity";
    private final String MATCHINGUSERID_USER_ACTIVITIES_SQL = "select * from User_Activity where createdby = ?";

    public List<UserActivity> readAllUserAcitivities() {
        
        return (List<UserActivity>) jdbcTemplate.query(ALL_USER_ACTIVITIES_SQL, new BeanPropertyRowMapper<UserActivity>(UserActivity.class));
    }

    public List<UserActivity> readMatchingUseridUserAcitivity(String userId){
        return (List<UserActivity>) jdbcTemplate.query(MATCHINGUSERID_USER_ACTIVITIES_SQL, new BeanPropertyRowMapper<UserActivity>(UserActivity.class), userId);
    }
}
