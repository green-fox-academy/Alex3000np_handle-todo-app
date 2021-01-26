public class PrintUsage {
    //fields - no
//constructor - default
//methods
    public static void printUsage() {
        System.out.println("Command Line Todo application");
        System.out.println("=============================\n");
        System.out.println("Command line arguments:\n" +
                "    -l   Lists all the tasks\n" +
                "    -a   Adds a new task\n" +
                "    -r   Removes an task\n" +
                "    -c   Completes an task");
    }
}
