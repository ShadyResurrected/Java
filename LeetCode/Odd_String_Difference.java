package com.company.LeetCode;

import java.util.HashMap;

public class Odd_String_Difference {
    public static void main(String[] args) {
//        String[] words = {"adc","wzy","abc"};
//        String[] words = {"mll","edd","jii","tss","fee","dcc","nmm","abb","utt","zyy","xww","tss","wvv","xww","utt"};
        String[] words = {"nnnmmmnnmmmmmmmmmmnm","iiihhhiihhhhhhhhhhih","aaaabbbbbbaaabaaaabb","qqqpppqqppppppppppqp","eeedddeedddddddddded","eeedddeedddddddddded","iiihhhiihhhhhhhhhhih","lllkkkllkkkkkkkkkklk","sssrrrssrrrrrrrrrrsr","sssrrrssrrrrrrrrrrsr","jjjiiijjiiiiiiiiiiji","nnnmmmnnmmmmmmmmmmnm","xxxwwwxxwwwwwwwwwwxw","eeedddeedddddddddded","zzzyyyzzyyyyyyyyyyzy","wwwvvvwwvvvvvvvvvvwv","cccbbbccbbbbbbbbbbcb","xxxwwwxxwwwwwwwwwwxw","cccbbbccbbbbbbbbbbcb","yyyxxxyyxxxxxxxxxxyx","hhhggghhgggggggggghg"};
        HashMap<Character,Integer> hMap = new HashMap<>();
        int count = 0;
        for (char ch = 'a'; ch <= 'z';ch++){
            hMap.put(ch,count++);
        }
        int firstOriginal = (int)(-1e9);
        int secondOriginal = (int)(-1e9);
        String ans = "";
        for (String word : words){
            int firstSum = hMap.get(word.charAt(1)) - hMap.get(word.charAt(0));
            int secondSum = hMap.get(word.charAt(2)) - hMap.get(word.charAt(1));
            if(firstOriginal == (int)(-1e9) && secondOriginal == (int)(-1e9)){
                firstOriginal = firstSum;
                secondOriginal = secondSum;
            }else if(secondOriginal != secondSum || firstOriginal != firstSum) ans = word;
        }
        System.out.println(ans);
    }
}
