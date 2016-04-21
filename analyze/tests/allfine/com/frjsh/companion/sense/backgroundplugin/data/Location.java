package com.frjsh.companion.sense.backgroundplugin.data;

import java.util.Date;

public class Location {
    private Float accuracy;
    private Float avgAcceleration;
    private Integer batteryLevel;
    private Float bearing;
    private Integer gsmQuality;
    // $FF: renamed from: id java.lang.Long
    private Long field_5218;
    private Boolean isAnchorAlarmActive;
    private Boolean isCharging;
    private Double latitude;
    private String logbook;
    private Double longitude;
    private Float maxAcceleration;
    private String nmea;
    private Date recordedAt;
    private Integer screenBrightness;
    private Float speed;

    public static Location fromAndroidLocation(android.location.Location var0) {
        Location var1 = new Location();
        if(var0 != null) {
            var1.setRecordedAt(new Date(var0.getTime()));
            var1.setLongitude(Double.valueOf(var0.getLongitude()));
            var1.setLatitude(Double.valueOf(var0.getLatitude()));
            var1.setAccuracy(Float.valueOf(var0.getAccuracy()));
            var1.setSpeed(Float.valueOf(var0.getSpeed()));
            var1.setBearing(Float.valueOf(var0.getBearing()));
        }

        return var1;
    }

    public Float getAccuracy() {
        return this.accuracy;
    }

    public Float getAvgAcceleration() {
        return this.avgAcceleration;
    }

    public Integer getBatteryLevel() {
        return this.batteryLevel;
    }

    public Float getBearing() {
        return this.bearing;
    }

    public Integer getGsmQuality() {
        return this.gsmQuality;
    }

    public Long getId() {
        return this.field_5218;
    }

    public Boolean getIsAnchorAlarmActive() {
        return this.isAnchorAlarmActive;
    }

    public Boolean getIsCharging() {
        return this.isCharging;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public String getLogbook() {
        return this.logbook;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public Float getMaxAcceleration() {
        return this.maxAcceleration;
    }

    public String getNMEA() {
        return this.nmea;
    }

    public Date getRecordedAt() {
        return this.recordedAt;
    }

    public Integer getScreenBrightness() {
        return this.screenBrightness;
    }

    public Float getSpeed() {
        return this.speed;
    }

    public void setAccuracy(Float var1) {
        this.accuracy = var1;
    }

    public void setAvgAcceleration(Float var1) {
        this.avgAcceleration = var1;
    }

    public void setBatteryLevel(Integer var1) {
        this.batteryLevel = var1;
    }

    public void setBearing(Float var1) {
        this.bearing = var1;
    }

    public void setGsmQuality(Integer var1) {
        this.gsmQuality = var1;
    }

    public void setId(Long var1) {
        this.field_5218 = var1;
    }

    public void setIsAnchorAlarmActive(Boolean var1) {
        this.isAnchorAlarmActive = var1;
    }

    public void setIsCharging(Boolean var1) {
        this.isCharging = var1;
    }

    public void setLatitude(Double var1) {
        this.latitude = var1;
    }

    public void setLogbook(String var1) {
        this.logbook = var1;
    }

    public void setLongitude(Double var1) {
        this.longitude = var1;
    }

    public void setMaxAcceleration(Float var1) {
        this.maxAcceleration = var1;
    }

    public void setNMEA(String var1) {
        this.nmea = var1;
    }

    public void setRecordedAt(Date var1) {
        this.recordedAt = var1;
    }

    public void setScreenBrightness(Integer var1) {
        this.screenBrightness = var1;
    }

    public void setSpeed(Float var1) {
        this.speed = var1;
    }
}
