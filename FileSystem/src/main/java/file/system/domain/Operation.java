/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.domain;

import file.system.utils.SystemLog;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Operation is an action done in the system file to be log
 *
 * @author Daniel
 */
public class Operation {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Command command_exec;
    private String date_exec;
    private String result;
    private boolean success;

    /**
     * Constructor Operation
     *
     * @param command_exec command that was executed
     * @param success true if command was executed without errors and false
     * otherwise
     */
    public Operation(Command command_exec, String result, boolean success) {
        this.command_exec = command_exec;
        this.result = result;
        this.success = success;
        this.date_exec = formatter.format(new Date());
        this.log();
    }

    /**
     * Log Operation into System Log File
     */
    private void log() {
        SystemLog.log(this);
    }

    /**
     * Get Result
     *
     * @return string with the result of operation
     */
    public String getResult() {
        return result;
    }

    /**
     * To String
     *
     * @return string with format "command;date;success"
     */
    @Override
    public String toString() {
        return this.command_exec.getCommand_tag() + ";" + this.date_exec + ";" + this.success;
    }
}
