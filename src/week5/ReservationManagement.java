/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ReservationManagement {

    private final List<Reservation> reservations = new ArrayList<>();

    public boolean isUniqueId(String id) {
        for (Reservation r : reservations) {
            if (r.getBookingId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean createReservation(Reservation newRes) {
        if (newRes == null) {
            return false;
        }
        if (!isUniqueId(newRes.getBookingId())) {
            return false;
        }
        reservations.add(newRes);
        return true;
    }

    public boolean updateReservation(String bookingId, Reservation updatedRes) {
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            if (r.getBookingId().equals(bookingId)) {
                reservations.set(i, updatedRes);
                return true;
            }
        }
        return false;
    }

    public boolean deleteReservation(String bookingId) {
        return reservations.removeIf(r -> r.getBookingId().equals(bookingId));
    }

    public List<FlightInformation> getAllFlightInformation() {
        List<FlightInformation> flights = new ArrayList<>();
        for (Reservation r : reservations) {
            flights.add(r.getFlightInformation());
        }
        return flights;
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }

    public Reservation findReservationById(String bookingId) {
        for (Reservation r : reservations) {
            if (r.getBookingId().equals(bookingId)) {
                return r;
            }
        }
        return null;
    }

    public void clearAll() {
        reservations.clear();
    }
}
