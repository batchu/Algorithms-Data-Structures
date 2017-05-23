import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

    /*
    The requirement for yesterday's assessment was for generating a single solution. So this class simply generates a single solution if available.
    However using Dynamic Programming, we can recursively generate all the possible solutions using the theorem from here http://www.ccs.neu.edu/home/jaa/CS7800.12F/Information/Handouts/dyn_prog.pdf
 Recursion Cases:
 C[p] =0 if p = 0
C[p] =min(i) n(i)[where d(i)≤p]{1 + C[p − d(i)]} if p > 0
     */
public class CoinChange {

    public static void main(String... args) throws IllegalStateException {

        //available denominations. This is always sorted ASC
        int[] denominations = {1, 5, 10, 25, 50, 100};

        //Trying to prevent resizing on the fly which would be expensive. The solution length will always be below denominations.length*2, although this number can be further accurately approximated if necessary for optimization

        ArrayList<Integer> solution = new ArrayList<>
                (denominations.length * 2);


        Random rand = new Random();
        //Randomly (Pseudo) generate test cases for up to 20 times on each execution
        IntStream.range(0, 30).forEach(i -> testCoinChange(solution, rand, denominations));


    }
//Randomly (Pseudo) generate cost and paid each time and print the solution. Sending in Refs to Solutin, Pseudo random number generator and our denomination list
    private static void testCoinChange(List<Integer> solution, Random rand, int[] denominations) {
        //reusing the same array instead of expensive re-initialization (re-allocation of new memory as the JVM has to request the OS for new blocks)
        solution.clear();
        int cost = rand.nextInt(50);
        int paid = cost + rand.nextInt(20);
        calcChange(solution, paid - cost, denominations);
        print(cost, paid, solution);
    }

    private static void print(int cost, int paid, List<Integer> solution) {
        System.out.print(String.format("Cost: %s, Paid: %s. Change: ", cost, paid));
        solution.forEach(i -> System.out.print(i + "\t"));
        System.out.println();
    }

    public static void calcChange(List<Integer> sol, int diff, int[] denominations) throws IllegalStateException {

        if (diff < 0) throw new IllegalStateException(String.format("Paid less than cost of the product."));
        //Base Case
        if (diff == 0) return;

        //Find the highest denomination that's slightly lower than diff
        int highestMatchingDenomination = 0;
        //This complexity can be reduced from O(n) to O(log(n)) using binary search.
        for (int i = denominations.length - 1; i >= 0; i--) {
            if (denominations[i] <= diff) {
                highestMatchingDenomination = denominations[i];
                break;
            }
        }

        //If a usable denomination is found, add it to the solution array
        if (highestMatchingDenomination > 0)
            sol.add(highestMatchingDenomination);
        //No denomination can be applied. So no solution exists.
        if (highestMatchingDenomination == 0)
            throw new IllegalStateException("No solution available");
        calcChange(sol, diff - highestMatchingDenomination, denominations);
    }


}

