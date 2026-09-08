package com.example.issacsmedtracker.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.issacsmedtracker.data.entity.ScheduleEntity;

import java.util.List;

@Dao
public interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ScheduleEntity schedule);

    @Update
    void update(ScheduleEntity schedule);

    @Query("SELECT * FROM schedules ORDER BY id")
    List<ScheduleEntity> getAll();

    @Query("SELECT * FROM schedules WHERE id = :id LIMIT 1")
    ScheduleEntity getById(int id);
}