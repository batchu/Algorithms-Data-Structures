package net.batchu.exercises;

/**
 * Created by me on 12/25/2016.
 */
public  class Stars {

    public static void main(String[] args) {

        createStars(10);

    }

    public static void createStars(int size){

        int m = size;
        int n = size*2-1;
        char[][] arr = new char[m][n];
        fill(arr, ' ');
        for(int x =0; x<arr.length;x++)
        {
            int numberOfStars = x*2+1;
            int center = n/2;
            int y=center - numberOfStars/2;
            while(y<=center+numberOfStars/2){
                arr[x][y]='*';
                y++;
            }
        }
        print(arr);
    }

    public static void print(char[][] arr){

        for(int i =0; i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println("\n");
        }

    }

    public static void fill(char[][] arr, char fillerMaterial){

        for(int i =0; i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                arr[i][j]=fillerMaterial;
            }
            System.out.println("\n");
        }

    }
}
