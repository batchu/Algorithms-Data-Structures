package net.batchu.exercises;

/**
 * Created by i1551 on 1/11/2017.
 */
public class Fibonacci {

    public static void main(String... args) {

        long[] sol = fibonacci(5);

            for(long x: sol)
            {
                System.out.println(x);
            }
    }


    private static long[] fibonacci(int n) {

        if (n <=1) {
            long[] answer = {n, 0};
            return answer;
        }
        else {
            long[] temp = fibonacci(n - 1);
            long[] answer = {temp[0]+temp[1],temp[0]};
            return answer;
        }
    }
}
