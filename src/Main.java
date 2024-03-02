import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);

        System.out.println("UW Paul Allen Code Quality Linter for Java");
        
        File file = getFile(console);
        
        Set<Check> checks = getChecks(console);
        
        Linter linter = new Linter(new Lintee(file));
        List<Error> errorList = linter.lint(checks);
        if(errorList.isEmpty()) {
            System.out.println("No errors detected!");
        } else {
            for(Error error : errorList) {
                System.out.println(error.toString());
            }
        }
    }

    public static File getFile(Scanner console) {
        while(true) {
            System.out.println("Please type in your file path");
            String fileName = console.nextLine();
            File file = new File(fileName);
            if(file.exists()) {
                return file;
            } else {
                System.out.println("File not found, try again");
            }
        }
    }

    public static Set<Check> getChecks(Scanner console) {
        Set<Check> checks = new HashSet<>();
        System.out.println("Type of error code of the checks you would like to perform: ");
        System.out.println("(Separate by whitespace to avoid errors)");
        System.out.println("1999: All Single-Line Errors");
        System.out.println("1000: Long Line");
        System.out.println("1001: Forbidden Break Statement");
        String line = console.nextLine();

        if(line.contains("1999")) {
            checks.add(new LongLineCheck());
            checks.add(new BreakCheck());
        } else {
            if(line.contains("1000")) {
                checks.add(new LongLineCheck());
            }
            if(line.contains("1001")) {
                checks.add(new BreakCheck());
            }
        }

        return checks;
    }
}
