package net.batchu.exercises;

import java.util.Arrays;

/**
 * Created by i1551 on 4/14/2017.
 */
public class MakeAnagrams {

    public static void main(String... args){
        
        String str1 = "cde";
        String str2 = "abc";
        deleteCountToMakeAnagrams(str1, str2);
    }

    private static int deleteCountToMakeAnagrams(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);



        return 0;
    }
}
