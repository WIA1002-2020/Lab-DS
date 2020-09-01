/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        System.out.print("Enter N Special Random Number within 0-100: ");
        int N = scanner.nextInt();
        System.out.print("The Special Number are : ");
        Integer[] values = new Integer[N];
        for (int i = 0; i < values.length; i++) {
            values[i]=random.nextInt(101);
            System.out.print(values[i] +" ");
        }
        System.out.println();
        Sort<Integer> integerSort = new Sort(values);
        integerSort.mergeSort();
        System.out.print("After Merge Sort : ");
        integerSort.printArray();
        
        System.out.println("");
        
        //Question 2
        try {
            BufferedReader in = new BufferedReader(new FileReader("lab8Q02.txt"));
            System.out.println("\nReading data from product text file");
            ArrayList<String> arrayList = new ArrayList<>();
            String line=in.readLine();
            while (line!=null) {
                line = line.replaceAll(",", " :");
                arrayList.add(line);
                System.out.println(line);
                line=in.readLine();
            }
            System.out.println("After Quick Sort (Price, PID) :");
            String[] lines = arrayList.toArray(new String[0]);
            Sort<String> productSort = new Sort(lines);
            productSort.quickSort();
            productSort.printArrayByLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());  
        }
        
        //Question 3
        System.out.println("\nPerformance Comparison of Sorting Algorithms");
        System.out.println("Running on 1000 sets of 100000 random numbers");
        SortTest sortTest = new SortTest();
        Integer[] numbers = new Integer[100000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100000; j++) {
                numbers[j] = random.nextInt();
            }
            sortTest.test(numbers);
        }
        sortTest.displayResult();
        
        //Question 4
        System.out.print("\nEnter N characters : ");
        int characterNumber = scanner.nextInt();

        ArrayList<Character> characterArrayList = new ArrayList<>();
        System.out.print("The characters are : ");
        char c;
        for (int i = 0; i < characterNumber; i++) {
            c = (char) (random.nextInt(26)); // ASCII A -> Z
            characterArrayList.add(c);
            System.out.print(c + " ");
        }
        System.out.println();

        Sort<Character> characterSort = new Sort(characterArrayList.toArray(new Character[characterArrayList.size()]));
        characterSort.heapSort();
        System.out.println("Heap Sort - Ascending Order");
        characterSort.printArray();
    }
}
