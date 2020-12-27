package com.fuels.visops.service;

import com.fuels.visops.model.UserActivity;
import com.fuels.visops.model.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityService {

    @Autowired
    UserActivityRepository userActivityRepository;

    public List<UserActivity> getAllUserActivities(){
        return (List<UserActivity>) userActivityRepository.readAllUserAcitivities();
    }

    public List<UserActivity> getMatchingUseridUserActivity(String userId){
        return (List<UserActivity>) userActivityRepository.readMatchingUseridUserAcitivity(userId);
    }
}
