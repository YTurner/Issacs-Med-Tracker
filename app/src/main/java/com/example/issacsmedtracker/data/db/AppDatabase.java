package com.example.issacsmedtracker.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.issacsmedtracker.data.converter.TimeConverters;
import com.example.issacsmedtracker.data.dao.ScheduleDao;
import com.example.issacsmedtracker.data.entity.ScheduleEntity;

@Database(
        entities = {ScheduleEntity.class},
        version = 1,
        exportSchema = false
)
@TypeConverters({TimeConverters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract ScheduleDao scheduleDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "med_tracker_database"
                    ).build();
                }
            }
        }

        return INSTANCE;
    }
}