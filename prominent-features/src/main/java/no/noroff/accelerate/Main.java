package no.noroff.accelerate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import no.noroff.accelerate.iofundamentals.FileOperations;

public class Main {

    public static void main(String[] args) {
        FileOperations fileOperations = new FileOperations();
        // fileOperations.createFile();
        // fileOperations.writeFile();
        fileOperations.readFile();
        // fileOperations.bufferedReadFile();
        // fileOperations.writeFileNio();
        readFromConsole();
    }

    private static void readFromConsole() {
        try (InputStreamReader console = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(console)) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.println(String.format("Welcome %s!", name));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
