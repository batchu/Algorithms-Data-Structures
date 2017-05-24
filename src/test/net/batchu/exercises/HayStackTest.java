package net.batchu.exercises;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HayStackTest {
    @Test
    public void isNeedleInTheHayStack_shouldReturnTrueWhenNeedleIsPresentInTheHayStack() throws Exception {

        assertEquals(HayStack.isNeedleInTheHayStack("654", "12345678"), true);
        assertEquals(HayStack.isNeedleInTheHayStack("abc", "abcdef"), true);
        assertEquals(HayStack.isNeedleInTheHayStack("bdc", "abcdef"), true);
        assertEquals(HayStack.isNeedleInTheHayStack("sam", "xmas"), true);
        assertEquals(HayStack.isNeedleInTheHayStack("saxm", "xmas"), true);
        assertEquals(HayStack.isNeedleInTheHayStack("s", "xmas"), true);
    }
      @Test
    public void isNeedleInTheHayStack_shouldReturnFalseWhenNeedleIsPresentInTheHayStack() throws Exception {

        assertEquals(HayStack.isNeedleInTheHayStack("adg", "abcdef"), false);
        assertEquals(HayStack.isNeedleInTheHayStack("xs", "xmas"), false);
        assertEquals(HayStack.isNeedleInTheHayStack("abcd", "xmas"), false);
        assertEquals(HayStack.isNeedleInTheHayStack("153", "12345678"), false);
        assertEquals(HayStack.isNeedleInTheHayStack("9", "12345678"), false);

    }

    @Test(expected = IllegalArgumentException.class)
    public void isNeedleInTheHayStack_shouldThrowExceptionOnInvalidInput1() throws Exception {
        HayStack.isNeedleInTheHayStack("", "abcdef");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNeedleInTheHayStack_shouldThrowExceptionOnInvalidInput2() throws Exception {
        HayStack.isNeedleInTheHayStack("asdfasdf", "");
    }
    @Test(expected = IllegalArgumentException.class)
    public void isNeedleInTheHayStack_shouldThrowExceptionOnInvalidInput3() throws Exception {
        HayStack.isNeedleInTheHayStack("", "");
    }

    @Test
    public void find() throws Exception {

        List<Character> haystack = "abcdef".chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Map<Character, Integer> needle = HayStack.toMap("abc");

        assertEquals(true, HayStack.find(needle,haystack, 'a'));
    }

    @Test
    public void search() throws Exception {

        List<Character> haystack = "abcdef".chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Map<Character, Integer> needle = HayStack.toMap("abc");

        assertEquals(true, HayStack.search(0,haystack, needle));

         haystack = "abcdef".chars().mapToObj(e -> (char) e).collect(Collectors.toList());
         needle = HayStack.toMap("abc");

        assertEquals(false, HayStack.search(5,haystack, needle));

    }

    @Test
    public void updateMap() throws Exception {

        List<Character> haystack = "abcdef".chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Map<Character, Integer> needle = HayStack.toMap("abc");
        HayStack.updateMap(needle, haystack, 0);
        assertEquals(needle.get('a'), null);

    }

    @Test
    public void toMap() throws Exception {

        Map<Character, Integer> map = HayStack.toMap("abcdef");
        assertEquals(map.get('a').intValue(), 1);
        assertEquals(map.get('k'), null);
    }

    @Test
    public void findIndexesOf() throws Exception {

        String car = "car";
        List<Integer> indexList = HayStack.findIndexesOf('c', car.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
        assertEquals(1, indexList.size());
        assertEquals(0, indexList.get(0).intValue());
    }

    @Test
    public void empty_ShouldReturnTrueWhenStringIsEmpty(){
        assertEquals(true, HayStack.empty(""));
    }
    @Test
    public void empty_ShouldReturnFalseWhenStringIsNotEmpty(){
        assertEquals(false, HayStack.empty("hello"));
    }

}