package ua.com.ukrelektro.flight.object;

import ua.com.ukrelektro.flight.rs.Place;

public class ExtPlace extends Place{

    @Override
    public String toString() {
        return seatLetter+String.valueOf(seatNumber);
    }

    
    
}
