import java.io.Serializable;
import java.time.LocalDateTime;
public class Task implements Serializable{
    private LocalDateTime datetime;
    private String taskDetails;
    private String taskName;
    public Task()
    {

    }
    public Task(String taskName,String taskDetails,LocalDateTime datetime)
    {
        this.taskName = taskName;
        this.datetime = datetime;
        this.taskDetails = taskDetails;
    }
    public LocalDateTime getTime()
    {
        return this.datetime;
    }
    public String getDetails()
    {
        return this.taskDetails;
    }

    public String getTaskName()
    {
        return this.taskName;
    }

    public void showAll()
    {
        System.out.println("Task Name: "+this.taskName);
        System.out.println("Task Details: "+this.taskDetails);
        System.out.println("Task Date: "+this.datetime);
    }
}
