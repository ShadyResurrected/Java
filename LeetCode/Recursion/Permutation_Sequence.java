package com.company.LeetCode.Recursion;

// Second Method incomplete

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation_Sequence {
    public static void main(String[] args) {
        int n = 3, k = 3;
        String ans = getPermutation(n, k);
        String ans1 = getPermutation2(n,k);
//        System.out.println("The Kth permutation sequence is " + ans);
        System.out.println("The Kth permutation sequence is " + ans1);
    }

    static void swap(char s[], int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
    static void solve(char s[], int index, ArrayList < String > res) {
        if (index == s.length) {
            String str = new String(s);

            res.add(str);
            return;
        }
        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            solve(s, index + 1, res);
            swap(s, i, index);
        }
    }

    static String getPermutation(int n, int k) {
        String s = "";
        ArrayList < String > res = new ArrayList < > ();
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        solve(s.toCharArray(), 0, res);
        Collections.sort(res);

        return res.get(k);

    }

    static String getPermutation2(int n,int k){
        ArrayList<Integer> list = new ArrayList<>();
        String str = "";
        for(int i = 0;i < n; i++){
            list.add(i+1);
        }
        k--;
        n--;
        while(list.size() != 0){
            int num = (k)/Factorial(n);
            str += list.get(num);
            list.remove(num);
            k = (k)%Factorial(n);
            n--;
        }

        return str;
    }

    static int Factorial(int n){
        int prod = 1;
        while(n > 0){
            prod *= n;
            n--;
        }
        return prod;
    }
}
