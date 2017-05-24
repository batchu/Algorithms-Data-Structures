package net.batchu.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Searches if any permutation of a Needle is found in a Haystack with an optimized limited search upon all occurences
 */
public class HayStack {

    public static void main(String... args){
        //Refer to HayStackTest.java for comprehensive Unit Tests
        System.out.println(bootstrapSearch("asx", "xmas"));
    }

    /*
    Preps input data and performs input validation
     */
    public static boolean bootstrapSearch(String needleStr, String haystackStr) {

        //Input validation
        if(empty(needleStr) || empty(haystackStr))
            throw new IllegalArgumentException("Please validate your inputs. Needle & Haystack strings must be valid");

        //Cleanup. Remove Whitespaces & Tabs
        needleStr.replaceAll("\\s+", "");
        haystackStr.replaceAll("\\s+", "");

        //Storing Needle in a HashMap as lookups and insertions are of O(1)
        Map<Character, Integer> needle = toMap(needleStr);
        List<Character> haystack = haystackStr.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        return findSearchCases(needle, haystack, needleStr.charAt(0));
    }

    /*
    Searches for all the instances of the first Character of the needle in the haystack. Every instance is a candidate for a search!
     */
    public static boolean findSearchCases(Map<Character, Integer> needle, List<Character> haystack, Character firstChar) {

        List<Integer> occurances = findIndexesOf(firstChar, haystack);

        if(occurances.size()==0)
            return false;
        for (int index : occurances) {
            Integer count = 0;
            //Search if the needle is found in the haystack at every instance of the character in the haystack.
            while (count < needle.size()) {
                if (search(index, haystack, needle))
                    return true;
                count++;
            }
        }
        return false;
    }

    /*
        Search if the needle pattern is found from a specific index in the haystack
     */
    public static boolean search(Integer index, List<Character> haystack, Map<Character, Integer> needle) {

        if (needle.size() == 0) return true;
        int iter = index;

        //Search through and to the left side of the index
        while (iter>=0 && needle.size()>0) {
            if(needle.containsKey(haystack.get(iter)))
                updateMap(needle,haystack, iter);
            else
                iter =0;
            iter--;
        }
        //Search through the right side of the index
        if (needle.size() > 0) {
            iter = index + 1;
            while (iter<haystack.size() && needle.containsKey(haystack.get(iter)) && needle.size()>0) {
                updateMap(needle,haystack, iter);
                iter++;
            }
        }
        //The entire contents of the needle are found. A solution is found
        if (needle.size() == 0)
            return true;
        else
            return false;
    }

    /*
        Every time a character in a Needle is matched with a character in haystack, reduce it's occurance by 1 (or remove it if there are no more occurrences left to document
     */
    public static void updateMap(Map<Character, Integer> needle, List<Character> haystack, int iter) {
        Integer numberOfInstances = needle.get(haystack.get(iter));
        if (numberOfInstances > 1) {
            numberOfInstances--;
            needle.put(haystack.get(iter), numberOfInstances);
        } else
            needle.remove(haystack.get(iter));
    }

    /*
    Converts the needle chars to a HashMap for an efficient & convenient lookup. Key is the Character & the Value is the number of occurences of that character
     */
    public static Map<Character, Integer> toMap(String needleStr) {

        Map<Character, Integer> map = new HashMap<>();

        needleStr.chars().forEach(c -> {
            int count = 1;
            if (map.containsKey(c))
                count = map.get(c) + 1;
            map.put((char) c, count);
        });
        return map;
    }

    /*
    Finds all the occurences of a character in a List of characters
     */
    public static List<Integer> findIndexesOf(Character firstChar, List<Character> haystack) {

        List<Integer> matchList = new ArrayList<>();
        for (int i = 0; i < haystack.size(); i++) {

            if (haystack.get(i) == firstChar)
                matchList.add(i);
        }
        return matchList;
    }

    /*
    Data validation of a String
     */
    public static boolean empty(String str){
      if(str == null || str.trim().length() == 0)
          return true;
      else
          return false;
    }


}
