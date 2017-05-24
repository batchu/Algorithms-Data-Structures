package net.batchu.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class HayStack {

    public static void main(String... args){

        System.out.println(isNeedleInTheHayStack("asx","xmas"));
    }

    public static boolean isNeedleInTheHayStack(String needleStr, String haystackStr) {

        if(empty(needleStr) || empty(haystackStr))
            throw new IllegalArgumentException("Please validate your inputs. Needle & Haystack strings must be valid");
        Map<Character, Integer> needle = toMap(needleStr);
        List<Character> haystack = haystackStr.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        return find(needle, haystack, needleStr.charAt(0));
    }

    public static boolean find(Map<Character, Integer> needle, List<Character> haystack, Character firstChar) {

        List<Integer> occurances = findIndexesOf(firstChar, haystack);

        if(occurances.size()==0)
            return false;
        for (int index : occurances) {
            Integer count = 0;
            while (count < needle.size()) {
                if (search(index, haystack, needle))
                    return true;
                count++;
            }
        }
        return false;
    }

    public static boolean search(Integer index, List<Character> haystack, Map<Character, Integer> needle) {

        if (needle.size() == 0) return true;
        int iter = index;

        while (iter>=0 && needle.size()>0) {
            if(needle.containsKey(haystack.get(iter)))
                updateMap(needle,haystack, iter);
            else
                iter =0;
            iter--;
        }
        if (needle.size()> 0)
        {
            iter = index + 1;
            while (iter<haystack.size() && needle.containsKey(haystack.get(iter)) && needle.size()>0) {
                updateMap(needle,haystack, iter);
                iter++;
            }
        }


        if (needle.size() == 0)
            return true;
        else
            return false;
    }

    public static void updateMap(Map<Character, Integer> needle,List<Character> haystack, int iter) {
        Integer numberOfInstances = needle.get(haystack.get(iter));
        if (numberOfInstances > 1) {
            numberOfInstances--;
            needle.put(haystack.get(iter), numberOfInstances);
        } else
            needle.remove(haystack.get(iter));
    }


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

    public static List<Integer> findIndexesOf(Character firstChar, List<Character> haystack) {

        List<Integer> matchList = new ArrayList<>();
        for (int i = 0; i < haystack.size(); i++) {

            if (haystack.get(i) == firstChar)
                matchList.add(i);
        }
        return matchList;
    }

    public static boolean empty(String str){
      if(str == null || str.trim().length() == 0)
          return true;
      else
          return false;
    }

}
