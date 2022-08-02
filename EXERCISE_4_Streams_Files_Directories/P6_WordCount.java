package ADVANCED.EXERCISE_4_Streams_Files_Directories;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P6_WordCount {
    public static void main(String[] args) throws IOException {
        String pathWords = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\words.txt";
        Map<String, Integer> countWords  = new HashMap<>();

        List<String> allLinesWithWord = Files.readAllLines(Path.of(pathWords));
        for (String line : allLinesWithWord) {
            Arrays.stream(line.split(" ")).forEach(word -> {
                countWords.put(word, 0);
            });
        }

        String path = "D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\text.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            Arrays.stream(line.split(" ")).forEach(word -> {
                if (countWords.containsKey(word)){
                    int countCount = countWords.get(word);
                    countWords.put(word, countCount + 1);
                }
            });
        }

        PrintWriter writer = new PrintWriter("D:\\untitled\\src\\ADVANCED\\EXERCISE_4_Streams_Files_Directories\\result.txt");
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
