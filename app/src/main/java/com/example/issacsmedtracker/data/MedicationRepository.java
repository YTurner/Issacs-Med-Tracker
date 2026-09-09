package com.example.issacsmedtracker.data;

import android.content.Context;

import com.example.issacsmedtracker.data.dao.ScheduleDao;
import com.example.issacsmedtracker.data.db.AppDatabase;
import com.example.issacsmedtracker.data.entity.ScheduleEntity;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MedicationRepository {

    private final ScheduleDao scheduleDao;

    private static final ExecutorService databaseExecutor =
            Executors.newSingleThreadExecutor();
    public MedicationRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        scheduleDao = database.scheduleDao();
    }

    public void updateSchedule(ScheduleEntity schedule) {
        databaseExecutor.execute(() ->
                scheduleDao.update(schedule)
        );
    }
}