import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by uhsarp on 5/13/2017.\
 * This is to calculate all the possible solutions using Dynamic Programming and Memoization
 */
public class CoinChangeAll {

    public static void main(String... args) {

        int[] denominations = {1, 2, 3};
//        int[] denominations = {1, 5, 10, 25, 50, 100};

        int cost = 60;
        int paid = 75;

        int change = paid - cost;

        Map<Integer, List<Integer>> solList = new HashMap<>(denominations.length);

        System.out.println("Ways =" + coinChange(denominations, 4, 0, solList));
        printSolutions(solList);
    }

    private static void printSolutions(Map<Integer, List<Integer>> solList) {

    solList.entrySet().forEach(k-> {
        System.out.print("Solutions with "+k+ " ");
        k.getValue().forEach(j-> System.out.print(j + " "));
    });
    }

    public static int coinChange(int[] denominations, int rem, int index, Map<Integer, List<Integer>> solList) {
        int diff = rem - denominations[index];

        if (index >= denominations.length || diff < 0)
            return 0;

        if( solList.get(denominations[index]) == null)
            solList.put(denominations[index], new ArrayList<Integer>());

        if (diff == 0){
           solList.get(denominations[index]).add(denominations[index]);
            return 1;
        }

        return  coinChange(denominations, diff, index, solList) + coinChange(denominations, rem, index + 1, solList);

    }

}
