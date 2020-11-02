/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.utils;

import file.system.domain.Operation;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Daniel
 */
public class SystemLog {

    private static final String SL_FILE_NAME = "root/sys/SystemLog";

    /**
     * Write in document an action done in the system file
     *
     * @param operation action done in file system to log
     */
    public static void log(Operation operation) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(SL_FILE_NAME, true));
            writer.append(operation.toString());
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
