package com.example.issacsmedtracker.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalTime;

@Entity(tableName = "schedules")
public class ScheduleEntity {

    @PrimaryKey
    private int id;

    @NonNull
    private String label;

    @NonNull
    private LocalTime time;

    private boolean enabled;


    public ScheduleEntity(
            int id,
            @NonNull String label,
            @NonNull LocalTime time,
            boolean enabled
    ) {
        this.id = id;
        this.label = label;
        this.time = time;
        this.enabled = enabled;
    }


    public int getId() {
        return id;
    }

    @NonNull
    public String getLabel() {
        return label;
    }

    @NonNull
    public LocalTime getTime() {
        return time;
    }

    public boolean isEnabled() {
        return enabled;
    }


    public void setTime(@NonNull LocalTime time) {
        this.time = time;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}