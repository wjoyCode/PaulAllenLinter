/**
 * This class creates an Error object for a line of code.
 * @author Hannah Bolton and Wyatt Young
 * @date 2024/02/29
 * @version 1.0
 */

import java.io.*;
import java.util.*;

public class Error {
    private int errorCode; // error code of the error
    private int lineNum; // number of the line the error occurs on
    private String message; // message to be displayed with the error

    /**
     * Constructs an Error based off of the error code, line number, and a given
     * error message.
     * @param errorCode The code for the specific type of error.
     * @param lineNum   The line number the error appears on.
     * @param message   The error message corresponding with the type of error.
     */
    public Error(int errorCode, int lineNum, String message) {
        this.errorCode = errorCode;
        this.lineNum = lineNum;
        this.message = message;
    }

    /**
     * Getter method for the error's error code.
     * @return int The error code.
     */
    public int getErrorCode() {
        return this.errorCode;
    }

    /**
     * Getter method for the line number of the error.
     * @return int The line that the error appears on.
     */
    public int getLineNum() {
        return  this.lineNum;
    }

    /**
     * Getter method for the error message.
     * @return String The error message.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * toString method for the error.
     * @return String A String representation of the whole error.
     */
    public String toString() {
        return "Line: " + this.getLineNum() +
                " Error Code: " + this.getErrorCode() +
                "/n" + this.getMessage();
    }

}
