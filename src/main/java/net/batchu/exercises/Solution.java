package net.batchu.exercises; /**
 * Created by i1551 on 3/30/2017.
 */

public class Solution {

    public static void main(String[] args) {
    /*    Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }*/
    int a[] = {1,2,3,4,5};
    int n=5;
    int k=4;

        rotate(a,n, k);
       print(a);
    }
    //n is size, k is the number of units to be shifted to the left
    public static void rotate(int[] orig,int n, int k){

        int[] arr = new int[n];
        int temp = 0;
        for(int i=0;i<n;i++)
        {
            int shift =(n+i-k)%n;
            arr[shift]=orig[i];
        }
        for(int i=0;i<arr.length;i++)
            orig[i]=arr[i];

    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }

}
