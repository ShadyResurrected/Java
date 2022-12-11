package com.company.Miscellaneous;

public class FindTheSmallestLetter {
    public static void main(String[] args){
//        int[] letters = {'c','f','j'};
//        int target = 'z';
//        int result = FindLetter(letters,target);
//        char result1 = (char)(result);
//        System.out.println(result1);
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(letters[mid] > target){
                end = mid - 1;
            }
            if(letters[mid] < target){
                start = mid + 1;
            }
        }
        if(start == letters.length){
            return letters[0];
        }
        return letters[start];
    }

}
