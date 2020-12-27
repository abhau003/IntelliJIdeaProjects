package com.fuels.visops.model;

import java.util.Date;

public class UserActivity {

    int useractivityid;
    int activityid;
    String storeid;
    String createdby;
    Date createtime;
    String traceabilityid;
    String oldvalue;
    String newvalue;

    public UserActivity(){

    }
    public UserActivity(int useractivityid, int activityid, String storeid, String createdby, Date createtime, String traceabilityid, String oldvalue, String newvalue) {
        this.useractivityid = useractivityid;
        this.activityid = activityid;
        this.storeid = storeid;
        this.createdby = createdby;
        this.createtime = createtime;
        this.traceabilityid = traceabilityid;
        this.oldvalue = oldvalue;
        this.newvalue = newvalue;
    }

    public int getUseractivityid() {
        return useractivityid;
    }

    public void setUseractivityid(int useractivityid) {
        this.useractivityid = useractivityid;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getTraceabilityid() {
        return traceabilityid;
    }

    public void setTraceabilityid(String traceabilityid) {
        this.traceabilityid = traceabilityid;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String getNewvalue() {
        return newvalue;
    }

    public void setNewvalue(String newvalue) {
        this.newvalue = newvalue;
    }


}
