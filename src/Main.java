import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DbHelper.initializeDatabase();

        while (true) {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter Deadline (in Hours): ");
            int time = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Select Priority (Default - MEDIUM):");
            System.out.println("1. HIGH");
            System.out.println("2. MEDIUM");
            System.out.println("3. LOW");
            System.out.print("Choice No. - ");
            int c = scanner.nextInt();
            scanner.nextLine(); 

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

            
            DbHelper.insertTask(task);

            System.out.println("Task saved successfully!");
            System.out.print("Add another task? (Y/N): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("Y")) break;
        }

        System.out.print("Do you want to print all tasks from DB? (Y/N): ");
        String answer1 = scanner.nextLine();
        if (answer1.equalsIgnoreCase("Y")) {
            List<Task> allTasks = DbHelper.loadTasks();
            System.out.println("\nAll Tasks:");
            for (Task t : allTasks) {
                System.out.println(t);
            }
        }

        scanner.close();
    }
}
