package net.batchu.exercises;

/**
 * Created by me on 1/8/2017.
 */
public class Ruler {

    public static void main(String[] args){
        drawRuler(1,5);
    }

    public static void drawRuler(int nInches,int majorLength){
        drawLine(majorLength,0); // draw inch 0line and label
        for(int j=1;j<=nInches;j++){
            drawInterval(majorLength -1); // draw interior ticks for inch
            drawLine(majorLength,j); // draw inch j line and label
        }
    }
    private static void drawInterval(int centralLength){
        if(centralLength>=1){ // otherwise, do nothing
            drawInterval(centralLength -1); // recursively draw top interval
            drawLine(centralLength); // draw center tick line (without label)
            drawInterval(centralLength -1); // recursively draw bottom interval
        }
    }
    private static void drawLine(int tickLength,int tickLabel){
        for(int j=0;j<tickLength; j++)
            System.out.print("-");
        if(tickLabel>=0)
            System.out.print(" "+tickLabel);
        System.out.print("\n");
    }
        /**∗∗ Draws a line with the given tick length(but no label). **/
    private static void drawLine(int tickLength){
        drawLine(tickLength, -1);
    }

}