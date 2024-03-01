import java.io.*;
import java.util.*;

/**
 * This class reinterprets Files as a new data type
 * that works more efficently with the checks
 * @author Hannah Bolton and Wyatt Young
 * @date 2024/02/29
 * @version 1.0
 */

public class Lintee {
    private File file; // the file that's being linted

    /**
     * Constructs a new Lintee object with a given file.
     * @param file The file to be used.
     * @throws FileNotFoundException if the given file does not exist.
     */
    public Lintee(File file) throws FileNotFoundException {
        this.file = file;
    }

    /**
     * Creates a scanner that scans through the file.
     * @return Scanner Scanner that scans through the file.
     * @throws FileNotFoundException if the file does not exist.
     */
    public Scanner toScanner() throws FileNotFoundException {
        return new Scanner(this.file);
    }

    /**
     * Creates a List of each line of the file.
     * Replaces multi-line comments with "\0"
     * Leaves single-line comments
     * @return List<String> The List of Strings each line of the file.
     * @throws FileNotFoundException if the file does not exist.
     */
    public List<String> toList() throws FileNotFoundException {
        List<String> fileList = new ArrayList<>();
        Scanner fileScan = this.toScanner();

        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            if (line.contains("/*")) {
                while(!line.contains("*/")) {
                    fileList.add("\0");
                    line = fileScan.nextLine();
                }
            } else {
                fileList.add(line);
            }
        }
        return fileList;
    }
}
