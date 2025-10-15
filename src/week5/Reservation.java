/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Reservation {

    private String bookingId;
    private String customerName;
    private String phoneNumber;
    private int roomNumber;
    private LocalDate dateTime;
    private FlightInformation flightInformation;

    public Reservation() {
        this.bookingId = "";
        this.customerName = "";
        this.phoneNumber = "";
        this.roomNumber = 0;
        this.dateTime = LocalDate.now();
    }

    public Reservation(String bookingId, String customerName, String phoneNumber, int roomNumber, LocalDate dateTime, FlightInformation flightInformation) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.dateTime = dateTime;
        this.flightInformation = flightInformation;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }

    @Override
    public String toString() {
        return bookingId +" - "+ customerName +" - "+ phoneNumber +" - "+ roomNumber  +" - "+ dateTime +" - "+ flightInformation +" - "+flightInformation.toString();
    }

}
