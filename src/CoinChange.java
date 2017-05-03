import javax.xml.crypto.NoSuchMechanismException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by i1551 on 5/2/2017.
 */
public class CoinChange {

    public static void main(String... args) throws IllegalStateException {

        //available denominations. This is always sorted ASC
        int[] denominations = {1,5,10,25,50,100};

        int cost=70;
        int paid=75;

        ArrayList<Integer> solution = new ArrayList<>();
        calcChange(solution, paid-cost, denominations);

        solution.forEach(i-> System.out.println(i));

    }
    public static void calcChange(List<Integer> sol, int diff, int[] denominations) throws IllegalStateException {

        if(diff<0) throw new IllegalStateException(String.format("Paid less than cost of the product."));
        //Found the solution.
        if(diff==0) return;

        //Find the highest denomination that's slightly lower than diff
        int highestMatchingDenomination = 0;
        //This complexity can be reduced from O(n) to O(logn) using binary search.
        for(int i=denominations.length-1;i>=0;i--)
        {
            if(denominations[i]<=diff){
                highestMatchingDenomination=denominations[i];
                break;
            }
        }

        if(highestMatchingDenomination>0)
            sol.add(highestMatchingDenomination);
        if(highestMatchingDenomination==0)
           throw new IllegalStateException("No solution available");
        calcChange(sol,diff-highestMatchingDenomination, denominations );
    }



}

