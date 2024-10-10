package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

import java.time.Duration;
import java.time.Instant;



public class FareCalculatorService {

    public void calculateFare(Ticket ticket){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

        long getInTimeMS = ticket.getInTime().getTime();
        long getOutTimeMS = ticket.getOutTime().getTime();


        // Convertir les dates en Instant
        Instant inTimeInstant = TimeConvertor.dateToInstant(ticket.getInTime());
        Instant outTimeInstant = TimeConvertor.dateToInstant(ticket.getOutTime());

        // Calculer la durée entre les deux dates en heures
        Duration duration = Duration.between(inTimeInstant, outTimeInstant);

        double durationInHours = (double) duration.toMinutes() / 60;

        switch (ticket.getParkingSpot().getParkingType()){
            case CAR: {
                ticket.setPrice(durationInHours * Fare.CAR_RATE_PER_HOUR);
                break;
            }
            case BIKE: {
                ticket.setPrice(durationInHours * Fare.BIKE_RATE_PER_HOUR);
                break;
            }
            default: throw new IllegalArgumentException("Unkown Parking Type");
        }
    }
}