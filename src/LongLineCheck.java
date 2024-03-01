import java.util.*;

public class LongLineCheck implements Check {
    private final String errorMessage = "Line contains 100 or more characters.";
    private final int errorCode = 1001;

    public List<Error> lint(Lintee lintee) {
        Scanner fileScan = lintee.toScanner();

    }
}
