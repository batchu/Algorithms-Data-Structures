package net.batchu.exercises;

/**
 * Created by me on 1/8/2017.
 */
public class MyRuler {
    public static void main(String args[]){

        drawRuler(1,5);

    }

    private static void drawRuler(int nInches, int majorLength) {

        drawLine(majorLength, 0);
        for(int i=0;i<nInches;i++){
        drawInterval(majorLength-1);
        drawLine(majorLength, i);
        }

    }

    private static void drawInterval(int centralLength) {

        if(centralLength>=0)
        {
            drawInterval(centralLength -1); // recursively draw top interval
            drawLine(centralLength); // draw center tick line (without label)
            drawInterval(centralLength -1); // recursively draw bottom interval
        }

    }


    private static void drawLine(int maxTicklength, int lineNumber) {
        for(int i=0;i<maxTicklength;i++)
            System.out.print("-");
        if(lineNumber>=0)
            System.out.print(lineNumber);
        System.out.println();
    }

    private static void drawLine(int maxTicklength) {

        drawLine(maxTicklength, -1);
    }
}
