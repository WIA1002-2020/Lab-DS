/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

import java.io.IOException;

/**
 *
 * @author muham
 */
public class Q5Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String textFileName = "lab1.txt";
        String binaryFileName = "lab1.dat";
        Q5TextFile textFile = new Q5TextFile();
        Q5BinaryFile binaryFile = new Q5BinaryFile();
        try {
            System.out.println("Write to text file");

            String line1 = "Welcome to FSKTM!";
            System.out.println(line1);
            textFile.writeFile(textFileName, line1);

            String line2 = "Please register your matric number.";
            System.out.println(line2);
            textFile.writeFile(textFileName, line2);

            String line3 = "Please register your UMMail account.";
            System.out.println(line3);
            textFile.writeFile(textFileName, line3);

            System.out.println("Read from text file");
            textFile.readFile(textFileName);

            System.out.println("Write to binary file");

            System.out.println(line1);
            binaryFile.writeFile(binaryFileName, line1);

            System.out.println(line2);
            binaryFile.writeFile(binaryFileName, line2);

            System.out.println(line3);
            binaryFile.writeFile(binaryFileName, line3);

            System.out.println("Read from binary file");
            binaryFile.readFile(binaryFileName);

        } catch (IOException e) {
            System.out.println("error");
        }
    }
    
}
