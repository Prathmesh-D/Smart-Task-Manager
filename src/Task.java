import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Task {
    private static int idCounter = 1;
    private int id;
    private String title;
    private LocalDateTime deadline;
    private Priority priority;
    private Status status;

    public Task(String title, LocalDateTime deadline, Priority priority, Status status) {
        this.id = idCounter++;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDateTime getDeadline() { return deadline; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    // Returns true if deadline is within next 24 hours
    public boolean isDueSoon() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, deadline);
        return !deadline.isBefore(now) && duration.toHours() <= 24;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public String toString() {
        return "Task{id=" + id +
               ", title='" + title + '\'' +
               ", deadline=" + deadline.format(formatter) +  
               ", priority=" + priority +
               ", status=" + status +
               '}';
    }
    
}
