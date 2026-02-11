import java.util.Scanner;

public class TimeConversion {

    public static String timeConversion(String s) {
        // Extract AM or PM
        String period = s.substring(s.length() - 2);
        // Extract hour as integer
        int hour = Integer.parseInt(s.substring(0, 2));
        // Extract minutes and seconds
        String minutesSeconds = s.substring(2, s.length() - 2);

        // Convert hour based on AM/PM
        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0; // Midnight case
            }
        } else { // PM case
            if (hour != 12) {
                hour += 12; // Convert PM hour to 24-hour format
            }
        }

        // Format hour with leading zeros and append minutes and seconds
        return String.format("%02d%s", hour, minutesSeconds);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // Input like "07:05:45PM"
        System.out.println(timeConversion(s));
        scanner.close();
    }
}
