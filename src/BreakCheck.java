import java.io.*;
import java.util.*;

/**
 * This class checks a given Lintee for any `break` statements used outside of
 * single-line comments.
 * @author Wyatt Young
 * @date 2024/02/29
 * @version 1.0
 */
public class BreakCheck implements Check {
    private final String errorMessage = "Line contains forbidden break statement.";
    private final int errorCode = 1001;

    public List<Error> lint(Lintee lintee) throws FileNotFoundException {
        List<String> linteeList = lintee.toList();
        List<Error> errorList = new ArrayList<>(); 
        for(int i = 0; i < linteeList.size(); i++) {
            Scanner lineScan = new Scanner(linteeList.get(i));
            while(lineScan.hasNext()) {
                if(lineScan.next().equals("//")) {
                    break;
                }
                if(lineScan.next().equals("break;")) {
                    errorList.add(new Error(errorCode, i + 1, errorMessage));
                }
            }
            lineScan.close();
        }
        return errorList;
    }
}