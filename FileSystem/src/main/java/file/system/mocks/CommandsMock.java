/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.mocks;

import file.system.domain.Command;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class CommandsMock {

    private List<Command> commands;

    /**
     * Constructor
     */
    public CommandsMock() {
        this.commands = new ArrayList<>();;
    }

    /**
     * Create all known commands
     *
     * @return string with format command-> description
     */
    public String mock() {
        Command command = new Command("mkdir", "Create new directory");
        commands.add(command);
        command = new Command("rmdir", "Delete directory");
        commands.add(command);
        command = new Command("cd", "Change working directory");
        commands.add(command);
        command = new Command("nano", "Create new file");
        commands.add(command);
        command = new Command("cat", "Consult file content");
        commands.add(command);
        command = new Command("rm", "Delete file");
        commands.add(command);
        command = new Command("mv", "Move file/directory to other directory");
        commands.add(command);
        command = new Command("ls", "List all files and directories in working directory");
        commands.add(command);
        return toString();
    }

    @Override
    public String toString() {
        String result = "Suported Commands";
        for (Command command : commands) {
            result += "\n" + command.toString();
        }
        return result;
    }

}
