import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by uhsarp on 5/13/2017.\
 * This is to calculate all the possible solutions using Dynamic Programming and Memoization
 */
public class CoinChangeAll {

    public static void main(String... args) {

        long[] denominations = {1, 5, 10, 25, 50};

        long cost = 60;
        long paid = 75;

        long change = paid - cost;

        Map<Integer, List<Integer>> solList = new HashMap<>(denominations.length);

        long solutions = coinChange(denominations, change, 0, new HashMap<String, Long>());

        System.out.println("Total Solutions "+solutions);

    }

    static long coinChange(long[] coins, long money, int index, HashMap<String, Long> map) {

        if (money == 0)
            return 1;

        if (index >= coins.length)
            return 0;

        String key = index+"-"+money;
        if(map.get(key)!=null)
            return map.get(key);
        long amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money) {
            long remaining = money - amountWithCoin;
            ways += coinChange(coins, remaining, index + 1, map);
            amountWithCoin += coins[index];
        }
        map.put(key, ways);
        return ways;

    }


}
