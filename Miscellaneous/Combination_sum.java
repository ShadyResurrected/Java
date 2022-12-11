package com.company.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_sum {
    public static void main(String[] args) {
        int[] arr = {2,4,8,16};
        int target = 16;
//        System.out.println(findSumPairs(arr,0,target,new ArrayList<ArrayList<Integer>>()));
        System.out.println(combinationSum(arr,target));

    }

//    static int arrayIndex = 0;
//    static int count = 0;
//    static List<List<Integer>> list1 = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> findSumPairs(int[] arr, int index, int target, ArrayList<ArrayList<Integer>> list){
//        if(index == arr.length){
//            return list;
//        }
//        int rem = target % arr[index];
//        int times = target / arr[index];
//        if (rem == 0) {
//            list.add(new ArrayList<Integer>()); // Adding another arrayList in 2d arraylist as a separate row
//            for (int i = 0; i < times; i++){
//                list.get(arrayIndex).add(i,arr[index]);
//            }
//            arrayIndex++;
//        }else{
//            lookMore(arr,arr[index],target,times,list);
//        }
//        return findSumPairs(arr,index+1,target,list);
//    }

//    static void lookMore(int[] arr, int n,int target,int times,ArrayList<ArrayList<Integer>> list){
//        if(times == 0){
//            return;
//        }
//        int remAns = target%(n*times);
//        if(times*n + remAns == target){
//            for (int k : arr){
//                if(k == remAns){
//                    list.add(new ArrayList<Integer>());
//                    for (int i = 0; i < times; i++) {
//                        list.get(arrayIndex).add(i,n);
//                    }
//                    list.get(arrayIndex).add(0,remAns);
//                    arrayIndex++;
//                }
//            }
//        }
//        lookMore(arr,n,target,times-1,list);
//    }

    static int count = 0;
    static int index = 0;
    static int duplicate = 0;
//    List<Obj> list = new ArrayList<Obj> ();
    static List<List<Integer>> list = new ArrayList<List<Integer>>();
    static List<List<Integer>> combinationSum(int[] candidates,int target){
        if(count == candidates.length){
            return list;
        }

        //Edge case for zero
        if(candidates[count] == 0){
            list.add(index,new ArrayList<Integer>());
            list.get(index).add(0);
            list.get(index).add(target);
            return list;
        }
        int rem = target%candidates[count];
        int times = target/candidates[count];

        if(rem == 0){
            checkDivides(candidates[count],times);
            times--;
            rem = target-(candidates[count] * (times));
//                list.add(index,new ArrayList<Integer>());
////                 Added row 0 in the list
//                for(int i = 0; i < times; i++){
//                    list.get(index).add(candidates[count]);
////                     Adding elements in the count th row, here the expression written inside get will define the row
//                }
                findFactors(candidates,candidates[count],target,times,rem);
            count++;
        }else{
//            List<Integer> ans = findFactors(candidates,candidates[count],target,times,rem); // Here the remaining factors are returned
            findFactors(candidates,candidates[count],target,times,rem);
//            list.add(new ArrayList<Integer>(ans));
//            Way of adding new row in list
//            x.add(new ArrayList<Integer>(Arrays.asList(3, 4, 6)));
            count++;
        }
        return combinationSum(candidates,target);
    }

//    static List<Integer> factorsAns= new ArrayList<>();
    static void findFactors(int[] arr,int find, int target,int times,int rem){
        if(times == 0){
            return;
        }
        if((find * times) + rem == target){
            for(int i = 0; i < arr.length; i++){
                if(rem == arr[i]){
                    if(times == 1){
                        duplicate++;
                        if(duplicate%2 == 0){
                            return;
                        }
                    }
                    list.add(index,new ArrayList<Integer>());
                    list.get(index).add(rem);
                    Addtimes(find,times,arr[i]);
//                    The below line causes stackOverflow error
//                    count++;
                }
            }
        }
        findFactors(arr,find,target,times-1,target-(arr[count] * (times-1)));
    }

    static void Addtimes(int find,int times, int num){
        for(int i = 0; i < times; i++){
            list.get(index).add(find);
        }
        index++;
    }

    static void checkDivides(int num, int times) {
        list.add(index, new ArrayList<Integer>());
        for (int i = 0; i < times; i++) {
            list.get(index).add(i,num);
        }
        index++;
    }

}
