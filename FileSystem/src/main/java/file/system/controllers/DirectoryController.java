/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.controllers;

import file.system.services.DirectoryService;

/**
 *
 * @author Daniel
 */
public class DirectoryController {

    private DirectoryService service = new DirectoryService();

    /**
     * Create Directory
     *
     * @param path_to_dir relative path to directory
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation
     */
    public String createDir(String path_to_dir, String path_working_dir) {
        return service.createDir(path_working_dir + path_to_dir).getResult();
    }

    /**
     * Delete Directory
     *
     * @param path_to_dir relative path to directory
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation
     */
    public String deleteDir(String path_to_dir, String path_working_dir) {
        return service.delete(path_working_dir + path_to_dir).getResult();
    }

    /**
     * Create File
     *
     * @param path_to_file relative path to file
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation
     */
    public String createFile(String path_to_file, String path_working_dir) {
        return service.createFile(path_working_dir + path_to_file).getResult();
    }

    /**
     * Delete File
     *
     * @param path_to_file relative path to file
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation
     */
    public String deleteFile(String path_to_file, String path_working_dir) {
        return service.deleteFile(path_working_dir + path_to_file).getResult();
    }

    /**
     * Move File
     *
     * @param path_to_file_source relative source path to file
     * @param path_to_file_dest absolute destination path to file
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation
     */
    public String moveFile(String path_to_file_source, String path_to_file_dest, String path_working_dir) {
        return service.moveFile(path_working_dir + path_to_file_source, path_to_file_dest).getResult();
    }

    /**
     * List all directories/files in working directory
     *
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation(table with info to display)
     */
    public String consultDir(String path_working_dir) {
        return service.consultDir(path_working_dir).getResult();
    }

    /**
     * Change working directory
     *
     * @param path_to_directory path to new working directory
     * @param oldLocation old working directory location
     * @return Snew location
     */
    public String changeDir(String path_to_directory, String oldLocation) {
        return service.changeDir(path_to_directory, oldLocation).getResult();
    }
}
