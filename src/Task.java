import java.util.ArrayList;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean isCompleted = false;

    public Task(int id, String title, String description, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    // getters
    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // setters
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void displayAllTasks(ArrayList<Task> task){
        if (task.isEmpty()) {
            System.out.println("There is no tasks");
            return;
        }

        for (int i = 0; i < task.size(); i++) {
            System.out.println("Id: " + task.get(i).getId());
            System.out.println("Title: " + task.get(i).getTitle());
            System.out.println("Description: " + task.get(i).getDescription());
            System.out.println("Completed: " + (task.get(i).isCompleted ? "Yes" : "No"));
            System.out.println();
        }
    }

    public static void updateTaskIds(ArrayList<Task> task) {
        for (int i = 0; i < task.size(); i++) {
            task.get(i).setId(i + 1);
        }
    }
}
