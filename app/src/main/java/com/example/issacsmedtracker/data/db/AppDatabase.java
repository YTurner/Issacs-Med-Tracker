package com.example.issacsmedtracker.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                    ).addCallback(createCallback).build();
                }
            }
        }

        return INSTANCE;
    }

    private static final RoomDatabase.Callback createCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    db.execSQL(
                            "INSERT INTO schedules (id, label, time, enabled) " +
                                    "VALUES (1, 'AllergyX pill', 600, 1)"
                    );

                    db.execSQL(
                            "INSERT INTO schedules (id, label, time, enabled) " +
                                    "VALUES (2, 'Morning spray', 600, 1)"
                    );

                    db.execSQL(
                            "INSERT INTO schedules (id, label, time, enabled) " +
                                    "VALUES (3, 'Evening spray', 1320, 1)"
                    );
                }
            };
}