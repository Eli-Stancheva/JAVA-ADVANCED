package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.*;
import java.util.Scanner;

public class P5_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\input.txt";
        String pathOut = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\05.WriteEveryThirdLineOutput.txt";

        Scanner in = new Scanner(new FileReader(path));
        PrintWriter out = new PrintWriter(new FileWriter(pathOut));

        int counter = 1;
        String line = in.nextLine();
        while (in.hasNextLine()) {
            if (counter % 3 == 0) {
                out.println(line);
            }
            counter++;
            line = in.nextLine();
            out.flush();
        }
        out.close();
        in.close();
    }
}
