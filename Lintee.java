/**
 * This class reinterprets Files as a new data type
 * that works more efficently with the checks
 * @author Hannah Bolton and Wyatt Young
 * @date 2024/02/29
 * @version 1.0
 */
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
        List<String> fileList = new ArrayList<>();
        Scanner fileScan = this.toScanner();
        while(fileScan.hasNextLine()) {
            fileList.add(fileScan.nextLine());
        }
        return fileList;
    }
}
