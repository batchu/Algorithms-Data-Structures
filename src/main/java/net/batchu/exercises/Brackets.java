package net.batchu.exercises;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by i1551 on 3/30/2017.
 */

public class Brackets {

    public static boolean isBalanced(String s) {

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {

            if(isOpener(s.charAt(i)))
                st.push(s.charAt(i));
            else
            {
                char o = st.pop();
                if(!match(o,s.charAt(i)))
                    return false;
            }
        }

        if (st.size() == 0)
            return true;
        else
            return false;

    }

    public static boolean isOpener(char c){

        if(c=='{' || c=='[' || c=='(')
            return true;
        return false;
    }

    public static boolean match(char x, char y){

        if(x=='{' && y=='}')
            return true;
        if(x=='[' && y==']')
            return true;
        if(x=='(' && y==')')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
