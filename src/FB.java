public class FB {
    public static void main(String... args){
        int[] stocks = {25,30,48,15,25,45,10,25};
        aVoid(stocks);
    }
    private static void aVoid(int[] array){
        //Say that you buy on the first day (index 0)
        int buy=array[0];
        //lowest element in the array
        int lowest= array[0];
        int highest=array[0];
        //assume that you sell on day two to start with
        int sell = array[1];
        //Let's assume that the initial profit is from buying on day one and selling on day two
        int profit=0;
        //Start from day two

        for(int i=1;i<array.length;i++){
            if(array[i]-buy>profit)
            {
                sell =array[i];
                profit = array[i]-buy;
            }
        }
        System.out.println(String.format("Buy at %s, Sell at %s to make the highest profit of %s", buy, sell, profit));
    }
}

/*
Assume that you should buy the first item in the loop.
Assume that you start with a profit of zero
While iterating through the remaining items, for each item
	Check the profit if you sell on that day for the day's price.
	if this profit is higher than the currently assumed profit, then
		Set the buy as the value at the current index
		Update the profit to the current profit


*/