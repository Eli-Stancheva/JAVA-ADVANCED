package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class P1_ReadFile {
    public static void main(String[] args) {
        String path = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\input.txt";

        try (FileInputStream file = new FileInputStream(path)){
            int oneByte = file.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = file.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
