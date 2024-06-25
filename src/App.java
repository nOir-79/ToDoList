import java.time.LocalDateTime;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
       
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        TaskManager taskmanager = new TaskManager();

        while(flag)
        {
            System.out.println("Welcome! Please choose any of the options below:");
            System.out.println("1.Add Task");
            System.out.println("2.Show Task(need TaskName)");
            System.out.println("3.Edit Task(need TaskName)");
            System.out.println("4.Show All Tasks");
            System.out.println("5.Quit");

            int option = scanner.nextInt();
            scanner.nextLine();


            if(option == 1)
            {
                String taskName , taskDetails;
                LocalDateTime dateTime;

                System.out.println("What would be the name of the task? (can't be empty)");
                taskName = scanner.nextLine();
                System.out.println("Write the details of your task:");
                taskDetails = scanner.nextLine();

                int year,month,day,hour,minute;
                System.out.println("Enter the year:");
                year = scanner.nextInt();

                System.out.println("Enter the Month(1-12):");
                month = scanner.nextInt();

                System.out.println("Enter the Day(1-31):");
                day = scanner.nextInt();

                System.out.println("Enter the hour(1-24):");
                hour = scanner.nextInt();

                System.out.println("Enter the Minute(1-60):");
                minute= scanner.nextInt();

                dateTime = LocalDateTime.of(year,month,day,hour,minute);

                int confirmation = taskmanager.addTask(taskName, taskDetails, dateTime);

                if(confirmation == 1)
                {
                    System.out.println("The task is added successfully");
                }

            }
            else if(option == 2)
            {
                System.out.println("Enter the name of the task to be fetched:");
                String taskName = scanner.nextLine();

                Task task = taskmanager.getTask(taskName);
                task.showAll();
            }
            else if(option == 3)
            {
                
            }
            else if(option == 4)
            {
                taskmanager.showTasks();
            }
            else if(option == 5)
            {
                System.out.println("Thank you for using our system");
                taskmanager.saveToFIle();
                flag = false;
            }
            else{

            }

        }

    }
}
