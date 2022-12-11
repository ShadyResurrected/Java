package com.company.LeetCode;

import java.util.Arrays;
// Incomplete
public class If_Two_Events_Have_Conflicts {
    public static void main(String[] args) {
//        String[] event1 = {"01:15","02:00"};
//        String[] event2 = {"02:00","03:00"};

//        ["16:53","19:00"]
//["10:33","18:15"]
        String[] event1 = {"16:53","19:00"};
        String[] event2 = {"10:33","18:15"};

        int[] event1Mins = new int[event1.length];
        for(int i = 0;i < event1.length;i++){
            event1Mins[i] = toMins(event1[i]);
        }

        int[] event2Mins = new int[event2.length];
        for(int i = 0;i < event2.length;i++){
            event2Mins[i] = toMins(event2[i]);
        }

        int flag = -1;

        System.out.println(Arrays.toString(event1Mins));
        System.out.println(Arrays.toString(event2Mins));
        if(event1Mins[0] == event2Mins[0] || event1Mins[1] == event2Mins[1]) flag = 1;
        if(event1Mins[0] >= event2Mins[0] && event1Mins[1] <= event2Mins[1]){
            flag = 1;
        }
        if(event2Mins[0] >= event1Mins[0] && event2Mins[1] <= event1Mins[1]){
            flag = 1;
        }
        if(flag == 1) System.out.println(true);
        else System.out.println(false);

    }

    private static int toMins(String s) {
        String[] hourMin = s.split(":");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);
        int hoursInMins = hour * 60;
        return hoursInMins + mins;
    }
}
