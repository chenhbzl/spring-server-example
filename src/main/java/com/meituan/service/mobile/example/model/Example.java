package com.meituan.service.mobile.example.model;

import java.util.Date;

public class Example {

    String udid;
    String did;
    String appnm;
    String source;
    Date activeTime;
    Date comfireTime;
    int verified;

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getAppnm() {
        return appnm;
    }

    public void setAppnm(String appnm) {
        this.appnm = appnm;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getComfireTime() {
        return comfireTime;
    }

    public void setComfireTime(Date comfireTime) {
        this.comfireTime = comfireTime;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

}
