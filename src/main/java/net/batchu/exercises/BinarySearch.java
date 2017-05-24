package net.batchu.exercises;

/**
 * Created by me on 1/8/2017.
 */
public class BinarySearch {

    public static void main(String args[]){

        int[] a={3,5,9,10,17,18,22,29,36,40,60,75,90};

        int foundIndex=-1;

        if(a[a.length-1]>75)
        foundIndex = mybinarySearch(a,75,0,a.length-1);

        System.out.println(foundIndex);
    }

    private static int mybinarySearch(int[] data,int target, int low, int high) {

        if(low>high)
            return -1;
        else{
            int mid = (low + high)/2;
            if(target==data[mid])
                return mid;
           else if(target<data[mid])
               return mybinarySearch(data,target,low, mid-1);
            else
                return mybinarySearch(data,target, mid+1, high);
        }

    }
}
