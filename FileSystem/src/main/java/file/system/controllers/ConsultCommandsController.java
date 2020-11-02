/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.controllers;

import file.system.services.ConsultCommandsService;

/**
 * Controller class for commands
 *
 * @author Daniel
 */
public class ConsultCommandsController {

    public ConsultCommandsService service = new ConsultCommandsService();

    /**
     * Get Commands to display to user
     *
     * @return string with all commands suported
     */
    public String consultCommands() {
        return service.consult().getResult();
    }

}
