package ADVANCED.EXERCISE_4_Streams_Files_Directories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class P3_ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\input.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\output.txt"));

        String line = br.readLine();
        while (line != null) {
            bw.write(line.toUpperCase());
            bw.newLine();

            line = br.readLine();
        }
        bw.close();
    }
}
