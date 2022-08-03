package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P2_WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\input.txt";
        String toWrite = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\02.WriteToFileOutput.txt";

        Set<Character> symbols = new HashSet<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        FileInputStream in = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream(toWrite);

        int oneByte = in.read();
        while (oneByte >= 0){
            char myBiteAsChar = (char) oneByte;
            if (!symbols.contains(myBiteAsChar)){
                out.write(oneByte);
            }
            oneByte = in.read();
        }
    }
}
