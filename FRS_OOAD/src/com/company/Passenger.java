package com.company;

public class Passenger {
    private final int ID;
    private String name;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String state;

    public Passenger(int ID, String name, String phone, String email, String street, String city, String state) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddressDetails() {
        return "Street : " + this.getStreet() + "\nCity : " + this.getCity() + "\nState : " + this.getState();
    }

    public String getContactDetails() {
        return "Name : " + this.getName() + "\nPhone : " + this.getPhone() + "\nEmail : " + this.getEmail();
    }
}
