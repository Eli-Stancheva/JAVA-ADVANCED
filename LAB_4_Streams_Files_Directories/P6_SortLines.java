package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P6_SortLines {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\input.txt";
        String pathOut = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\06.SortLinesOutput.txt";

        Path input = Paths.get(path);
        Path output = Paths.get(pathOut);

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        Files.write(output, lines);
    }
}
