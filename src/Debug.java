import java.util.*;
import java.io.*;

public class Debug {
    public static void main(String[] args) throws FileNotFoundException {
        final String filePath = "/workspaces/PaulAllenLinter/src/TestFile.java";
        File file = new File(filePath);
        Lintee lintee = new Lintee(file);
        for (String line : lintee.toList()) {
            System.out.println(line);
        }
        BreakCheck breakCheck = new BreakCheck();
        List<Error> testList = breakCheck.lint(lintee);
        for (Error error : testList) {
            System.out.println(error.toString());
        }
    }
}
