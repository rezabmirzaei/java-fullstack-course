package no.noroff.accelerate.iofundamentals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

    String rootFolder = "resources";

    public boolean createFile() {
        String filePath = rootFolder.concat("/dummy.txt");
        File dummyFile = new File(filePath);
        try {
            return dummyFile.createNewFile();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return false;
        }
    }

    public void writeFile() {
        String filePath = rootFolder.concat("/dummy.txt");
        String dataToWrite = "Writing data with FileWriter";
        try (FileWriter output = new FileWriter(filePath, true);
                BufferedWriter bufferedWriter = new BufferedWriter(output)) {
            bufferedWriter.write(dataToWrite);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void readFile() {
        String filePath = rootFolder.concat("/dummy.txt");
        int ch;
        try (FileReader reader = new FileReader(filePath)) {
            while ((ch = reader.read()) != -1) {
                System.out.println((char) ch);
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void bufferedReadFile() {
        String filePath = rootFolder.concat("/dummy.txt");
        try (FileReader reader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void writeFileNio() {
        String filePath = rootFolder.concat("/dummy.txt");
        String dataToWrite = "Writing with the java.nio package";
        try {
            Files.write(Paths.get(filePath), dataToWrite.getBytes());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}
