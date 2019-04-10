package com.example.george.ddmcrashlog;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.NonNull;
import java.util.List;
import java.util.jar.Attributes;

@Entity(tableName = "crash_log")
public class DataModel {
    @NonNull
    @PrimaryKey

    @ColumnInfo(name = "crash_id")
    public String crashIDNumber;
    @ColumnInfo(name = "crash_location")
    public String crashLocation;
    @ColumnInfo(name = "num_crashes")
    public String numOfCrashes;
    @ColumnInfo(name = "num_affected")
    public String numOfUsersAffected;
    @ColumnInfo(name = "device_name")
    public String deviceName;
    @ColumnInfo(name = "app_version")
    public String appVersion;
    @ColumnInfo(name = "os_version")
    public String osVersion;


    public DataModel() { }

    public String getCrashIDNumber() {
        return crashIDNumber;
    }
    public void setCrashIdNumber(@NonNull String crashIDNumber) {
        this.crashIDNumber = crashIDNumber;
    }
    public String getCrashLocation() {
        return crashLocation;
    }
    public void setCrashLocation (String crashLocation) {
        this.crashLocation = crashLocation;
    }
    public String getNumOfCrashes() {
        return numOfCrashes;
    }
    public void setNumOfCrashes (String numOfCrashes) {
        this.numOfCrashes = numOfCrashes;
    }
    public String getNumOfUsersAffected() {
        return numOfUsersAffected;
    }
    public void setNumOfUsersAffected (String numOfUsersAffected) {
        this.numOfUsersAffected = numOfUsersAffected;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName (String deviceName) {
        this.deviceName = deviceName;
    }
    public String getAppVersion() {
        return appVersion;
    }
    public void setAppVersion (String appVersion) {
        this.appVersion = appVersion;
    }
    public String getOsVersion() {
        return osVersion;
    }
    public void setOsVersion (String osVersion) {
        this.osVersion = osVersion;
    }

    @Dao
    public interface DaoAccess {

        @Insert
        void insertCrashIdNumber (DataModel crashId);
        @Insert
        void insertMultipleCrashIdNumbers (List<DataModel> crashIdList);
        @Query("SELECT * FROM crash_log WHERE crash_id= :crashIdNumber")
        DataModel fetchCrashIDNumber (int crashIdNumber);
        @Update
        void updateUser (DataModel crashId);
        @Delete
        void deleteCrashId (DataModel crashId);
    }
}

