package com.parkit.parkingsystem.service;

import java.time.Instant;
import java.util.Date;

public class TimeConvertor {

    // Conversion de millisecondes en heures avec précision
    public static double getHoursFromMilliseconds(long milliseconds) {
        return (double) milliseconds / 1000 / 60 / 60;
    }

    // Conversion de minutes en heures
    public static double getHoursFromMinutes(float minutes) {
        return (double) minutes / 60;
    }

    // Conversion de secondes en heures
    public static double getHoursFromSeconds(float seconds) {
        return (double) seconds / 60 / 60;
    }

    // Conversion de millisecondes en heures arrondies
    public static int getRoundedHoursFromMilliseconds(long milliseconds) {
        return (int) (milliseconds / 1000 / 60 / 60);
    }

    // Conversion de minutes en heures arrondies
    public static int getRoundedHoursFromMinutes(float minutes) {
        return (int) (minutes / 60);
    }

    // Conversion de secondes en heures arrondies
    public static int getRoundedHoursFromSeconds(float seconds) {
        return (int) (seconds / 60 / 60);
    }

    // Conversion Date vers Instant
    public static Instant dateToInstant(Date date) {
        return date.toInstant();
    }

    // Conversion Instant vers Date
    public static Date instantToDate(Instant instant) {
        return Date.from(instant);
    }
}
