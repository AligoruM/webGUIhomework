package com.netcracker;

public class Answer {
    private double a;
    private double b;
    private double c;
    private String ans;

    public Answer(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        double x1, x2;

        double d = Math.pow(b, 2) - (4 * a * c);
        if (d > 0) {
            x1 = ((-1) * b + Math.sqrt(d)) / 2 * a;
            x2 = ((-1) * b - Math.sqrt(d)) / 2 * a;
            this.ans = "x1 = " + x1 + " x2 = " + x2;
        } else if (d == 0) {
            x1 = Math.abs((-1) * b);
            this.ans = "x1 = x2 = " + x1;
        } else
            this.ans = "No valid roots";
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", ans='" + ans + '\'' +
                '}';
    }
}
