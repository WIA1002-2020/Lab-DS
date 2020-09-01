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
public class Q3SimpleNetwork {

    private String name;
    private String ipAddress;
    private String subnet;
    private String status;

    public Q3SimpleNetwork() {
        this.name = "";
        this.ipAddress = "";
        this.subnet = "";
        this.status = "";
    }

    public Q3SimpleNetwork(String name, String ipAddress, String subnet, String status) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.subnet = subnet;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Host Name: " + name + " IP: " + ipAddress + " Subnet Mask: " + subnet + " Status: " + status);
    }

    public void testPing(Q3SimpleNetwork a, Q3SimpleNetwork b) {
        if (a.status.equals("DOWN") || b.status.equals("DOWN")) {
            if (a.status.equals("DOWN")) {
                System.out.println(b.name + " cannot ping " + a.name + " because the destination " + a.name + " is down");
            } else {
                System.out.println(a.name + " cannot ping " + b.name + " because the destination " + b.name + " is down");
            }
        } else {
            String[] IPAddress1 = a.ipAddress.split("\\.");
            String[] subnetMask1 = a.subnet.split("\\.");

            String[] IPAddress2 = b.ipAddress.split("\\.");
            String[] subnetMask2 = b.subnet.split("\\.");

            String networkAddress1 = "";
            String networkAddress2 = "";
            for (int i = 0; i < 4; i++) {
                networkAddress1 = networkAddress1.concat(String.valueOf(Integer.valueOf(IPAddress1[i]) & Integer.valueOf(subnetMask1[i])));
                if (i != 3) {
                    networkAddress1 = networkAddress1.concat(".");
                }
                networkAddress2 = networkAddress2.concat(String.valueOf(Integer.valueOf(IPAddress2[i]) & Integer.valueOf(subnetMask2[i])));
                if (i != 3) {
                    networkAddress2 = networkAddress2.concat(".");
                }
            }
            if (networkAddress1.compareTo(networkAddress2) == 0) {
                System.out.println(a.name +" can ping "+ b.name);
            } else {
                System.out.println(a.name +" cannot ping "+ b.name +" because the destination "+ b.name +" is located in different network.");
            }               
        }
    }
}
