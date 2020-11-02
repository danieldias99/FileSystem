/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.services;

import file.system.domain.Command;
import file.system.domain.Operation;
import file.system.mocks.CommandsMock;

/**
 * Service class for commands
 *
 * @author Daniel
 */
public class ConsultCommandsService {

    public CommandsMock mock;

    /**
     * Consult all commands
     *
     * @return command consulting operation
     */
    public Operation consult() {
        String result = new CommandsMock().mock();
        Command command = new Command("?", "Manual");
        boolean success = true;
        return new Operation(command, result, success);
    }

}
