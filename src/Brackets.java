import net.batchu.datastructures.LinkedStack;
import net.batchu.datastructures.Stack;

/**
 * Created by i1551 on 3/30/2017.
 */
public class Brackets {

    public static void main(String... args) {

        String s = "[{}]";

        System.out.println(isBalanced(s));
    }


    public static boolean isBalanced(String s) {

        Stack<Character> st = new LinkedStack<>();

        for (int i = 0; i < s.length(); i++) {

            if (isOpener(s.charAt(i)))
                st.push(s.charAt(i));
            else {
                char o = st.pop();
                if (o != s.charAt(i))
                    return false;
            }
        }

        if (st.size() == 0)
            return true;
        else
            return false;

    }

    public static boolean isOpener(char c) {

        if (c == '{' || c == '[' || c == '(')
            return true;
        return false;
    }


}
