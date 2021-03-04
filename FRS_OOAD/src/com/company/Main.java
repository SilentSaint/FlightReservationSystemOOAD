package com.company;


import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        // Object creation of all the classes

        Passenger passenger = new Passenger( "Rakshith", "7019032719", "rakshithg35@gmail",
                "4th Cross", "Bengaluru", "Karnataka");
        Passenger passenger2 = new Passenger( "Rakshitha", "7019032713", "rakshithag35@gmail",
                "4th Cross", "Bengaluru", "Karnataka");

        Flight flightRegular = new Flight("Air India",100);
        Flight flightTourist = new Flight("Deccan Airline",100);

        RegularTicket regularTicket = new RegularTicket("AB7DE", "Bengaluru",
                "Delhi", "03-03-2021 01:10:20",
                "04-03-2021 02:20:40", "A8", 2209.50f,
                "food, water, snacks",flightRegular,passenger);

        TouristTicket touristTicket = new TouristTicket("A97DX", "Bengaluru",
                "New York", "03-03-2021 01:10:20",
                "05-03-2021 04:20:40", "A8",5000.0f,
                "DelhiHotel",new String[]{"Taj Mahal","Qutab Minar","Jantar Mantar"},flightTourist,passenger2);


        //test cases

        // flightRegular.FLIGHT_ID; not accessible

        System.out.println("Flight id "+flightRegular.getFLIGHT_ID()); //accessed flightId using getter

        //Regular Ticket details
        System.out.println("Passenger Details ");
        System.out.println(regularTicket.getPassengerDetails());
        System.out.println("\n");
        System.out.println("Flight Details");
        System.out.println(regularTicket.getFlightDetails());
        System.out.println("\n");
        System.out.println("Ticket Details");
        System.out.println(regularTicket.getTicketDetails());
        System.out.println("\n");
        System.out.println("Number of Regular tickets booked " + flightRegular.getBookedSeats()); //1
        System.out.println("Number of Regular tickets available " + flightRegular.numberOfSeatsAvailable()); //99

        System.out.println("\n");
        //Tourist Ticket details
        System.out.println("Tourist Details ");
        System.out.println(touristTicket.getPassengerDetails());
        System.out.println("\n");
        touristTicket.cancelTicket(); // cancelling ticket
        System.out.println("Flight Details");
        System.out.println(touristTicket.getFlightDetails());
        System.out.println("\n");
        System.out.println("Ticket Details");
        System.out.println(touristTicket.getTicketDetails());
        System.out.println("\n");
        System.out.println("Number of Tourist tickets booked " + flightTourist.getBookedSeats()); //0 Since ticket got cancelled
        System.out.println("Number of Tourist tickets available " + flightTourist.numberOfSeatsAvailable());// 100

    }
}
