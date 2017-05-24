package net.batchu.exercises;

/**
 * Created by i1551 on 2/27/2017.
 */
public class FibonacciEfficient {

    public static void main(String[] args) {

        for(int i: fibonacci(10))
        {
            System.out.print(i+"\t");
        }
    }

    public static int[] fibonacci(int n) {

        int[] arr = new int[n];

        arr[0] = 0;
        if (n <= 1) return arr;

        for (int i = 2; i < n; i++) {

            if(i>2)
            arr[i] = arr[i-1]+ arr[i-2];
            else
                arr[i]=arr[i-1]+1;

        }

        return arr;
    }
}
