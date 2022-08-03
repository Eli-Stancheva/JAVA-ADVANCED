package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.File;
import java.util.ArrayDeque;

public class P8_NestedFolders {
    public static void main(String[] args) {
        String path = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\Files-and-Streams";
        File root = new File(path);

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()){
            File curr = dirs.poll();
            File[] nestedFiles = curr.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()){
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(curr.getName());
        }
        System.out.println(count + " folders");
    }
}
