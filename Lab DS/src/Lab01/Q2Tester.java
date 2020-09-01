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
public class Q2Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] num = {4,2,-0.5,-20};
        Q2Polynomial a = new Q2Polynomial(3,num);
        System.out.println("");
        a.setValueOfX(2);
        System.out.println("The polynomial is "+a.toString());       
        System.out.println("when x = "+ a.getValueOfX());
        System.out.print(a.toString()+" = ");
        System.out.printf("%.2f",a.calculator());
        a.setValueOfX(-3.5);
        System.out.println("\nwhen x = "+ a.getValueOfX());
        System.out.print(a.toString()+" = ");
        System.out.printf("%.2f\n",a.calculator());
        
    }
    
}
