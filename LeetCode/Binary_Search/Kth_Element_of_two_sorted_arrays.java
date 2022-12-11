package com.company.LeetCode.Binary_Search;

public class Kth_Element_of_two_sorted_arrays {
    public static void main(String[] args) {
        int[] row1 = {2, 3, 9 ,9, 10, 11};
        int[] row2 = {1 ,1, 2, 4, 5, 6, 7, 8, 8, 9, 9 ,13};
        int m = row1.length;
        int n = row2.length;
        int k = 18;
        int ans1 = FindLadoosBinary(row1,row2,m,n,k);
        int ans2 = FindLadoosNaive(row1,row2,m,n,k);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    // Optimised Approach
    static int FindLadoosBinary(int[] row1,int[] row2,int m,int n,int k){
        if(m > n)
            return FindLadoosBinary(row2,row1,n,m,k); // Performing binary search on smaller array so as to decrease the search space
        int low = Math.max(0,k-n);
        int high = Math.min(k,m);
//        if(k < m){
//            high = k;
//        }
//        if(k > n){
//            low = k-n;
//        }
        int ans = 0;
        while(low <= high){
            int cut1 = low + (high - low)/2;
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : row1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : row2[cut2-1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : row1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : row2[cut2];
            if(l2 > r1){
                low = cut1 + 1;
            }else if(l1 > r2){
                high = cut1 - 1;
            }else{
                ans = Math.max(l1,l2);
                break;
            }
        }
        return ans;
    }

    // Naive Approach
    static int FindLadoosNaive(int[] row1,int[] row2,int m,int n,int k){
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while(p1 < row1.length && p2 < row2.length){
            if(row1[p1] < row2[p2]){
                index = row1[p1];
                p1++;
            }else{
                index = row2[p2];
                p2++;
            }
            k--;
            if(k == 0){
                return index;
            }
        }

        // For the remaining list
        while(p1 < row1.length){
            index = row1[p1];
            p1++;
            k--;
            if(k == 0){
                return index;
            }
        }

        while(p2 < row2.length){
            index = row2[p2];
            p2++;
            k--;
            if(k == 0){
                return index;
            }
        }
        return index;
    }
}
