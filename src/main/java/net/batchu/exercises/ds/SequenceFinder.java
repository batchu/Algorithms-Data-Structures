package net.batchu.exercises.ds;

import java.util.Arrays;

public class SequenceFinder {


    public  int[] extractSequence(int[] arr) {

        int start, end, currStart, currEnd;
        start = end = currStart = currEnd = 0;


        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1] - 1) {
                if (currEnd == 0)
                    currStart = i;
                currEnd = i + 1;
            } else
                currEnd = 0;

            if (currEnd - currStart > end - start) {
                start = currStart;
                end = currEnd;
            }

        }

        return Arrays.copyOfRange(arr, start, end);

    }


}
