package com.company.CodeChef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BUYSWEET {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int TImess = in.nextInt();
        while(TImess-- > 0){
            long NumberOfCandies = in.nextLong();
            long AmountOfMoney = in.nextLong();
            ArrayList<Long> SweetCost = new ArrayList<Long>();
            for (long i = 0; i < NumberOfCandies; i++){
                SweetCost.add(in.nextLong());
            }
            ArrayList<Long> CashbackArr = new ArrayList<Long>();
            for (long i = 0; i < NumberOfCandies; i++){
                CashbackArr.add(in.nextLong());
            }
            ArrayList<Long> DiffInCash = new ArrayList<Long>();
            for (int i = 0; i < NumberOfCandies; i++){
                long diff = SweetCost.get(i) - CashbackArr.get(i);
                DiffInCash.add(diff);
            }
            Collections.sort(DiffInCash);
            Collections.sort(SweetCost);
            long MinPrice = DiffInCash.get(0);
            long MinSweetCost = SweetCost.get(0);
            long count = 0;
            long rem = AmountOfMoney - MinPrice;
            while(AmountOfMoney >= MinSweetCost){
                AmountOfMoney = AmountOfMoney - rem;
                count++;
            }
            System.out.println(count);
        }
    }
}
