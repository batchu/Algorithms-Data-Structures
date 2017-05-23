import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HayStack {

    public boolean isNeedInTheHayStack(String needleStr, String haystackStr) {

        Map<Character, Integer> needle = toMap(needleStr);
        ImmutableList<Character> haystack = Lists.charactersOf(haystackStr);

        return find(needle, haystack, needleStr.charAt(0));
    }

    private Map<Character, Integer> toMap(String needleStr) {

        Map<Character, Integer> map = new HashMap<>();

        needleStr.chars().forEach(c -> {
            int count = 1;
            if (map.containsKey(c))
                count = map.get(c) + 1;
            map.put((char) c, count);
        });
        return map;
    }

    private boolean find(Map<Character, Integer> needle, ImmutableList<Character> haystack, Character firstChar) {

        List<Integer> occurances = findIndexesOf(firstChar, haystack);

        switch (occurances.size()) {
            case 0:
                return false;
            case 1:
                return true;
        }

        for (int index : occurances) {

            Integer count = 0;
            while (count < needle.size()) {
                if (search(index, haystack, needle, Direction.LEFT))
                    return true;

            }

        }
        return false;

    }

    private boolean search(Integer index, ImmutableList<Character> haystack, Map<Character, Integer> needle, Direction direction) {

        //Base case: Solution Found
        if (needle.size() == 0) return true;

        //Base Case: Needle is not present in the Haystack
        if (!needle.containsKey(haystack.get(index)))
            return false;

        Integer numberOfInstances = needle.get(haystack.get(index));
        if (numberOfInstances > 1) {
            numberOfInstances--;
            needle.put(haystack.get(index), numberOfInstances);
        } else
            needle.remove(haystack.get(index));

        if(index==0 || )


    }

    public enum  Direction {LEFT, RIGHT};

    private List<Integer> findIndexesOf(Character firstChar, ImmutableList<Character> haystack) {

        List<Integer> matchList = new ArrayList<>();
        for (int i = 0; i < haystack.size(); i++) {

            if (haystack.get(i) == firstChar)
                matchList.add(i);
        }
        return matchList;
    }

}
