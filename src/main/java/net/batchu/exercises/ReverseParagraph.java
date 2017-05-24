package net.batchu.exercises;

/**
 * Created by me on 3/10/2017.
 */
public class ReverseParagraph {

    public static void main(String... args){

//        System.out.println(reverseParagraph("abcde"));
        System.out.println(reverseParagraph("This is New York!"));
        System.out.println(reverseParagraph("I Love you "));

    }

    public static String reverseParagraph(String str){
        char[] arr = str.toCharArray();
        for(int i=0,j=0; i<arr.length; i++){
            if(arr[i]==' '){
                reverse(arr, j,i-1); j=i+1;
            }
            if(i==arr.length-1){
                reverse(arr, j,i);
            }
        }
        return String.valueOf(arr);
    }

    public static void reverse(char[] arr, int low, int high){
        if(low<high){
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            reverse(arr,low+1, high-1);
        }

    }
}
