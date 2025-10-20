/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class testReservation {

    public static void main(String[] args) {

        ReservationManagement rm = new ReservationManagement();
        String[] menu = {
            "Create new reservation",
            "Update reservation",
            "Delete reservation",
            "Print Flight Information",
            "Print all",
            "Exit"
        };

        int choice;
        do {
            choice = Validate.menu("*** Reservation Management ***", menu);

            switch (choice) {
                case 1 -> {
                    System.out.println("*** Create new reservation ***");

                    String id = Validate.isValidID("ID: ");
                    String name = Validate.inputName("Name: ");
                    String phone = Validate.isPhone("Phone: ");
                    int room = Validate.isRoomNumber("RoomNumbers: ");
                    LocalDate bookingDate = Validate.inputBookingDate("BookingDate (dd/MM/yyyy): ");

                    boolean pickUp;
                    while (true) {
                        System.out.print("Need airport pick up? (Y/N): ");
                        String ans = Validate.sc.nextLine().trim();
                        if (ans.equalsIgnoreCase("Y")) {
                            pickUp = true;
                            break;
                        } else if (ans.equalsIgnoreCase("N")) {
                            pickUp = false;
                            break;
                        }
                        System.out.println("Data input is invalid!!!");
                    }

                    String flight = "";
                    String seat = "";
                    LocalDateTime timePickUp = null;

                    if (pickUp) {
                        flight = Validate.inputFlightNumber("Flight: ");
                        seat = Validate.inputSeatNumber("Seat: ");
                        timePickUp = Validate.inputTimePickUp("TimePickUp (dd/MM/yyyy hh:mma): ", bookingDate);
                    }

                    FlightInformation fi = new FlightInformation(flight, seat, timePickUp);
                    Reservation r = new Reservation(id, name, phone, room, bookingDate, fi);
                    rm.createReservation(r);
                    System.out.println("Information saved successfully.");
                }

                case 2 -> {
                    System.out.println("*** Update reservation ***");
                    System.out.print("bookingID: ");
                    String id = Validate.sc.nextLine().trim();
                    Reservation found = rm.findReservationById(id);

                    while (found == null) {
                        System.out.println("No information found");
                        System.out.print("You want to find again? (Y/N): ");
                        String again = Validate.sc.nextLine().trim();
                        if (again.equalsIgnoreCase("N")) {
                            break;
                        }
                        id = Validate.isValidID("ID: ");
                        found = rm.findReservationById(id);
                    }

                    if (found != null) {
                        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
                        System.out.println(found);
                        System.out.println("If you do not want to change the information, just press enter to skip.");

                        System.out.print("Name: ");
                        String newName = Validate.sc.nextLine().trim();
                        if (!newName.isEmpty()) {
                            found.setCustomerName(newName);
                        }

                        System.out.print("Phone: ");
                        String newPhone = Validate.sc.nextLine().trim();
                        if (!newPhone.isEmpty()) {
                            found.setPhoneNumber(newPhone);
                        }

                        System.out.print("RoomNumbers: ");
                        String roomStr = Validate.sc.nextLine().trim();
                        if (!roomStr.isEmpty()) {
                            found.setRoomNumber(Integer.parseInt(roomStr));
                        }

                        System.out.print("BookingDate (dd/MM/yyyy): ");
                        String dateStr = Validate.sc.nextLine().trim();
                        if (!dateStr.isEmpty()) {
                            found.setDateTime(LocalDate.parse(dateStr, Validate.DATE_FMT));
                        }

                        System.out.print("Need airport pick up? (Y/N): ");
                        String pickAns = Validate.sc.nextLine().trim();
                        if (pickAns.equalsIgnoreCase("Y")) {
                            FlightInformation fi = found.getFlightInformation();
                            System.out.print("Flight: ");
                            String f = Validate.sc.nextLine().trim();
                            if (!f.isEmpty()) {
                                fi.setFlightNumber(f);
                            }
                            System.out.print("Seat: ");
                            String s = Validate.sc.nextLine().trim();
                            if (!s.isEmpty()) {
                                fi.setSeatNumber(s);
                            }
                            System.out.print("TimePickUp (dd/MM/yyyy hh:mma): ");
                            String tp = Validate.sc.nextLine().trim();
                            if (!tp.isEmpty()) {
                                fi.setTimePickUp(LocalDateTime.parse(tp, Validate.TIME_FMT));
                            }
                            found.setFlightInformation(fi);
                        }

                        rm.updateReservation(id, found);
                        System.out.println(found.toString());
                        System.out.println("Information saved successfully.");
                    }
                }

                case 3 -> {
                    System.out.println("*** Delete reservation ***");
                    String id = Validate.isValidID("ID: ");
                    Reservation found = rm.findReservationById(id);

                    while (found == null) {
                        System.out.println("No information found");
                        System.out.print("You want to find again? (Y/N): ");
                        String again = Validate.sc.nextLine().trim();
                        if (again.equalsIgnoreCase("N")) {
                            break;
                        }
                        id = Validate.isValidID("ID: ");
                        found = rm.findReservationById(id);
                    }

                    if (found != null) {
                        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
                        System.out.println(found);
                        System.out.print("Are you sure you want to delete this information? (Y/N): ");
                        String confirm = Validate.sc.nextLine().trim();
                        if (confirm.equalsIgnoreCase("Y")) {
                            rm.deleteReservation(id);
                            System.out.println("Information deleted successfully.");
                        }
                    }
                }

                case 4 -> {
                    System.out.println("*** Flight Information ***");
                    List<Reservation> list = rm.getAllReservations();
                    if (list.isEmpty()) {
                        System.out.println("No information to view");
                    } else {
                        System.out.println("ID - Name - Phone - Flight - Seat - TimePickUp");
                        for (Reservation r : list) {
                            FlightInformation f = r.getFlightInformation();
                            System.out.printf("%s - %s - %s - %s - %s - %s%n",
                                    r.getBookingId(), r.getCustomerName(), r.getPhoneNumber(),
                                    f.getFlightNumber(), f.getSeatNumber(),
                                    f.getTimePickUp() != null ? f.getTimePickUp().format(Validate.TIME_FMT) : "N/A");
                        }
                    }
                }

                case 5 -> {
                    System.out.println("*** Reservation Information ***");
                    List<Reservation> list = rm.getAllReservations();
                    if (list.isEmpty()) {
                        System.out.println("No information to view");
                    } else {
                        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
                        for (Reservation r : list) {
                            System.out.println(r);
                        }
                    }
                }

                case 6 ->
                    System.out.println("BYE AND SEE YOU NEXT TIME");

                default ->
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);
    }
}

