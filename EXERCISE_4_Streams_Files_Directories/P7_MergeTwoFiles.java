package ADVANCED.EXERCISE_4_Streams_Files_Directories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P7_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathOne = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\inputOne.txt";
        String pathTwo = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\inputTwo.txt";
        PrintWriter writer = new PrintWriter("D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\outputMerge.txt");

        List<String> allLinesOne = Files.readAllLines(Path.of(pathOne));
        allLinesOne.forEach(line -> writer.println(line));
        List<String> allLinesTwo = Files.readAllLines(Path.of(pathTwo));
        allLinesTwo.forEach(line -> writer.println(line));
        writer.close();
    }
}
