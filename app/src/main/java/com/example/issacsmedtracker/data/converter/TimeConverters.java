package com.example.issacsmedtracker.data.converter;

import androidx.room.TypeConverter;

import java.time.LocalTime;

public class TimeConverters {

    @TypeConverter
    public static Integer fromLocalTime(LocalTime time) {
        if (time == null) {
            return null;
        }

        return time.getHour() * 60 + time.getMinute();
    }

    @TypeConverter
    public static LocalTime toLocalTime(Integer minutes) {
        if (minutes == null) {
            return null;
        }

        return LocalTime.of(
                minutes / 60,
                minutes % 60
        );
    }
}