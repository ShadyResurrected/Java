package com.company.Miscellaneous;

public class NewtonSqrt {
    public static void main(String[] args) {
        double n = 40;
        System.out.println(root(n));
    }

    static double root(double n){
        double x = n; // This is the guessed value
        double root;
        while (true){
            root = (x + (n/x))/2;
            double error = Math.abs(root-x);
            if(error < 0.01){
                break;
            }
            x = root;
        }

        return root;
    }
}
