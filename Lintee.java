import java.io.*;
import java.util.*;

public class Lintee {
    private File file;

    public Lintee(File file) throws FileNotFoundException {
        this.file = file;
    }

    public Scanner toScanner() throws FileNotFoundException {
        return new Scanner(this.file);
    }

    public List<String> toList() throws FileNotFoundException {
        new ArrayList<>()
        return ;
    }
}
