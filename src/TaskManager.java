import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskManager implements Serializable{
    private ArrayList<Task> taskList = new ArrayList<> ();
    public String fileName = "tasks.txt";
    public TaskManager()
    {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
            String line;
            while((line = reader.readLine())!= null)
            {
                String [] parts = line.split("\\+");
                LocalDateTime dateTime;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                dateTime = LocalDateTime.parse(parts[2]);
                addTask(parts[0], parts[1], dateTime);
            }
            reader.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
    }
    public int addTask (String taskName, String taskDetails,LocalDateTime dateTime )
    {
       Task task = new Task(taskName,taskDetails,dateTime);
       taskList.add(task);
       return 1;
    }

    public Task getTask(String taskName)
    {
        Task temp = new Task();
        for(int i=0;i<this.taskList.size();i++)
        {
            if(this.taskList.get(i).getTaskName().equals(taskName))
            {
                temp = this.taskList.get(i);
                break;
            }
        }
        return temp;
    }

    public void deleteTask(String taskName)
    {
        for(int i=0;i<this.taskList.size();i++)
        {
            if(this.taskList.get(i).getTaskName() == taskName)
            {
                this.taskList.remove(i);
                break;
            }
        }
    }

    public void showTasks()
    {
        for(int i=0;i<this.taskList.size();i++)
        {
            System.out.println("Task:"+(i+1));
            this.taskList.get(i).showAll();
        }
    }

    public void saveToFIle()
    {
       try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));

        for(Task task : this.taskList)
        {
            // LocalDateTime dateTime = task.getTime();
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // String formattedDateTime = dateTime.format(formatter);
            writer.write(task.getTaskName()+"+"+task.getDetails()+"+"+task.getTime());
            writer.newLine();
        }
        writer.close();
       }
       catch(IOException e)
       {
        System.out.println(e);
       }
    }

    
}
