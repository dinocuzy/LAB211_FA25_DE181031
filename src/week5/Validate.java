package week5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validate {

    public static final Scanner sc = new Scanner(System.in);

    public static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mma");
    public static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static String inputNonEmpty(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Data input is invalid");
        }
    }

    public static int inputPositiveInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n > 0) {
                    return n;
                }
            } catch (Exception ignored) {
            }
            System.out.println("Data input is invalid");
        }
    }

    public static LocalDate inputFutureDate(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                LocalDate date = LocalDate.parse(sc.nextLine().trim(), fmt);
                if (date.isAfter(LocalDate.now())) {
                    return date;
                }
            } catch (Exception ignored) {
            }
            System.out.println("Data input is invalid");
        }
    }

    public static int checkNum(String ms) {
        while (true) {
            System.out.print(ms);
            try {
                int num = Integer.parseInt(sc.nextLine().trim());
                if (num < 1) {
                    System.out.println("Data input is invalid!!!");
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static double checkDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter a number!");
            }
        }
    }

    public static String isValidID(String ms) {
        while (true) {
            System.out.print(ms);
            String id = sc.nextLine().trim();
            if (id.matches("^[0-9]{6}$")) {
                return id;
            } else {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z\\p{L}\\s]+$");
    }

    public static String inputName(String ms) {
        while (true) {
            System.out.print(ms);
            String name = sc.nextLine().trim();
            if (isValidName(name)) {
                return name;
            }
            System.out.println("Data of name input is invalid!!!");
        }
    }

    public static String isPhone(String ms) {
        while (true) {
            System.out.print(ms);
            String phone = sc.nextLine().trim();
            if (phone.matches("0\\d{11}")) {
                return phone;
            } else {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static int isRoomNumber(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                int roomNumber = Integer.parseInt(sc.nextLine().trim());
                if (roomNumber < 1 || roomNumber > 999) {
                    throw new Exception();
                }
                return roomNumber;
            } catch (Exception e) {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static LocalDate inputBookingDate(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                LocalDate bookingDate = LocalDate.parse(sc.nextLine().trim(), DATE_FMT);
                if (!bookingDate.isAfter(LocalDate.now())) {
                    throw new Exception();
                }
                return bookingDate;
            } catch (Exception e) {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static String inputFlightNumber(String ms) {
        while (true) {
            System.out.print(ms);
            String flightNumber = sc.nextLine().trim();
            if (flightNumber.matches("^[A-Z]{2}\\d{4}$")) {
                return flightNumber;
            } else {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static String inputSeatNumber(String ms) {
        while (true) {
            System.out.print(ms);
            String seatNumber = sc.nextLine().trim();
            if (seatNumber.matches("^[A-Z]{1}\\d{3}$")) {
                return seatNumber;
            } else {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static LocalDateTime inputTimePickUp(String ms, LocalDate bookingDate) {
        while (true) {
            try {
                System.out.print(ms);
                LocalDateTime t = LocalDateTime.parse(sc.nextLine().trim(), TIME_FMT);
                if (t.isBefore(bookingDate.atStartOfDay()) || t.isBefore(LocalDateTime.now())) {
                    throw new Exception();
                }
                return t;
            } catch (Exception e) {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static int isYOB(String ms) {
        while (true) {
            System.out.print(ms);
            try {
                int yob = Integer.parseInt(sc.nextLine().trim());
                if (yob >= Year.now().getValue()) {
                    throw new Exception();
                }
                return yob;
            } catch (Exception e) {
                System.out.println("Data of year of birth is invalid!!!");
            }
        }
    }

    public static String isMajor(String ms) {
        while (true) {
            System.out.print(ms);
            String major = sc.nextLine().trim();
            if (!major.isEmpty() && major.length() <= 30) {
                return major;
            } else {
                System.out.println("Data of Major is invalid!!!");
            }
        }
    }

    public static int isYears(String ms, int yob) {
        int currentYear = Year.now().getValue();
        int age = currentYear - yob;
        while (true) {
            System.out.print(ms);
            try {
                int years = Integer.parseInt(sc.nextLine().trim());
                if (years <= 0 || years >= age) {
                    throw new Exception();
                }
                return years;
            } catch (Exception e) {
                System.out.println("Data input is invalid!!!");
            }
        }
    }

    public static String isContractType(String ms) {
        while (true) {
            System.out.print(ms);
            String type = sc.nextLine().trim().toLowerCase();
            if (type.equals("long") || type.equals("short")) {
                return type;
            }
            System.out.println("Invalid Contract Type! Only 'Long' or 'Short'.");
        }
    }

    public static double isSalaryCoefficient(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                double coef = Double.parseDouble(sc.nextLine().trim());
                if (coef >= 0) {
                    return coef;
                }
            } catch (Exception e) {
            }
            System.out.println("Invalid Salary Coefficient! Must be >= 0.");
        }
    }

    public static double isEntranceEnglishScore(String ms) {
        while (true) {
            try {
                System.out.print(ms + " (0 - 100): ");
                double score = Double.parseDouble(sc.nextLine().trim());
                if (score >= 0 && score <= 100) {
                    return score;
                }
            } catch (Exception ignored) {
            }
            System.out.println("Invalid Entrance English Score! Must be 0 to 100.");
        }
    }
    public static boolean confirm(String msg) {
    while (true) {
        System.out.print(msg);
        String ans = sc.nextLine().trim();
        if (ans.equalsIgnoreCase("Y")) {
            return true;
        } else if (ans.equalsIgnoreCase("N")) {
            return false;
        } else {
            System.out.println("Data input is invalid (please enter Y or N)");
        }
    }
}


    public static int menu(String title, String[] options) {
        System.out.println("\n" + title);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your choice: ");
        while (true) {
            String input = sc.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= options.length) {
                    return choice;
                } else {
                    System.out.print("Invalid choice! Please enter 1-" + options.length + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }
}
