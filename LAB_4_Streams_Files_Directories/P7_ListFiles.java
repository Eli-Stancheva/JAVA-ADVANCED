package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.File;

public class P7_ListFiles {
    public static void main(String[] args) {
        File file = new File("D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\Files-and-Streams");

        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()){
                        System.out.printf("%s: [%s]\n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
