import java.io.*;
import java.util.*;

public interface Check {
    public List<Error> lint(Lintee lintee) throws FileNotFoundException;
}
