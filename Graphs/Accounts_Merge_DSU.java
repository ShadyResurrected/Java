package com.company.Graphs;

import java.util.*;

public class Accounts_Merge_DSU {
    public static void main(String[] args) {
        int N = 5;
        String[][] accountsArr = {
                {"John","J1@.com","J2@.com","J3@.com"},
                {"John","J4@.com"},
                {"raj","r1@.com","r2@.com"},
                {"John","J1@.com","J5@.com"},
                {"raj","r2@.com","r3@.com"},
                {"Mary","M1@.com"},
        };
        HashMap<String,Integer> hMap = new HashMap<>();
        List<List<String>> accountsMerge = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        DisjointSet dsu = new DisjointSet(N);

        HelperFunc(accountsArr,hMap,dsu,accountsMerge);
        // Sorting the emails
        for(List<String> row : accountsMerge) Collections.sort(row);

        // Inserting the emails with their respective names
        int row = 0;
        for (int i = 0;i < accountsArr.length; i++){
            String empName = accountsArr[i][0];
            if(accountsMerge.get(i).size() == 0) continue;
            else {
                ans.add(new ArrayList<>());
                ans.get(row).add(empName);
            }
            for (int j = 0;j < accountsMerge.get(i).size(); j++){
                ans.get(row).add(accountsMerge.get(i).get(j));
            }
            row++;
        }

        System.out.println(ans);
    }

    private static void HelperFunc(String[][] accountsArr, HashMap<String, Integer> accounts, DisjointSet dsu,List<List<String>> accountsMerge) {
        // Putting the email id's as per the accounts
        for (int i = 0;i < accountsArr.length; i++){
            for (int j = 1;j < accountsArr[i].length; j++){
                String str = accountsArr[i][j];
                if(accounts.containsKey(str)){
                    dsu.unionByRank(accounts.get(str),i);
                }else accounts.put(str,i);
            }
        }

        for (int i = 0;i < accountsArr.length; i++){
            accountsMerge.add(new ArrayList<>());
        }

        // Iterating over the key values of the hashMap
        for(String email : accounts.keySet()){
            int accountNo = accounts.get(email);
            if(dsu.findUPar(accountNo) == accountNo){
                accountsMerge.get(accountNo).add(email);
            }else accountsMerge.get(dsu.findUPar(accountNo)).add(email);
        }
    }
}
