package com.company.Miscellaneous;
import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Rotate(arr,11);
    }

    static void Rotate(int[] arr,int k){
        int[] ans = new int[arr.length];
        if(k == arr.length){
            return;
        }else if(k - arr.length == 1){
            int rotation = k - arr.length;
            for(int i = 0; i < arr.length; i++){
                if(i == 0){
                    ans[i] = arr[arr.length-1];
                }else
                    ans[i] = arr[i-1];
            }
        }else{
            for(int i = 0; i < arr.length; i++){
                if(i >= k){
                    ans[i] = arr[i-k];
                }else
                    ans[i] = arr[arr.length - k + i];
            }
        }
        System.arraycopy(ans, 0, arr, 0, ans.length);
        System.out.println(Arrays.toString(ans));
    }
}
