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
public interface Q5FileIO {
    public void readFile(String filename) throws IOException;
    public void writeFile(String filename, String line) throws IOException;
    
}
