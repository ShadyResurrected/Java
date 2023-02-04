package com.company.CodingNinjas;
// Incomplete
public class Beauty_Contest {
    public static void main(String[] args) {
//        int[] a = {1,2,3};
//        int[] b = {4,5,6};
        int[] a = {1 ,4 ,2 ,5};
        int[] b = {8 ,2 ,1, 7};
        int k = 1;
        int maxElementB = 0;
        int maxElementBIndex = 0;
        for(int i = 0; i < b.length; i++){
            if(b[i] > maxElementB){
                maxElementB = b[i];
                maxElementBIndex = i;
            }
        }
        for(int i = 0; i < a.length; i++){
            if(a[i] > maxElementB && i < maxElementBIndex){
                k -= (maxElementBIndex - i) + 1;
            }
        }
        if(k == 0){
            System.out.println(1);
        }

        System.out.println(0);
    }
}
