package com.example.wordsAPI;

public class WordsUtils {
	
	public static boolean isPalindrome(String str) {
        String rev = "";
        boolean isPalindr = false;
 
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
 
        if (str.toLowerCase().equals(rev.toLowerCase())) {
        	isPalindr = true;
        }
        return isPalindr;
    }

}
