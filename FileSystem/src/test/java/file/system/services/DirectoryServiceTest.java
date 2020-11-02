/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.services;

import file.system.domain.Command;
import file.system.domain.Operation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class DirectoryServiceTest {

    private final String ROOT_TEST = "rootTest/";

    private DirectoryService srv;

    public DirectoryServiceTest() {
        srv = new DirectoryService();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createDir method, of class DirectoryService.
     */
    @Test
    public void testCreateDir() {
        System.out.println("testCreateDir");
        String path_to_dir = ROOT_TEST + "dir_test";
        Operation expResult = new Operation(new Command("mkdir", "Create Directory"), "Directory created", true);
        Operation result = srv.createDir(path_to_dir);
        srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of createDir method, of class DirectoryService.
     */
    @Test
    public void testCreateDir_in_subfolders() {
        System.out.println("testCreateDir_in_subfolders");
        String path_to_dir = ROOT_TEST + "dir_test_sub";
        srv.createDir(path_to_dir);
        path_to_dir = ROOT_TEST + "dir_test_sub/" + "dir_test_sub_sub";
        Operation expResult = new Operation(new Command("mkdir", "Create Directory"), "Directory created", true);
        Operation result = srv.createDir(path_to_dir);
        srv.delete(path_to_dir);
        srv.delete(ROOT_TEST + "dir_test_sub");
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of createDir method, of class DirectoryService.
     */
    @Test
    public void testCreateDir_when_dir_exists() {
        System.out.println("testCreateDir_when_dir_exists");
        String path_to_dir = ROOT_TEST + "dir_test_ext";
        srv.createDir(path_to_dir);
        Operation expResult = new Operation(new Command("mkdir", "Create Directory"), "Directory already exists", false);
        Operation result = srv.createDir(path_to_dir);
        srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of delete method, of class DirectoryService.
     */
    @Test
    public void testDelete() {
        System.out.println("testDelete");
        String path_to_dir = ROOT_TEST + "dir_test_rm";
        srv.createDir(path_to_dir);
        Operation expResult = new Operation(new Command("rmdir", "Delete Directory"), "Directory deleted", true);
        Operation result = srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of delete method, of class DirectoryService.
     */
    @Test
    public void testDelete_non_exist_dir() {
        System.out.println("testDelete_non_exist_dir");
        String path_to_dir = ROOT_TEST + "dir_test_rm";
        Operation expResult = new Operation(new Command("rmdir", "Delete Directory"), "Directory doesn't exists", false);
        Operation result = srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of delete method, of class DirectoryService.
     */
    @Test
    public void testDelete_non_empty_dir() {
        System.out.println("testDelete_non_empty_dir");
        String path_to_dir = ROOT_TEST + "sys";
        Operation expResult = new Operation(new Command("rmdir", "Delete Directory"), "Directory isnt' empty", false);
        Operation result = srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of createFile method, of class DirectoryService.
     */
    @Test
    public void testCreateFile() {
        System.out.println("testCreateFile");
        String path_to_file = ROOT_TEST + "new_file";
        Operation expResult = new Operation(new Command("nano", "Create File"), "Create file", true);
        Operation result = srv.createFile(path_to_file);
        srv.deleteFile(path_to_file);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of createFile method, of class DirectoryService.
     */
    @Test
    public void testCreateFile_when_file_exists() {
        System.out.println("testCreateFile_when_file_exists");
        String path_to_file = ROOT_TEST + "new_file";
        srv.createFile(path_to_file);
        Operation expResult = new Operation(new Command("nano", "Create File"), "File already exists", false);
        Operation result = srv.createFile(path_to_file);
        srv.deleteFile(path_to_file);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of createFile method, of class DirectoryService.
     */
    @Test
    public void testCreateFile_when_path_invalid() {
        System.out.println("testCreateFile_when_path_invalid");
        String path_to_file = ROOT_TEST + "invalid/new_file";
        Operation expResult = new Operation(new Command("nano", "Create File"), "Failed to locate file", false);
        Operation result = srv.createFile(path_to_file);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of deleteFile method, of class DirectoryService.
     */
    @Test
    public void testDeleteFile() {
        System.out.println("testDeleteFile");
        String path_to_file = ROOT_TEST + "new_file";
        Operation expResult = new Operation(new Command("rm", "Delete File"), "File deleted", true);
        srv.createFile(path_to_file);
        Operation result = srv.deleteFile(path_to_file);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of deleteFile method, of class DirectoryService.
     */
    @Test
    public void testDeleteFile_non_exist_file() {
        System.out.println("testDeleteFile");
        String path_to_file = ROOT_TEST + "new_file";
        Operation expResult = new Operation(new Command("rm", "Delete File"), "File doesn't exists", true);
        Operation result = srv.deleteFile(path_to_file);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of moveFile method, of class DirectoryService.
     */
    @Test
    public void testMoveFile() {
        System.out.println("moveFile");
        String path_to_new_dir = ROOT_TEST + "mv_dir";
        srv.createDir(path_to_new_dir);
        String path_to_file_source = path_to_new_dir + "/mv_file";
        String path_to_file_dest = ROOT_TEST + "mv_file";
        srv.createFile(path_to_file_source);
        Operation expResult = new Operation(new Command("mv", "Move File"), "File moved", true);
        Operation result = srv.moveFile(path_to_file_source, path_to_file_dest);
        srv.deleteFile(path_to_file_dest);
        srv.delete(path_to_new_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of moveFile method, of class DirectoryService.
     */
    @Test
    public void testMoveFile_no_source_file() {
        System.out.println("moveFile");
        String path_to_new_dir = ROOT_TEST + "mv_dir";
        String path_to_file_source = path_to_new_dir + "mv_file";
        String path_to_file_dest = ROOT_TEST + "mv_file";
        Operation expResult = new Operation(new Command("mv", "Move File"), "Failed to locate file", false);
        Operation result = srv.moveFile(path_to_file_source, path_to_file_dest);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of moveFile method, of class DirectoryService.
     */
    @Test
    public void testMoveFile_no_destin() {
        System.out.println("moveFile");
        String path_to_new_dir = ROOT_TEST + "mv_dir_n";
        String path_to_file_source = ROOT_TEST + "mv_file";
        String path_to_file_dest = path_to_new_dir + "/mv_file";
        srv.createFile(path_to_file_source);
        Operation expResult = new Operation(new Command("mv", "Move File"), "Failed to move file", true);
        Operation result = srv.moveFile(path_to_file_source, path_to_file_dest);
        srv.deleteFile(path_to_file_source);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of consultDir method, of class DirectoryService.
     */
    @Test
    public void testConsultDir() {
        System.out.println("consultDir");
        String path_to_directory = ROOT_TEST;
        Operation expResult = new Operation(new Command("ls", "List directories/files"), "sys\n", true);
        Operation result = srv.consultDir(path_to_directory);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of changeDir method, of class DirectoryService.
     */
    @Test
    public void testChangeDir() {
        System.out.println("testChangeDir_go_back");
        String path_to_directory = ROOT_TEST + "my_dir";
        srv.createDir(path_to_directory);
        String oldLocation = "";
        Operation expResult = new Operation(new Command("cd", "Change Directory"), path_to_directory, true);
        Operation result = srv.changeDir(path_to_directory, oldLocation);
        srv.delete(path_to_directory);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of changeDir method, of class DirectoryService.
     */
    @Test
    public void testChangeDir_to_root() {
        System.out.println("testChangeDir_go_back");
        String path_to_directory = "/";
        String oldLocation = ROOT_TEST + "mv_dir";
        Operation expResult = new Operation(new Command("cd", "Change Directory"), "root", true);
        Operation result = srv.changeDir(path_to_directory, oldLocation);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of changeDir method, of class DirectoryService.
     */
    @Test
    public void testChangeDir_go_back() {
        System.out.println("testChangeDir_go_back");
        String path_to_directory = "..";
        String oldLocation = ROOT_TEST + "mv_dir";
        Operation expResult = new Operation(new Command("cd", "Change Directory"), ROOT_TEST, true);
        Operation result = srv.changeDir(path_to_directory, oldLocation);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of changeDir method, of class DirectoryService.
     */
    @Test
    public void testChangeDir_invalid_new_location() {
        System.out.println("testChangeDir_go_back");
        String path_to_directory = "dir_invalid";
        String oldLocation = ROOT_TEST + "mv_dir";
        Operation expResult = new Operation(new Command("cd", "Change Directory"), oldLocation, true);
        Operation result = srv.changeDir(path_to_directory, oldLocation);
        assertEquals(expResult.getResult(), result.getResult());
    }

}
