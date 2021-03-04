package com.company;


public class Main {

    public static void main(String[] args) {

        // Object creation of all the classes

        Address address = new Address("4th Cross", "Bengaluru", "Karnataka");

        Contact contact = new Contact("Rakshith", "7019032719", "rakshithg35@gmail");

        Passenger passenger = new Passenger(1, "Rakshith", "7019032719", "rakshithg35@gmail",
                "4th Cross", "Bengaluru", "Karnataka");

        Flight flight = new Flight("Air India",100);

        RegularTicket regularTicket = new RegularTicket("AB7DE", "Bengaluru",
                "Delhi", "03-03-2021 01:10:20",
                "04-03-2021 02:20:40", "A8", 2209.50f,
                "food, water, snacks");

        TouristTicket touristTicket = new TouristTicket("A97DX", "Bengaluru",
                "New York", "03-03-2021 01:10:20",
                "05-03-2021 04:20:40", "A8",5000.0f,
                "DelhiHotel",new String[]{"Taj Mahal","Qutab Minar","Jantar Mantar"});

        // printing the passenger details
        System.out.println("Passenger Address Details");
        System.out.println(passenger.getAddressDetails());

        System.out.println();
        System.out.println();

        System.out.println("Passenger Contact Details");
        System.out.println(passenger.getContactDetails());

        System.out.println();
        System.out.println();
        //contact and address classes print the same output
        //Address class
        System.out.println("Printing Address class");
        System.out.println(address.getAddressDetails());

        System.out.println();
        System.out.println();
        //Contact Class
        System.out.println("Printing Contact class");
        System.out.println(contact.getContactDetails());

        System.out.println();
        System.out.println();
        // Flight details
        System.out.println("Flight details");
        System.out.println(flight.getFlightDetails());

        System.out.println();
        System.out.println();
        //Regular Ticket
        System.out.println("Regular Ticket Details");
        System.out.println(regularTicket.getTicketDetails());
        regularTicket.journeyDuration();

        System.out.println();
        System.out.println();
        //Tourist Ticket
        System.out.println("Tourist Ticket Details");
        System.out.println(touristTicket.getTicketDetails());
        touristTicket.journeyDuration();


        /* Other methods initial implementation has been done
        but cant be used/printed now because the associations between classes has
        not been established yet.
         */
    }
}
