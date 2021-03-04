package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RegularTicket {
    private final String PNR;
    private final String DEPARTURE_LOCATION;
    private final String DESTINATION_LOCATION; //making all these attributes final because once a ticket is booked
    private final String DEPARTURE_DATE_AND_TIME;// it can only be cancelled and not updated
    private final String DESTINATION_ARRIVAL_DATE_AND_TIME;
    private final String SEAT_NUMBER;
    private final float TICKET_PRICE;

    private enum TicketStatus {
        CONFIRMED, CANCELLED
    }

    private TicketStatus status;
    private String specialServices;

    public RegularTicket(String PNR, String DEPARTURE_LOCATION, String DESTINATION_LOCATION,
                         String DEPARTURE_DATE_AND_TIME, String DESTINATION_ARRIVAL_DATE_AND_TIME, String SEAT_NUMBER,
                         float TICKET_PRICE, String specialServices) {
        this.PNR = PNR;
        this.DEPARTURE_LOCATION = DEPARTURE_LOCATION;
        this.DESTINATION_LOCATION = DESTINATION_LOCATION;
        this.DEPARTURE_DATE_AND_TIME = DEPARTURE_DATE_AND_TIME;
        this.DESTINATION_ARRIVAL_DATE_AND_TIME = DESTINATION_ARRIVAL_DATE_AND_TIME;
        this.SEAT_NUMBER = SEAT_NUMBER;
        this.TICKET_PRICE = TICKET_PRICE;
        this.specialServices = specialServices;
        this.status = TicketStatus.CONFIRMED; //When a ticket object is initialized it is confirmed

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


    public String getSpecialServices() {
        return specialServices;
    }

    public void setSpecialServices(String specialServices) {
        this.specialServices = specialServices;
    }

    public void cancelTicket() {
        this.status = TicketStatus.CANCELLED;
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
            getDifferenceInTime(d1, d2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getDifferenceInTime(Date d1, Date d2) {
        long difference_In_Time = d2.getTime() - d1.getTime();
        long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
        long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
        long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
        System.out.println("Journey Duration : " + difference_In_Days + " Days, " + difference_In_Hours + " Hours, "
                + difference_In_Minutes + " Minutes");
    }

    public TicketStatus getTicketStatus() {
        return this.status;
    }

    public String getTicketDetails(){
        return "PNR : "+ this.getPNR() + "\nDeparture : " + this.getDEPARTURE_LOCATION()+
                "\nDestination : "+ getDESTINATION_LOCATION() + "\nDepartureTime : "+
                this.getDEPARTURE_DATE_AND_TIME() + "\nDestinationArrivalTime : " +
                this.getDESTINATION_ARRIVAL_DATE_AND_TIME() + "\nSeat Number : " +
                this.getSEAT_NUMBER() + "\nTicketPrice : " + this.getTICKET_PRICE() +
                "\nSpecial Services : "+this.getSpecialServices()+ "\nStatus : "+ this.getTicketStatus();
    }
}
