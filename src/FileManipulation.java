import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManipulation {
    //fields
    private Path textPath;                                                                                              //imported "path" class
    private List<String> tasks;                                                                                         //array with string
    //lines counter

    //constructor
    public FileManipulation() {
        this.textPath = Paths.get("Alex3000np_handle-todo-app/src/ToDoTasks.txt");
    }

    //methods
    public void listTasks() {                                                                                           //shows current to do list
        try {
            this.tasks = Files.readAllLines(this.textPath);                                                             //storing lines in array

            if (tasks.size() == 0) {                                                                                    //"Empty list" part of exercise check if there are elements in array
                System.out.println("No todos for today! :)");
            } else
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + " --> " + tasks.get(i));

                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewTask(String taskName) {                                                                           //method takes string as a parameter (it would be argument given in main)
        try {
            this.tasks = Files.readAllLines(this.textPath);
            this.tasks.add(taskName);                                                                                   //args is an array (main) where 0th element is an argument "-l" 1th is user's text (cant access!!!!!!!!!)
            Files.write(this.textPath, this.tasks);                                                                     //writing array content to file (path)
            listTasks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTask(String taskNumber) {
        try {
            this.tasks = Files.readAllLines(this.textPath);                                                             //reading
            this.tasks.remove(Integer.parseInt(taskNumber) - 1);                                                  //deleting task from an array
            Files.write(this.textPath, tasks);                                                                          //writing back to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkTask(String taskNumber) {
        try {
            this.tasks = Files.readAllLines(this.textPath);
            System.out.println(this.tasks.get(Integer.parseInt(taskNumber) - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void argumentErrorHandling(String wrongArgument) {
        if (!"-l".equals(wrongArgument) && !"-a".equals(wrongArgument) && !"-r".equals(wrongArgument) && !"-c".equals(wrongArgument)) {
            System.out.println("*** Error: Unsupported argument ***");
            PrintUsage.printUsage();
        }
    }
}
