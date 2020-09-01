/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author muham
 */
public class Q5TextFile implements Q5FileIO {
    
    @Override
    public void readFile(String fileName) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        System.out.println(objectInputStream.readUTF());
        objectInputStream.close();
    }

    @Override
    public void writeFile(String fileName, String line) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName, true));
        objectOutputStream.writeUTF(line + "\n");
        objectOutputStream.flush();
        objectOutputStream.close();
    }
    
}
