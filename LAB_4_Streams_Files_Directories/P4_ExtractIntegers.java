package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P4_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\input.txt";
        String pathOut = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(path));
        FileOutputStream out = new FileOutputStream(pathOut);
        PrintWriter outputStream = new PrintWriter(out);

        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int myNumber = scanner.nextInt();
                outputStream.println(myNumber);
            }
            scanner.next();
        }
        outputStream.close();
    }
}
