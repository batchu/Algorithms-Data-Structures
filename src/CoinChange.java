import java.util.ArrayList;
import java.util.List;

/**
 * Created by i1551 on 5/2/2017.
 */
public class CoinChange {

    public static void main(String... args){

        //available denominations. This is always sorted ASC
        int[] denominations = {5,10,25,50,100};

        int cost=60;
        int paid=75;

        ArrayList<Integer> solution = new ArrayList<>();
        calcChange(solution, paid-cost, denominations);

        solution.forEach(i-> System.out.println(i));

    }


//First call input values - sol is {}, cost is 60, paid is 75, denominations are {5,10,25,50,100};
//Making this function referentially transparent so that it has no side effects i.e embracing functional programming principles to make it reusable.
    public static void calcChange(List<Integer> sol, int diff, int[] denominations){

        if(diff<0) throw new IllegalStateException(String.format("Paid less than Cost."));
        //Found the solution.
        if(diff==0) return;

        //Find the highest denomination that's close to diff
        int highestMatchingDenomination = 0;
        //This complexity can be reduced using binary search. From n to log(n)
        for(int i=denominations.length-1;i>=0;i--)
        {
            if(denominations[i]<=diff){
                highestMatchingDenomination=denominations[i];
                break;
            }
        }

        if(highestMatchingDenomination!=0)
            sol.add(highestMatchingDenomination);

        calcChange(sol,diff-highestMatchingDenomination, denominations );
    }




}

