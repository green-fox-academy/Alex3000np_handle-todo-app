import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManipulation {
    //fields
    Path toDoTxt_Path;                                                                                                  //imported "path" class
    List<String> tasks_Array;                                                                                           //array with string
    int linesQ;                                                                                                         //lines counter
    //constructor - default

    //methods
    public void listTasks() {                                                                                           //shows current to do list
        toDoTxt_Path = Paths.get("D:/Work/greenfox/Project TODO Application/Alex3000np_handle-todo-app/src/ToDoTasks.txt");
        try {
            tasks_Array = Files.readAllLines(toDoTxt_Path);                                                             //storing lines in array
            this.linesQ = 1;
            if (tasks_Array.size() == 0) {                                                                              //"Empty list" part of exercise check if there are elements in array
                System.out.println("No todos for today! :)");
            } else
                for (int i = 0; i < tasks_Array.size(); i++) {
                    System.out.println(linesQ + " --> " + tasks_Array.get(i));
                    linesQ++;                                                                                           //adding counter of lines
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewTask(String taskName) {                                                                           //method takes string as a parameter (it would be argument given in main)
        this.toDoTxt_Path = Paths.get("D:/Work/greenfox/Project TODO Application/Alex3000np_handle-todo-app/src/ToDoTasks.txt"); //check for duplicate code!!!!!
        try {
            this.tasks_Array = Files.readAllLines(toDoTxt_Path);
            this.tasks_Array.add(taskName);                                                                             //args is an array (main) where 0th element is an argument "-l" 1th is user's text (cant access!!!!!!!!!)
            Files.write(toDoTxt_Path, tasks_Array);                                                                     //writing array content to file (path)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeTask(String taskNumber) {
        this.toDoTxt_Path = Paths.get("D:/Work/greenfox/Project TODO Application/Alex3000np_handle-todo-app/src/ToDoTasks.txt"); //check for duplicate code!!!!!
        try {
            this.tasks_Array = Files.readAllLines(this.toDoTxt_Path);                                                   //reading
            this.tasks_Array.remove(Integer.parseInt(taskNumber));                                                      //deleting task from an array
            Files.write(this.toDoTxt_Path, tasks_Array);                                                                //writing back to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkTask(String taskNumber) {
        this.toDoTxt_Path = Paths.get("D:/Work/greenfox/Project TODO Application/Alex3000np_handle-todo-app/src/ToDoTasks.txt"); //check for duplicate code!!!!!
        try {
            this.tasks_Array = Files.readAllLines(this.toDoTxt_Path);
            System.out.println(this.tasks_Array.get(Integer.parseInt(taskNumber) - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void argumentErrorHandling (String wrongArgument){
        if (!"-l".equals(wrongArgument) || !"-a".equals(wrongArgument) || !"-r".equals(wrongArgument) || !"-c".equals(wrongArgument) ){
            System.out.println("Unsupported argument");
//            (PrintUsage) printUsage();
        }
    }
}
