package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class FileOperation implements FileOperationMethods {

    private String fileName = "";

    public FileOperation(String fileName) {

        this.fileName = fileName + ".txt";

        try (FileWriter toСreateFile = new FileWriter(fileName + ".txt", true)) {
            toСreateFile.flush();
        } catch (IOException ex) {
            System.out.println("ALARM: ERROR: File:" + " " + fileName + " " + "not created");
        }
    }

    @Override
    public List<String> readAllLines() {

        List<String> allLinesFromFile = new ArrayList<>();

        try (FileReader readFile = new FileReader(fileName)) {

            BufferedReader forReadOneLine = new BufferedReader(readFile);

            String line = forReadOneLine.readLine();

            if (line != null) {
                allLinesFromFile.add(line);
            }
            while (line != null) {
                line = forReadOneLine.readLine();
                if (line != null) {
                    allLinesFromFile.add(line);
                }
            }
            forReadOneLine.close();
        }
        catch (IOException ex) {
            System.out.println("ALARM: ERROR: Specified file:" + " " + fileName + " " + "cannot be read");
        }
        return allLinesFromFile;
    }

    @Override
    public void writeAllLines(List<String> lines) {

        try (FileWriter fileToWrite = new FileWriter(fileName, false)) {

            for (String line : lines) {
                fileToWrite.write(line + "\n");
            }
            fileToWrite.flush();
        }
        catch (IOException ex) {
            System.out.println("ALARM: ERROR: Data is not written to the file");
        }
    }
}
