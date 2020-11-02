/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.domain;

/**
 *
 * @author Daniel
 */
public class Command {

    public String command_tag;
    public String command_description;

    /**
     * Constructor Command
     *
     * @param command_tag command identifier
     * @param command_description command action description
     */
    public Command(String command_tag, String command_description) {
        this.command_tag = command_tag;
        this.command_description = command_description;
    }

    /**
     * Get tag command
     *
     * @return tag of command
     */
    public String getCommand_tag() {
        return command_tag;
    }

    @Override
    public String toString() {
        return command_tag + "-> " + command_description;
    }

}
