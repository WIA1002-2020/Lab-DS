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
public class Q2Polynomial {

    private int degree;
    private double[] coef;
    private double valueOfX;

    Q2Polynomial(int degree, double[] coef) {
        this.degree = degree;
        this.coef = coef;
    }

    public void setValueOfX(double valueOfX) {
        this.valueOfX = valueOfX;
    }

    public double getValueOfX() {
        return valueOfX;
    }

    public double calculator() {
        double ans = 0;
        for (int i = 0; i < coef.length; i++) {
            ans += coef[i] * Math.pow(valueOfX, degree - i);
        }
        return ans;
    }

    public String toString() {
        String equation = "";
        for (int i = 0; i <= degree; i++) {
            if (i != 0 & coef[i] > 0) {
                equation = equation.concat("+");
            }
            equation = equation.concat(String.valueOf(coef[i]));
            if ((degree - i) > 0) {
                equation = equation.concat("x");
            }
            if ((degree - i) > 1) {
                equation = equation.concat("^" + (degree - i));
            }
            if (i != degree) {
                equation = equation.concat(" ");
            }
        }
        return equation;
    }
}
