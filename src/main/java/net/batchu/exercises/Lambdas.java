package net.batchu.exercises;

/**
 * Created by i1551 on 12/27/2016.
 */
public class Lambdas {
    public static void main(String[] args) {

        /*List<String> names = Arrays.asList("Joe","Abe","Peter","Zulu","Bates");

        Collections.sort(names,(a, b)->(a.compareTo(b)));
        names.
                stream().filter((c)->c.endsWith("e")).
                forEach(System.out::println);*/

        System.out.println(factorial(5));

    }

    public static long factorial(long n){

        if(n<1) {
            return 0L;
        }
        if (n == 1)
            return 1L;

            return n * factorial(n - 1);
    }
}

