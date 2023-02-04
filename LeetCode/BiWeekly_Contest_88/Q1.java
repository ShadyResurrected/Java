package com.company.LeetCode.BiWeekly_Contest_88;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class info{
    char character;
    int index;
    int times;
    public info(int index,char character,int times){
        this.character = character;
        this.index = index;
        this.times = times;
    }
}

public class Q1 {
    public static void main(String[] args) {
        String word = "cbccca";
        HashMap<Character,info> hMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int place = 0;
        for(int i = 0;i < word.length();i++){
            char letter = word.charAt(i);
            if(hMap.containsKey(letter)){
                int count = hMap.get(letter).times;
                hMap.put(letter,new info(hMap.get(letter).index,letter,count+1));
                list.set(hMap.get(letter).index,count+1);
            }else {
                hMap.put(letter, new info(place,letter,1));
                place++;
                list.add(1);
            }
        }
        int flag = -1;
        for(int i = 0;i < list.size();i++){
            int element = list.get(i);
            int count = 0;
            list.set(i,element-1);
            for (int j = 0;j < list.size()-1;j++){
                if(Objects.equals(list.get(j), list.get(j+1))) {
                    count++;
                }
            }
            list.set(i,element);
            if(count == list.size()-1) {
                flag = -1;
                break;
            }else flag = 1;
        }
        if(flag == 1) System.out.println(false);
        else System.out.println(true);
        System.out.println(list);
    }
}
