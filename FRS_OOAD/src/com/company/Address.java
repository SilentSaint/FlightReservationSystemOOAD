package com.company;

public class Address {
    private String street;
    private String city;
    private String state;

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
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

    public void updateAddressDetails(Address address) {
        setCity(address.city);
        setState(address.state);
        setState(address.street);
    }
}
