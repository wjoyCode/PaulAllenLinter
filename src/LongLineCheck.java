import java.io.*;
import java.util.*;

/**
 * This class checks a given Lintee for lines that are too long.
 * @author Hannah Bolton
 * @date 2024/02/29
 * @version 1.0
 */
public class LongLineCheck implements Check {
    private final String errorMessage =
            "Line contains 100 or more characters."; // specific error message
    private final int errorCode = 1000; // specific error code

    /**
     * Method that lints a given Lintee for lines that are 100 characters or
     * longer.
     * @param lintee The Lintee to be checked.
     * @return List<Error> A list of all long line errors found in given Lintee.
     * @throws FileNotFoundException if the file in the Lintee is not found.
     */
    public List<Error> lint(Lintee lintee) throws FileNotFoundException {
        Scanner linteeScan = lintee.toScanner();
        List<Error> errorList = new ArrayList<>();
        int lineNum = 1;

        // checking each line
        while (linteeScan.hasNextLine()) {
            String line = linteeScan.nextLine();

            if (line.length() >= 100) {
                errorList.add(new Error(errorCode, lineNum, errorMessage));
            }

            lineNum++;
        }

        return errorList;
    }
}