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
public class Q1Time {

    private int hour;
    private int min;

    public Q1Time() {
        hour = 0;
        min = 0;
    }   
    
    public Q1Time(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }
   
    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public String format() {
        int hourFormat;
        String Format;
        if (hour > 12) {
            hourFormat = hour - 12;
            Format = hourFormat + ":" + min + " PM";
        } else {
            Format = hour + ":" + min + "AM";
        }

        return Format;
    }

    public String toString() {
        String str;
        if (hour >= 24 || min >= 60) {
            str = "Hour: " + hour + " Minute: " + min + " Invalid Time Format";
        } else {
            str = "Hour: " + hour + " Minute: " + min + " " + format();
        }
        return str;
    }
}
