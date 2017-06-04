package net.batchu.exercises;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Prashanth Batchu on 6/3/2017.
 */
public class SequenceFinderTest {
    @Test
    public void findSequence_shouldReturnEmptyArrayOnEmptyInput() {
        int[] sequence = SequenceFinder.findSequence(new int[0]);
        assertEquals(sequence.length, 0);
    }

    @Test
    public void findSequence_shouldReturnArrayOfSizeOneOnAllUniqueInputs() {
        int[] arr = {1, 3, 6, 9, 2, 15, 64};
        int[] sequence = SequenceFinder.findSequence(arr);
        assertEquals(sequence.length, 1);
    }

    @Test
    public void findSequence_shouldReturnLargestPatternOnInputWithMultiplePatterns() {
        int[] arr = {1, 6, 2, 3, 4, 8, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] sequence = SequenceFinder.findSequence(arr);
        assertEquals(sequence.length, 10);
        assertEquals(sequence[0], 6);
        assertEquals(sequence[sequence.length - 1], 15);
    }

    @Test
    public void findSequence_shouldReturnLargestPatternWhenItsAtTheEndOfInput() {
        int[] arr = {1, 6, 2, 3, 4, 5, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] sequence = SequenceFinder.findSequence(arr);
        assertEquals(sequence.length, 10);
        assertEquals(sequence[0], 11);
        assertEquals(sequence[sequence.length - 1], 20);
    }

}