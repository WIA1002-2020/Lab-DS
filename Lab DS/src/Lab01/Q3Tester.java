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
public class Q3Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String[] name = {"Host 1", "Host 2", "Host 3", "Host 4"};
//        String[] ip = {"10.1.1.1", "10.1.1.2", "10.10.10.70", "10.1.1.15"};
//        String[] subnet = {"255.255.255.224", "255.255.255.224", "255.255.255.224", "255.255.255.224"};
//        String[] status = {"UP", "DOWN", "UP", "UP"};
//        Q3SimpleNetwork a = new Q3SimpleNetwork(name,ip,subnet,status);
//        a.displayStatus();
        Q3SimpleNetwork Host = new Q3SimpleNetwork();
        Q3SimpleNetwork Host1 = new Q3SimpleNetwork("Host 1", "10.1.1.1", "255.255.255.224", "UP");
        Q3SimpleNetwork Host2 = new Q3SimpleNetwork("Host 2", "10.1.1.2", "255.255.255.224", "DOWN");
        Q3SimpleNetwork Host3 = new Q3SimpleNetwork("Host 3", "10.1.1.70", "255.255.255.224", "UP");
        Q3SimpleNetwork Host4 = new Q3SimpleNetwork("Host 4", "10.1.1.15", "255.255.255.224", "UP");

        Host1.displayStatus();
        Host2.displayStatus();
        Host3.displayStatus();
        Host4.displayStatus();
        Host.testPing(Host1, Host2);
        Host.testPing(Host1, Host3);
        Host.testPing(Host1, Host4);
    }

}
