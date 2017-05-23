

/**
 * Created by i1551 on 1/9/2017.
 */
public class Reverse {

    public static void main(String args[]) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        reverse(a, 0, a.length - 1);

        for (int b : a) {
            System.out.print(b + " ");
        }


        System.out.println("Power of 2 ^ 5 is " + power(2, 5));
        ;
    }

    private static int power(int base, int exponent) {

        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        int partial = power(base, exponent / 2);

        int result = partial * partial;

        if (exponent % 2 == 0) {
            return result;
        } else {
            return result * base;
        }
    }

    private static void reverse(int[] a, int low, int high) {

        if (high != low) {
            swap(a, low, high);
            reverse(a, low + 1, high - 1);
        } else
            return;
    }

    private static void swap(int[] a, int low, int high) {

        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }
}
