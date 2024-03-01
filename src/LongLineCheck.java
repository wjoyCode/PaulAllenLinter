import java.io.*;
import java.util.*;

public class LongLineCheck implements Check {
    private final String errorMessage = "Line contains 100 or more characters.";
    private final int errorCode = 1001;

    public List<Error> lint(Lintee lintee) throws FileNotFoundException {
        Scanner fileScan = lintee.toScanner();
        List<Error> errorList = new ArrayList<Error>();
        int lineNum = 1;

        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();

            if (line.length() >= 100) {
                errorList.add(new Error(errorCode, lineNum, errorMessage));
            }

            lineNum++;
        }

        return errorList;
    }
}