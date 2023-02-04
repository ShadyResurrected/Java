package com.company.CodingNinjas;

public class Allocate_books {
    public static void main(String[] args) {
        int days = 3;
        int chapter = 5;
        int[] time = {1,2,2,3,1};
        long maxTime = 0;
        long minTime = Integer.MAX_VALUE;
        for (int i  : time){
            maxTime += i;
            minTime = Math.min(minTime,i);
        }
        long ans = AllocateMinimalValue(time,days,chapter,maxTime,minTime);
        System.out.println(ans);
    }

    static long AllocateMinimalValue(int[] time,int days,int chapter,long maxTime,long minTime){
        long low = minTime;
        long high = maxTime;
        while (low <= high){
            long mid = low + (high - low)/2;
            if(isCompatible(mid,days,chapter,time)){
                high = mid - 1;
            }else
                low = mid + 1;
        }
        return low;
    }

    static boolean isCompatible(long mid,int days,int chapter,int[] time){
        long currentTime = 0;
        long currentDays = 0;
        for (int i = 0; i < time.length; i++){
            if(currentTime + time[i] > mid){
                currentDays++;
                currentTime = time[i];
                if(currentTime > mid) return false;
            }else
                currentTime += time[i];
        }
        if (currentDays < days){
            return true;
        }

        return false;
    }
}
