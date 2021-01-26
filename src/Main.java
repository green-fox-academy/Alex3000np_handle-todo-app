
public class Main {
    public static void main(String[] args) {
        PrintUsage usage = new PrintUsage();                                                                            //creating new object of PrintUsage class, and calling its method
        FileManipulation manipulation = new FileManipulation();                                                         //creating new object of FileManipulation class, and calling its method
        if (args.length == 0) {
            usage.printUsage();
        } else if (args.length != 0 && args[0].equals("-l")) {
            manipulation.listTasks();
        } else if (args.length != 0 && args[0].equals("-a")) {
            manipulation.addNewTask(args[1]);                                                                           //parameter is 2nd item of args array
        } else if (args.length != 0 && args[0].equals("-r")) {
            manipulation.removeTask(args[1]);                                                                           //parameter is 2nd item of args array
        } else if (args.length != 0 && args[0].equals("-c")) {
            manipulation.checkTask(args[1]);                                                                            //parameter is 2nd item of args array
        }
        manipulation.argumentErrorHandling(args[0]);
    }
}
