package ADVANCED.LAB_4_Streams_Files_Directories;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("blue", 1, 1, 1);
        String path = "D:\\untitled\\src\\ADVANCED\\LAB_4_Streams_Files_Directories\\myCube";

        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(path));
        objOut.writeObject(cube);
        objOut.close();

        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(path));
        Cube cubeFromFile =(Cube) objIn.readObject();
        System.out.println();
    }
}
