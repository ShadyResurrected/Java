package com.company.Graphs;

import java.util.*;

public class Word_Ladder_II {
    public static void main(String[] args) {
//        String[] wordList = {"pat", "bot", "pot", "poz","coz"};
        String[] wordList = {"n", "l", "m"};
        HashSet<String> hSet = new HashSet<>(List.of(wordList));
        hSet.remove("m");
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<ArrayList<String>> minSequence = HelperFunc("m","l",hSet,queue);
        System.out.println(minSequence);
    }
    private static ArrayList<ArrayList<String>> HelperFunc(String startWord, String endWord, HashSet<String> hSet, Queue<ArrayList<String>> queue) {
        int length = startWord.length();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        queue.offer(new ArrayList<String>() {
            {
                add(startWord);
            }
        });
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<String> removeWord = new ArrayList<>();
            for (int i = 0;i < size; i++){
                ArrayList<String> curList = queue.poll();

                // Answer is found
                if(Objects.equals(curList.get(curList.size()-1), endWord)){
                    ans.add(curList);
                }

                String curWord = curList.get(curList.size()-1);
                // Trying all the possibilities with the alphabets
                for (int j = 0;j < length; j++){
                    char oldChar = curWord.charAt(j);
                    HelperFuncII(curWord,j,removeWord,curList,queue,hSet);
                }
            }

            // Removing the words from the hashSet
            for (String ele : removeWord) hSet.remove(ele);
        }
        return ans;
    }

    static void HelperFuncII(String curWord,int j,ArrayList<String> removeWord,ArrayList<String> curList,Queue<ArrayList<String>> queue,HashSet<String> hSet){
        for (char ch = 'a'; ch <= 'z'; ch++){
            String newWord = curWord.substring(0, j) + ch
                    + curWord.substring(j + 1);
            if(hSet.contains(newWord)){
                ArrayList<String> newList = new ArrayList<>(curList);
                newList.add(newWord);
                removeWord.add(newWord);
                queue.offer(newList);
            }
        }
    }
}
