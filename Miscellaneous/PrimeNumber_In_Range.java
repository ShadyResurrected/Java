package com.company.Miscellaneous;

public class PrimeNumber_In_Range {
    public static void main(String[] args) {
        int n = 37;
        boolean[] primes = new boolean[n+1];
        isPrimes(n,primes);
    }
    // on initialization the value of boolean element is false
    static void isPrimes(int n, boolean[] primes){
        for (int i = 2; i*i <= n; i++){
            if(!primes[i]){
                for (int j = i*2; j < n; j+= i){
                    primes[j] = true; // true in boolean array means the element is not prime
                }
            }
        }

        for (int i = 2; i <= n; i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }
}
