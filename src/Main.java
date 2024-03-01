import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Set<Check> checks = new HashSet<>();


        System.out.println("UW Paul Allen Code Quality Linter for Java");
        System.out.println("Please type in your file name");
        String fileName = console.nextLine();
        
        System.out.println("Type of error code of the checks you would like to perform: ");
        System.out.println("(Separate by whitespace to avoid errors)");
        System.out.println("1000: Long Line");
        System.out.println("1001: Forbidden Break Statement");
        
        if(console.nextLine().contains("1000")) {
            checks.add(new LongLineCheck());
        }
        if(console.nextLine().contains("1001")) {
            checks.add(new BreakCheck());
        }

        File file = new File(fileName);
        Linter linter = new Linter(new Lintee(file));
        List<Error> errorList = linter.lint(checks);
        if(errorList.isEmpty()) {

        }
    }
}
