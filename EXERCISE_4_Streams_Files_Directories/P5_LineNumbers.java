package ADVANCED.EXERCISE_4_Streams_Files_Directories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P5_LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\inputLineNumbers.txt";
        List<String> list = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\outputProblemFive.txt");

        int number = 1;
        for (String string : list) {
            writer.println(number + ". " + string);
            number++;
        }
        writer.close();
    }
}
