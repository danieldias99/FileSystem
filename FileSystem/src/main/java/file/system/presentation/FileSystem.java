/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.presentation;

import file.system.controllers.ConsultCommandsController;
import file.system.controllers.DirectoryController;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class FileSystem {

    //Root simulation folder
    public final String ROOT = "root/";

    //Path to working directory
    public String location;

    //Read User Input
    public Scanner scanner = new Scanner(System.in);

    public FileSystem() {
        this.location = ROOT;
    }

    public void doShow() {
        boolean exit = false;
        String result = "";
        do {
            System.out.println("$:" + this.location + ">");
            String command = scanner.nextLine();
            switch (command.split(" ")[0]) {
                case "?":
                    result = new ConsultCommandsController().consultCommands();
                    break;
                case "mkdir":
                    result = new DirectoryController().createDir(command.split(" ")[1], this.location + "/");
                    break;
                case "rmdir":
                    result = new DirectoryController().deleteDir(command.split(" ")[1], this.location + "/");
                    break;
                case "nano":
                    result = new DirectoryController().createFile(command.split(" ")[1], this.location + "/");
                    break;
                case "rm":
                    result = new DirectoryController().deleteFile(command.split(" ")[1], this.location + "/");
                    break;
                case "mv":
                    result = new DirectoryController().moveFile(command.split(" ")[1], command.split(" ")[2], this.location + "/");
                    break;
                case "ls":
                    result = new DirectoryController().consultDir(this.location);
                    break;
                case "cd":
                    result = "";
                    this.location = new DirectoryController().changeDir(command.split(" ")[1], this.location);
                    break;
                case "ext":
                    exit = true;
                    result = "";
                    break;
                default:
                    result = command.split(" ")[0] + " is not recognized as a command. Check '?' to see all available commands!";
            }
            System.out.println(result);
        } while (!exit);
    }

}
