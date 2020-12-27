package com.fuels.visops.controller;

import com.fuels.visops.model.UserActivity;
import com.fuels.visops.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserActivityController {

    @Autowired
    UserActivityService userActivityService;

    @RequestMapping(method= RequestMethod.GET,value="/useractivities")
//    public ResponseEntity<List<UserActivity>> getAllUserActivitiesController() {
//         List<UserActivity> useractivitieslist = userActivityService.getAllUserActivities();
//         if (useractivitieslist.size()<=0){
//             return ResponseEntity.status(HttpStatus.OK).build();
//         }
//         return ResponseEntity.of(Optional.of(useractivitieslist));
//    }
    public ResponseEntity<?> getAllUserActivitiesController() {
        try {
            List<UserActivity> useractivitieslist = userActivityService.getAllUserActivities();
            return ResponseEntity.of(Optional.of(useractivitieslist));
        } catch(Exception e){
            e.printStackTrace();
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            return new ResponseEntity<String>( "Error: "+e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method= RequestMethod.GET,value="/useractivities/{userId}")
    public ResponseEntity<List<UserActivity>> getMatchingUseridUserActivityController(@PathVariable("userId") String userId) {
        try {
            List<UserActivity> useractivitylist = userActivityService.getMatchingUseridUserActivity(userId);
            if (useractivitylist.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(useractivitylist));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
