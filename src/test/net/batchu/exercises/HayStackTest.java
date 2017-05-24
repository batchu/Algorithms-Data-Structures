package net.batchu.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

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



    }

    @Test
    public void search() throws Exception {

    }

    @Test
    public void updateMap() throws Exception {

    }

    @Test
    public void toMap() throws Exception {

    }

    @Test
    public void findIndexesOf() throws Exception {

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