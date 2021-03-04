package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TouristTicket {
    private final String PNR;
    private final String DEPARTURE_LOCATION;
    private final String DESTINATION_LOCATION; //making all these attributes final because once a ticket is booked
    private final String DEPARTURE_DATE_AND_TIME;// it can only be cancelled and not updated
    private final String DESTINATION_ARRIVAL_DATE_AND_TIME;
    private final String SEAT_NUMBER;
    private final float TICKET_PRICE;
    private final Flight flightDetails;
    private final Passenger passengerDetails;

    private enum TicketStatus {
        CONFIRMED, CANCELLED
    }

    private TicketStatus status;
    private String hotelAddress;
    private String[] selectedTouristLocations;

    public TouristTicket(String PNR, String DEPARTURE_LOCATION, String DESTINATION_LOCATION, String DEPARTURE_DATE_AND_TIME,
                         String DESTINATION_ARRIVAL_DATE_AND_TIME, String SEAT_NUMBER, float TICKET_PRICE, String hotelAddress,
                         String[] selectedTouristLocations,Flight flightDetails,Passenger passengerDetails) {
        this.PNR = PNR;
        this.DEPARTURE_LOCATION = DEPARTURE_LOCATION;
        this.DESTINATION_LOCATION = DESTINATION_LOCATION;
        this.DEPARTURE_DATE_AND_TIME = DEPARTURE_DATE_AND_TIME;
        this.DESTINATION_ARRIVAL_DATE_AND_TIME = DESTINATION_ARRIVAL_DATE_AND_TIME;
        this.SEAT_NUMBER = SEAT_NUMBER;
        this.TICKET_PRICE = TICKET_PRICE;
        this.hotelAddress = hotelAddress;
        this.status = TicketStatus.CONFIRMED;
        this.flightDetails = flightDetails;
        this.passengerDetails = passengerDetails;
        this.selectedTouristLocations = selectedTouristLocations;
        this.flightDetails.updateAvailableSeats();
    }

    public String getPNR() {
        return PNR;
    }

    public String getDEPARTURE_LOCATION() {
        return DEPARTURE_LOCATION;
    }

    public String getDESTINATION_LOCATION() {
        return DESTINATION_LOCATION;
    }

    public String getDEPARTURE_DATE_AND_TIME() {
        return DEPARTURE_DATE_AND_TIME;
    }

    public String getDESTINATION_ARRIVAL_DATE_AND_TIME() {
        return DESTINATION_ARRIVAL_DATE_AND_TIME;
    }

    public String getSEAT_NUMBER() {
        return SEAT_NUMBER;
    }

    public float getTICKET_PRICE() {
        return TICKET_PRICE;
    }

    public TicketStatus getTicketStatus() {
        return status;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public void setSelectedTouristLocations(String[] selectedTouristLocations) {
        this.selectedTouristLocations = selectedTouristLocations;
    }

    public void removeTouristLocation(String location) {
        for (String loc : this.selectedTouristLocations) {
            if (loc.equals(location)) {
                loc = null; // removing location by making it null
            }
        }
    }

    public void addTouristLocation(String location) {
        int nullCount = 0;
        for (String loc : this.selectedTouristLocations) {
            if (loc == null) nullCount++;
        }
        if (nullCount == selectedTouristLocations.length) {
            System.out.println("Already Selected 5 locations. Cannot add more location. Remove selected locations to add location");
        } else {
            for (String loc : this.selectedTouristLocations) {
                if (loc == null) {
                    loc = location;
                    break;
                }
            }
        }
    }

    public String getFlightDetails() {
        return this.flightDetails.getFlightDetails();
    }

    public String getPassengerDetails() {
        return this.passengerDetails.getPassengerDetails();
    }
    public String getSelectedTouristLocations() {
        return String.join(", ",this.selectedTouristLocations);
    }

    public void printSelectedTouristLocations() {
        System.out.println("Locations selected to visit are : ");
        for (String loc : this.selectedTouristLocations) {
            if (loc == null) continue;
            System.out.println(loc + "\n");
        }
    }

    public void cancelTicket() {
        this.status = TicketStatus.CANCELLED;
        this.flightDetails.decrementBookedSeats();
    }

    public void journeyDuration() { //code reference geeksforgeeks
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
        try {
            // parse method is used to parse
            // the text from a string to
            // produce the date
            Date d1 = sdf.parse(this.DEPARTURE_DATE_AND_TIME);
            Date d2 = sdf.parse(this.DESTINATION_ARRIVAL_DATE_AND_TIME);

            // Calculate time difference
            // in milliseconds
            RegularTicket.getDifferenceInTime(d1, d2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getTicketDetails(){
        return "PNR : "+ this.getPNR() + "\nDeparture : " + this.getDEPARTURE_LOCATION()+
                "\nDestination : "+ getDESTINATION_LOCATION() + "\nDepartureTime : "+
                this.getDEPARTURE_DATE_AND_TIME() + "\nDestinationArrivalTime : " +
                this.getDESTINATION_ARRIVAL_DATE_AND_TIME() + "\nSeat Number : " +
                this.getSEAT_NUMBER() + "\nTicketPrice : " + this.getTICKET_PRICE() +
                "\nHotel Location : "+this.getHotelAddress()+"\nSelected Locations : " + this.getSelectedTouristLocations() + "\nStatus : "+
                this.getTicketStatus();
    }

}
