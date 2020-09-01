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
public class Q4CharacterOtoT extends Q4Banner{

    public Q4CharacterOtoT(char character) {
        this.character = character;

        switch (character) {
            case 'O':
                line[0] = "";
                line[1] = "";
                line[2] = "";
                line[3] = "";
                line[4] = "";
                break;
            case 'P':
                line[0] = "";
                line[1] = "";
                line[2] = "";
                line[3] = "";
                line[4] = "";
                break;
            case 'Q':
                line[0] = "";
                line[1] = "";
                line[2] = "";
                line[3] = "";
                line[4] = "";
                break;
            case 'R':
                line[0] = "";
                line[1] = "";
                line[2] = "";
                line[3] = "";
                line[4] = "";
                break;
            case 'S':
                line[0] = "  ***";
                line[1] = " *   ";
                line[2] = "  *  ";
                line[3] = "   * ";
                line[4] = "***  ";
                break;
            case 'T':
                line[0] = "*****";
                line[1] = "  *  ";
                line[2] = "  *  ";
                line[3] = "  *  ";
                line[4] = "  *  ";
                break;
        }
    }
}
