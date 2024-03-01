import java.io.*;
import java.util.*;

public class Linter {
    private Lintee lintee;

    public Linter(Lintee lintee) {
        this.lintee = lintee;
    }

    public List<Error> lint(Set<Check> checks) {
        List<Error> errorList = new ArrayList<>();
        for(Check check : checks) {
            List<Error> errors = check.lint(this.lintee);
            for(Error error : errors) {
                errorList.add(error);
            }
        }
        
        return errorList;
    }
}