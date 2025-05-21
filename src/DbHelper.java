import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class DbHelper {
    private static final String URL = "jdbc:sqlite:data/tasks.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS tasks ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title TEXT NOT NULL, "
                + "deadline TEXT, "
                + "priority TEXT, "
                + "status TEXT"
                + ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("DB Init Error: " + e.getMessage());
        }
    }

    public static void insertTask(Task task) {
        String sql = "INSERT INTO tasks(title, deadline, priority, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDeadline().toString()); // ISO 8601 format
            pstmt.setString(3, task.getPriority().toString());
            pstmt.setString(4, task.getStatus().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Task task = new Task(
                        rs.getString("title"),
                        LocalDateTime.parse(rs.getString("deadline")),
                        Priority.valueOf(rs.getString("priority")),
                        Status.valueOf(rs.getString("status")));
                tasks.add(task);
            }

        } catch (SQLException e) {
            System.out.println("Load Error: " + e.getMessage());
        }
        return tasks;
    }
}
