/**
 * Created by uhsarp on 5/13/2017.\
 * This is to calculate all the possible solutions using Dynamic Programming and Memoization
 */
public class CoinChangeAll {

    public static void main(String... args) {

//        int[] denominations = {1, 2, 3};
        int[] denominations = {1, 5, 10, 25, 50, 100};

        int cost = 60;
        int paid = 75;

        int change = paid - cost;

        System.out.println("Ways =" + coinChange(denominations, change, 0));
    }

    public static int coinChange(int[] denominations, int rem, int index) {
        int diff = rem - denominations[index];

        if (index >= denominations.length || diff < 0)
            return 0;

        if (diff == 0)
            return 1;

        return  coinChange(denominations, diff, index) + coinChange(denominations, rem, index + 1);

    }

}
