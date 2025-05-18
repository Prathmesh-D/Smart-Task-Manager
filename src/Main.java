import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Priority priority;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Title: ");
        String titl = scanner.nextLine();

        System.out.print("Enter Deadline (in Hours): ");
        int time = scanner.nextInt();

        System.out.println("Select Priority (Default - MEDIUM):");
        System.out.println("1. HIGH");
        System.out.println("2. MEDIUM");
        System.out.println("3. LOW");
        System.out.print("Choice No. - ");
        int c = scanner.nextInt();

        switch (c) {
            case 1:
                priority = Priority.HIGH;
                break;

            case 2:
                priority = Priority.MEDIUM;
                break;

            case 3:
                priority = Priority.LOW;
                break;

            default:
                priority = Priority.MEDIUM;
                break;
        }

        int deadlinedays = time / 24;
        int deadlinehours = time % 24;

        LocalDateTime deadline = LocalDateTime.now().plusDays(deadlinedays).withHour(deadlinehours).withMinute(0);

        Task task = new Task(
                titl,
                deadline,
                priority,
                Status.ONGOING
        );

        System.out.println("Task fed successfully!");
        System.out.println(task);

        scanner.close();
    }
}
