package com.company.GFG;

public class Number_Of_MatchSticks {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,80,90,60,90};
        int n = a.length;
        int maxMatchSticks = 0;
        if(n == 1) System.out.println(a[0]);
        else{
            maxMatchSticks = FindMatchSticks(a,n);
        }
        System.out.println(maxMatchSticks);
    }

    static int FindMatchSticks(int[] a,int n){
        if(a.length == 1) return a[0];
        if(a.length <= 0) return 0;
        int ans = 0;
        int current[] = new int[a.length-2];
        for(int i = 0;i <= current.length - 1;i += 2){
            current[i] = Math.abs(a[i] - a[i+1]);
        }
        a = current;
        ans = FindMatchSticks(a,n);
        return ans;
    }
}
