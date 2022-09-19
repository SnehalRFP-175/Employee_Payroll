package com.bridgelabz.EmployeePayrollService;


import com.EmployeePayroll.BridgeLabz.EmployeePayrollService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class IOFileTest {
    private static String PATH = "C:\\Users\\dell\\IdeaProjects\\EmployeePayroll\\src";
    private static String DIRECTORY_NAME = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        //Check file exists
        Path homePath = Paths.get(PATH);
        Assertions.assertTrue(Files.exists(homePath));

        //Delete file and check file not exist
        Path playPath = Paths.get(PATH + "/" + DIRECTORY_NAME);
        if (Files.exists(playPath))
            EmployeePayrollService.deleteFiles(playPath.toFile());
        Assertions.assertTrue(Files.notExists(playPath));

        // Create Directory
        Files.createDirectory(playPath);
        Assertions.assertTrue(Files.exists(playPath));

        //Create File
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            Assertions.assertTrue(Files.exists(tempFile));
        });

        // List Files, Directories as well as files with extension
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() &&
                path.toString().startsWith("temp")).forEach(System.out::println);
    }
}