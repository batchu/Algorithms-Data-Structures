/**
 * Created by uhsarp on 5/21/2017.
 */
public class MaxProfit {
/*
    The algorithm used for the implementation is - set 2 variables called highest and lowest
    Where lowest points to the lowest value in the array and highest is determined based on the position of lowest, to the end of the array
    so, if the lowest position is greater than the highest value's position, reset highest to zero until the next highest is found in the array
    Finally calculate margin by subtracting the difference from highest and lowest
*/
    public static void main(String... args) {

        int[] profitValues = new int[]{5, 27, 1, 3, 23, 2, 17};
    FetchBestCombo(profitValues);
    }

    private static void FetchBestCombo(int[] profitValues) {
        int lowest, highest, margin,newHighest=0,newLowest=0;

        lowest = profitValues[0];
        highest = profitValues[0];
        margin = 0;

        for (int val = 1; val < profitValues.length; val++) {
            if (profitValues[val] > highest) {
                highest = profitValues[val];
            } else if (profitValues[val] < lowest) {
                lowest = profitValues[val];
                highest = 0;
            }
              if (margin <= (highest - lowest)) {
                newHighest = highest;
                newLowest = lowest;
                margin = highest - lowest;
            }
        }

        System.out.println(String.format("Buy at $%s and sell at $%s to make a maximum profit of $%s.", newLowest, newHighest, margin));
    }
}

