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

//        int[] denominations = {1, 2, 3};
//        int[] denominations = {2, 5, 3, 6};
        int[] denominations = {1, 5, 10, 25, 50};

        int cost = 60;
        int paid = 75;

        int change = paid - cost;

        Map<Integer, List<Integer>> solList = new HashMap<>(denominations.length);

        int solutions = coinChange(denominations, change,0);

        System.out.println("Total Solutions "+solutions);

    }


    public static int coinChange(int[] denominations, int change, int index) {


        if (index >= denominations.length)
            return 0;

        int diff = change - denominations[index];

        if(diff<0)
            return 0;

        if (diff == 0){
            return 1;
        }


        int selfSols = coinChange(denominations,diff, index);
        int remainingSols = coinChange(denominations,change, index + 1);
        return  selfSols + remainingSols;

    }

    private static void print(List<Integer> solArray) {
        for(int i: solArray)
            System.out.print(i+" ");
        System.out.println();
    }

}
