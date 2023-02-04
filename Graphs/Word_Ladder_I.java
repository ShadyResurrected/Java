package com.company.Graphs;

import java.util.*;

class wordNode{
    String word;
    int level;
    public wordNode(String word,int level){
        this.word = word;
        this.level = level;
    }
}

public class Word_Ladder_I {
    public static void main(String[] args) {
//        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        String[] wordList = {"poon", "plee", "same", "poie","plea","plie","poin"};
        HashSet<String> hSet = new HashSet<>(List.of(wordList));
        Queue<wordNode> queue = new LinkedList<>();
        int minCount = HelperFunc("toon","plea",hSet,queue);
        System.out.println(minCount);
    }

    static int HelperFunc(String startWord,String endWord,HashSet<String> hSet,Queue<wordNode> queue){
        int length = startWord.length();
        queue.offer(new wordNode(startWord,1));
        while (!queue.isEmpty()){
            wordNode curNode = queue.poll();
            String curWord = curNode.word;
            int curLevel = curNode.level;

            // Answer is found
            if(Objects.equals(curWord, endWord)) return curLevel;

            // Trying all the possibilities with the alphabets
            for (int i = 0;i < length; i++){
                char oldChar = curWord.charAt(i);
                for (char ch = 'a'; ch <= 'z'; ch++){
                    String newWord = curWord.substring(0, i) + ch
                            + curWord.substring(i + 1);
                    if(hSet.contains(newWord)){
                        queue.offer(new wordNode(newWord,curLevel+1));
                        hSet.remove(newWord);
                    }
                }
            }
        }


        return 0;
    }
}
