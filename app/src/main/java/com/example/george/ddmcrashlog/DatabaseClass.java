package com.example.george.ddmcrashlog;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {DataModel.class}, version = 1, exportSchema = false)
public abstract class DatabaseClass extends RoomDatabase {
    public abstract DataModel.DaoAccess daoAccess() ;
}