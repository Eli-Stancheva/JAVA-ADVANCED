package ADVANCED.EXERCISE_4_Streams_Files_Directories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P1_SumLines {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\input.txt";
        List<String> list = Files.readAllLines(Path.of(path));

        for (String string : list) {
            int sum = 0;
            for (int i = 0; i < string.length(); i++) {
                char curr = string.charAt(i);
                sum += curr;
            }
            System.out.println(sum);
        }
    }
}
