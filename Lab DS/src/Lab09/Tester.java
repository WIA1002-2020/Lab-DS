/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author muham
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        //Question 1
        System.out.print("Enter N : ");
        int N = scanner.nextInt();
        System.out.println("The matrix are : ");
        Integer[][] matrix = new Integer[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = random.nextInt(19 - 10 + 1) + 10;
            }
        }

        for (Integer[] arr : matrix) {
            for (Integer num : arr) {
                System.out.print(num +" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Linear Search");
        System.out.print("Enter a number to search: ");
        int key = scanner.nextInt();
        SortTest<Integer> sortTest = new SortTest<>();

        if (sortTest.findElement(key, matrix)) {
            System.out.println(key +" is found");
            System.out.println("The number of "+ key +" in the matrix is "+ sortTest.findOccurence(key, matrix));
            System.out.println("The location of "+ key +" are : "+ sortTest.findLocation(key, matrix));
        } else {
            System.out.println(key +" is not found");
        }
        
        //Question 2
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addNode(random.nextInt(21));
        }
        System.out.print("\nThe random integers are : ");
        linkedList.showList();
        System.out.println("\nLinear Search");
        System.out.print("Enter a number to search: ");
        key = scanner.nextInt();
        int count = linkedList.getOccurence(key);
        if (count!=0) {
            System.out.println(key + " is found");
            System.out.println("The number of " + key + " in the data set is " + count);
        } else {
            System.out.println(key + " is not found");
        }
        System.out.print("Enter two numbers to search (begin end) : ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        if (linkedList.containsFromRange(num1, num2)) {
            System.out.println("The number of elements in between " + num1 + " and " + num2
                    + " in the data set is " + linkedList.getOccurenceFromRange(num1, num2));
        } else {
            System.out.println("No integer can be found in between " + num1 + " and " + num2);
        }
        
        //Question 3
        ArrayHashTable<String, String> arrayHashTable = new ArrayHashTable<>();
        arrayHashTable.put("100-101", "ICND1");
        arrayHashTable.put("200-101", "ICND2");
        arrayHashTable.put("200-120", "CCNA Routing and Switching");
        arrayHashTable.put("210-260", "CCNA Security");

        System.out.println("\nThe number of course is " + arrayHashTable.getSize());
        arrayHashTable.showHashTable();

        System.out.println("Adding a new course");
        arrayHashTable.put("300-101", "ROUTE");
        System.out.println("The number of course is " + arrayHashTable.getSize());
        arrayHashTable.showHashTable();

        System.out.println("Modifying 210-260");
        arrayHashTable.put("210-260", "CCNA RS Security");
        System.out.println("The number of course is " + arrayHashTable.getSize());
        arrayHashTable.showHashTable();

        System.out.println("Remove the course 200-101");
        arrayHashTable.remove("200-101");
        System.out.println("The number of course is " + arrayHashTable.getSize());
        arrayHashTable.showHashTable();

        System.out.print("Enter a code to search : ");
        String input = scanner.nextLine();
        System.out.println("Course " + input + " : " + arrayHashTable.get(input));
        
        //Question 4
        ArrayHashTableHashing<Integer, String> products = new ArrayHashTableHashing<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(new File("lab9Q4.txt")));
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                products.put(Integer.valueOf(line.substring(0, 5)), line.substring(6));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nThe data set from the File");
        products.showHashTable();
        System.out.println("The Hash Table size is " + products.getSize());
        System.out.print("Enter a PID to search : ");
        input = scanner.nextLine();
        if (products.containsKey(Integer.valueOf(input))) {
            System.out.println("Product ID : " + input + " " + products.get(Integer.valueOf(input)));
            System.out.println("Location : " + products.getLocation(Integer.valueOf(input)));
        } else {
            System.out.println("Product ID " + input + " cannot be found");
        }
        
        //Question 5
        ArrayHashTableChain<Integer, String> product = new ArrayHashTableChain<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(new File("lab9Q4.txt")));
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                product.put(Integer.valueOf(line.substring(0, 5)), line.substring(6));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nThe data set from the File");
        product.showHashTable();
        System.out.println("The Hash Table size is " + product.getSize());
        System.out.print("Enter a PID to search : ");
        input = scanner.nextLine();
        if (product.containsKey(Integer.valueOf(input))) {
            System.out.println("Product ID : " + input + " " + product.get(Integer.valueOf(input)));
            System.out.println("The elements in the same location are : ");
            product.printLocation(Integer.valueOf(input));
        } else {
            System.out.println("Product ID " + input + " cannot be found");
        }

    }
}
