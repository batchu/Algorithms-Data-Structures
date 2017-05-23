public class Main {

    public static void main(String[] args) {
    StockAdvisor advisor = new StockAdvisor();

        double[] arr={5, 27, 1, 3, 17, 2, 17};
        System.out.println(advisor.advise(arr));

    }

    public static int[] insertion(int[] a){

        for(int i=0;i<a.length;i++){
            int curr = a[i];
            int j = i;

            while(j>0&& a[j-1]>curr){
                a[j] = a[j-1];
                j--;
            }
            a[j]=curr;

        }
        return a;

    }



}
