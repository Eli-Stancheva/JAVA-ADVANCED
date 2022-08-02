package ADVANCED.EXERCISE_4_Streams_Files_Directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P2_SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\input.txt";

        long sum = 0;
        byte[] lines = Files.readAllBytes(Path.of(path));
        for (byte line : lines) {
           if (line != 10 && line != 13){
               sum += line;
           }
        }
        System.out.println(sum);
    }
}
