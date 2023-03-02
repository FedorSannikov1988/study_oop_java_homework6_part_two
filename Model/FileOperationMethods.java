package Model;

import java.util.List;

public interface FileOperationMethods {

    List<String> readAllLines();

    void writeAllLines(List<String> lines);

}
