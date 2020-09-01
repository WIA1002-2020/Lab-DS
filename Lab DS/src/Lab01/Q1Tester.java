/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

/**
 *
 * @author muham
 */
public class Q1Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Q1Time a = new Q1Time(17,45);
        //a.setHour(4);
        //a.setMin(32);
        a.format();
        System.out.println(a.toString());
    }
}
