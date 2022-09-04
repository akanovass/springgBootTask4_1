package bitlab.spring.springtask4_1.db;

import java.util.ArrayList;
import java.util.Objects;

public class DBUtil {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Long index = 6L;
    static {
        tasks.add(new Task(1L,"Complete Task 7 from Spring Boot","2022-09-30",true,"qwerr"));
        tasks.add(new Task(2L,"Clear home and buy foods","2022-09-07",false,"description"));
        tasks.add(new Task(3L,"Complete all home tasks at the weekend","2023-01-01",false,"description"));
        tasks.add(new Task(4L,"Develop simple project in Spring Boot for the final","2022-10-12",true,"this is description"));
        tasks.add(new Task(5L,"Learn Korean Language","2022-12-30",false,"desc"));
    }

    public static void addTask(Task task){
        tasks.add(task);
        index++;
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static Long getIndex() {
        return index;
    }

    public static Task getTaskByID(Long id){
        Task task = null;
        for(Task t:tasks){
            if(Objects.equals(t.getId(),id)){
                task=t;
                break;
            }
        }
        return task;
    }

    public static void edit(Long id,String name, String date, boolean completed, String description){
        for(Task task:tasks){
            if(Objects.equals(task.getId(),id)){
                task.setName(name);
                task.setDeadlineDate(date);
                task.setCompleted(completed);
                task.setDescription(description);
                break;
            }
        }
    }
    public static void delete(Long id) {
        for (Task t : tasks) {
            if (Objects.equals(t.getId(), id)) {
                tasks.remove(t);
                break;
            }
        }
    }
}
