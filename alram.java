import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter alarm time (HH:MM:SS): ");
        String alarmTime = scanner.nextLine();

        System.out.println("Alarm set for " + alarmTime);

        while (true) {
            LocalTime currentTime = LocalTime.now();
            String now = String.format("%02d:%02d:%02d",
                    currentTime.getHour(),
                    currentTime.getMinute(),
                    currentTime.getSecond());

            if (now.equals(alarmTime)) {
                System.out.println("\n⏰ ALARM! Wake up!");
                break;
            }

            try {
                Thread.sleep(1000); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
