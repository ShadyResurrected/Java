package com.company.HackerRank;

import java.util.*;

public class Sort_Frequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        HashMap<Integer,Integer> hMap = new HashMap<>();
        List<Integer> listOne = new ArrayList<>();
        for (int row = 0;row < length;row++){
            int element = in.nextInt();
            listOne.add(element);
            if(hMap.containsKey(element)){
                int freq = hMap.get(element);
                hMap.put(element,freq+1);
            }else {
                hMap.put(element, 1);
            }
        }
        groupSort(listOne);
    }

    public static List<List<Integer>> groupSort(List<Integer> arr){
        int length = arr.size();
        HashMap<Integer,Integer> hMap = new HashMap<>();
        for (int row = 0;row < length;row++){
            int element = arr.get(row);
            if(hMap.containsKey(element)){
                int freq = hMap.get(element);
                hMap.put(element,freq+1);
            }else {
                hMap.put(element, 1);
            }
        }
        int[][] listArr = new int[hMap.size()][2];
        int index = 0;
        for(int key : hMap.keySet()){
            listArr[index][0] = key;
            listArr[index][1] = hMap.get(key);
            index++;
        }
        sortbyColumn(listArr,  1);
        for(int[] row : listArr){
            System.out.println(Arrays.toString(row));
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i < listArr.length;i++){
            list.add(new ArrayList<>());
        }
        for(int row = listArr.length-1; row >= 0;row--){
            list.get(row).add(0,listArr[row][0]);
            list.get(row).add(1,listArr[row][1]);
        }
        return list;
    }
    public static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(final int[] entry1,
                               final int[] entry2) {
                if (entry1[col] < entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }
}
