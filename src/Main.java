import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter Deadline (in Hours): ");
            int time = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.println("Select Priority (Default - MEDIUM):");
            System.out.println("1. HIGH");
            System.out.println("2. MEDIUM");
            System.out.println("3. LOW");
            System.out.print("Choice No. - ");
            int c = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Priority priority;
            switch (c) {
                case 1: priority = Priority.HIGH; break;
                case 2: priority = Priority.MEDIUM; break;
                case 3: priority = Priority.LOW; break;
                default: priority = Priority.MEDIUM; break;
            }

            int deadlineDays = time / 24;
            int deadlineHours = time % 24;

            LocalDateTime deadline = LocalDateTime.now()
                    .plusDays(deadlineDays)
                    .withHour(deadlineHours)
                    .withMinute(0);

            Task task = new Task(title, deadline, priority, Status.ONGOING);
            tasks.add(task);

            System.out.println("Task fed successfully!");
            System.out.print("Add another task? (Y/N): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("Y")) {
                break;
            }
        }

        System.out.print("Do you want to print all the tasks? (Y/N): ");
        String answer1 = scanner.nextLine();
        if (answer1.equalsIgnoreCase("Y")) {
            System.out.println("\nAll Tasks:");
            for (Task t : tasks) {
                System.out.println(t);
            }
        }

        scanner.close();
    }
}
