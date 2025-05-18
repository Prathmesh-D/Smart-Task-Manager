import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        
        // Create a deadline: 2 days from now at 3 PM
        LocalDateTime deadline = LocalDateTime.now().plusDays(2).withHour(15).withMinute(0);

        // Create a Task with status instead of description
        Task task = new Task(
            "Finish Assignment",
            deadline,
            Priority.MEDIUM,
            Status.ONGOING
        );

        // Print task details
        System.out.println(task);

        // Check if task is due soon
        if (task.isDueSoon()) {
            System.out.println("Task is due soon!");
        } else {
            System.out.println("You have enough time.");
        }

        // Change status to COMPLETED and print again
        task.setStatus(Status.COMPLETED);
        System.out.println("After completion: " + task);
    }
}
