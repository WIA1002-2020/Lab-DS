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
public class Q4Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Q4CharacterAtoG letterF = new Q4CharacterAtoG('F');
        Q4CharacterOtoT letterS = new Q4CharacterOtoT('S');
        Q4CharacterHtoN letterK = new Q4CharacterHtoN('K');
        Q4CharacterOtoT letterT = new Q4CharacterOtoT('T');
        Q4CharacterHtoN letterM = new Q4CharacterHtoN('M');

        for (int i = 0; i < 5; i++) {
            System.out.print(letterF.getLineAt(i));
            System.out.print("  ");
            System.out.print(letterS.getLineAt(i));
            System.out.print("  ");
            System.out.print(letterK.getLineAt(i));
            System.out.print("  ");
            System.out.print(letterT.getLineAt(i));
            System.out.print("  ");
            System.out.print(letterM.getLineAt(i));
            System.out.println();
        }
    }

}
