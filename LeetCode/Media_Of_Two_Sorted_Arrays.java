package com.company.LeetCode;

public class Media_Of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {7,12,14,15};
        int[] nums2 = {1,2,3,4,9,11};
        int m = nums1.length;
        int n = nums2.length;
        double ans = Method1(nums1,nums2,m,n);
        double ans2 = Method2(nums1,nums2,m,n);
        System.out.println(ans);
        System.out.println(ans2);
    }

    // Brute force (Optimized space complexity)
    static double Method1(int[] nums1,int[] nums2,int m,int n){
        double ans = 0;
        if((n+m) % 2 == 0){
            int index = (n+m-1)/2;
            ans = FindIndex(nums1,nums2,true,index);
        }else{
            int index = (n+m-1)/2;
            ans = FindIndex(nums1,nums2,false,index);
        }
        return ans;
    }

    static double FindIndex(int[] nums1,int[] nums2,boolean isEven,int index){
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        double ele = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] < nums2[p2]){
                if(isEven){
                    if(p3 == index){
                        ele += nums1[p1];
                    }
                    if(p3 == index + 1){
                        ele += nums1[p1];
                    }
                }else{
                    if(p3 == index){
                        ele += nums1[p1];
                    }
                }
                p1++;
            }else{
                if(isEven){
                    if(p3 == index){
                        ele += nums2[p2];
                    }
                    if(p3 == index + 1){
                        ele += nums2[p2];
                    }
                }else{
                    if(p3 == index){
                        ele += nums2[p2];
                    }
                }
                p2++;
            }
            p3++;
        }

        // remaining element in list

        while(p1 < nums1.length){
            if(isEven){
                if(p3 == index){
                    ele += nums1[p1];
                }
                if(p3 == index + 1){
                    ele += nums1[p1];
                }
            }else{
                if(p3 == index){
                    ele += nums1[p1];
                }
            }
            p1++;
            p3++;
        }

        while (p2 < nums2.length){
            if(isEven){
                if(p3 == index){
                    ele += nums2[p2];
                }
                if(p3 == index + 1){
                    ele += nums2[p2];
                }
            }else{
                if(p3 == index){
                    ele += nums2[p2];
                }
            }
            p2++;
            p3++;
        }

        if(isEven){return ele/2.0;}

        return ele;
    }

    // Optimized Approach(using binary search)
    static double Method2(int[] nums1, int[] nums2, int m, int n) {
        if(m>n)
            return Method2(nums2,nums1,n,m); //ensuring that binary search happens on minimum size array
        int low = 0;
        int median = ((m+n)+1)/2; // This formula works for odd as well as even values of m and n
        int high = m;
        double ans = 0;
        while(low <= high){
            int cut1 = low + (high-low)/2;
            int cut2 = median - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];
            if(l1 > r2){
                high = cut1 - 1;
            }else if(l2 > r1){
                low = cut1 + 1; // adding elements to the left and picking more elements thus moving right
            }else{
                int left_max = Math.max(l1,l2);
                int right_max = Math.min(r1,r2);
                if((m+n) % 2 != 0){
                    ans += left_max;
                }else
                    ans += (left_max + right_max)/2.0;
                break;
            }
        }
        return ans;
    }
}
