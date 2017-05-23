import java.util.HashSet;
import java.util.Set;

/**
 * Created by i1551 on 3/30/2017.
 */
public class BST {

    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {


        Set<Integer> set = new HashSet<>();
        Integer l = 0;
        boolean valid = traverse(root, set, l);
        return valid;

    }

    boolean traverse(Node node, Set set, Integer l) {

        if (node.left != null) {
            if (node.left.data > node.data)
                return false;
            set.add(node.data);
            if (set.size() == l)
                return false;
            l++;

            traverse(node.left, set, l);
        }
        if (node.right != null) {
            if (node.right.data < node.data)
                return false;
            set.add(node.data);
            if (set.size() == l)
                return false;
            l++;
            traverse(node.right, set, l);
        }

        return true;


    }

}

