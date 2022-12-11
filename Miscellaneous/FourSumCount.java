package com.company.Miscellaneous;
// https://leetcode.com/problems/4sum-ii/
public class FourSumCount {
    public static void main(String[] args) {
        int[] nums1 = {-1,-1};
        int[] nums2 = {-1,1};
        int[] nums3 = {-1,1};
        int[] nums4 = {1,-1};
        System.out.println(fourSum(nums1,nums2,nums3,nums4));
    }

    static int fourSum(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        int ans = 0;
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length;j++){
                int sum1 = 0;
                sum1 = nums1[i] + nums2[j];
                ans += checkSum(sum1,nums3,nums4);
            }
        }

        return ans;
    }
    static int checkSum(int sum1,int[] nums3,int[] nums4){
        int ans = 0;
        for (int i = 0; i < nums3.length;i++){
            for (int j = 0; j < nums4.length;j++){
                int sum2 = 0;
                sum2 = nums3[i] + nums4[j];
                if(sum1 == -sum2){
                    ans++;
                }
            }
        }
        return ans;
    }
}
