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
            for(int j=0;j<i;j++){
                if(a[j]>a[i])
                {
                    int temp = a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
        }
        return a;

    }
}
