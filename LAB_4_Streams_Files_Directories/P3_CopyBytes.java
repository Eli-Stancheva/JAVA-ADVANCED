package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P3_CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\input.txt";
        String toWrite = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\03.CopyBytesOutput.txt";

        FileInputStream in = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream(toWrite);

        int oneByte = in.read();
        while (oneByte >= 0){
            if (oneByte == 32 || oneByte == 10){
                out.write(oneByte);
            } else {
                String digit = String.valueOf(oneByte);
                for (int i = 0; i < digit.length(); i++) {
                    out.write(digit.charAt(i));
                }
            }
            oneByte = in.read();
        }
    }
}
