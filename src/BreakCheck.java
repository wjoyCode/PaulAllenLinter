import java.io.*;
import java.util.*;

public class BreakCheck implements Check {
    private final String errorMessage = "Line contains forbidden break statement";
    private final int errorCode = 1001;

    public List<Error> lint(Lintee lintee) throws FileNotFoundException {
        List<String> linteeList = lintee.toList();
        List<Error> errorList = new ArrayList<>(); 
        for(int i = 0; i < linteeList.size(); i++) {
            Scanner lineScan = new Scanner(linteeList.get(i));
            while(lineScan.hasNext()) {
                if(lineScan.next().equals("break;")) {
                    errorList.add(new Error(errorCode, i + 1, errorMessage));
                }
            }
        }
        return errorList;
    }
}