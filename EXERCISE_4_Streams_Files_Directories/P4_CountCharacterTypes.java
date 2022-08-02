package ADVANCED.EXERCISE_4_Streams_Files_Directories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class P4_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\input.txt";

        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;

        List<String> list = Files.readAllLines(Path.of(path));

        for (String string : list) {
            for (int i = 0; i < string.length(); i++) {
                char currSymbol = string.charAt(i);

                if (currSymbol == ' ') {
                    continue;
                }

                if (currSymbol == 'a' || currSymbol == 'e' || currSymbol == 'i' || currSymbol == 'o' || currSymbol == 'u') {
                    vowelCount++;
                } else if (currSymbol == '?' || currSymbol == '!' || currSymbol == '.' || currSymbol == ',') {
                    punctuationCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\outputExFout.txt"));
        bw.write("Vowels: " + vowelCount);
        bw.newLine();
        bw.write("Consonants: " + consonantCount);
        bw.newLine();
        bw.write("Punctuation: " + punctuationCount);
        bw.close();
    }
}
