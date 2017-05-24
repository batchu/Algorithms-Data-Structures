package net.batchu.exercises;

import java.util.AbstractMap;

/**
 * Created by i1551 on 4/14/2017.
 */
public class LongestOccurrence {

    public static void main(String... args) {

        System.out.println(findOccurance("aaabbcc"));
    }

    public static AbstractMap.SimpleEntry<Character, Integer> findOccurance(String str) {

        char[] c = str.toCharArray();
        char maxChar = c[0];
        int maxCount = 1;
        int currCharCount = 1;

        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1])
                currCharCount++;
            if (c[i] != c[i - 1] || i == c.length - 1) {
                if (currCharCount > maxCount) {
                    maxCount = currCharCount;
                    maxChar = c[i - 1];
                }
                currCharCount = 1;
            }

        }
        return new AbstractMap.SimpleEntry(maxChar, maxCount);
    }

}
