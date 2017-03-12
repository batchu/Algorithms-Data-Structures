public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] a = {3,6,8,1,9,15};

        int[] b = insertion(a);

    for(int c: b){
        System.out.println(c);
    }


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
