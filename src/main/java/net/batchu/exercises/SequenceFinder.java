package net.batchu.exercises;

import java.util.Arrays;

/**
 * Created by Prashanth Batchu on 6/3/2017.
 */

//Refer to SequenceFinderTest.java for Unit Tests
public class SequenceFinder {

    public static int[] findSequence(int[] arr) {


        // There may be more than one sequence that fit the pattern. So we need to track the current sequence in play and the largest of all historical sequences.

        int start, end, currStart, currEnd;
        start = end = currStart = currEnd = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            //Check if (i+1)th element fits the pattern
            if (arr[i] == arr[i + 1] - 1) {
                if (currEnd == 0)
                    currStart = i;
                currEnd = i + 1;
            } else
                currEnd = 0; // Reset the current range End tracker

            //Check if the current range is greater than the largest previously recorded range
            if (currEnd - currStart > end - start) {
                start = currStart;
                end = currEnd+1;
            }

        }

        //Ideally I'd prefer to return the start and end range numbers instead of making a copy of the original collection as it's not efficient for large inputs
        //Depends on the requirements. I'm assuming that any "one" ele can be returned if there are no two contiguous elements that fit the pattern
        if (end == 0)
            end++;
        return Arrays.copyOfRange(arr, start, end);
    }

    public static void printArr(int[] arr){
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
    }


}
