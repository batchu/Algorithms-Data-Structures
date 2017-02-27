import net.batchu.datastructures.DoublyLinkedList;

/**
 * Created by i1551 on 2/27/2017.
 */
public class DoublyLinkedListPalindrome {


    public static void main(String... args) {

        String str = "rotator";
        DoublyLinkedList<Character> strList = new DoublyLinkedList<>();
        for (char c : str.toCharArray()) {
            strList.addLast(c);
        }

        System.out.println(checkIfPalindrome(strList));
    }

    public static boolean checkIfPalindrome(DoublyLinkedList<Character> list) {
        Character headPointer = list.removeFirst();
        Character tailPointer = list.removeLast();

        for (int i = 0; i <= list.size() / 2; i++) {
            if (headPointer != tailPointer)
                return false;
            headPointer = list.removeFirst();
            tailPointer = list.removeLast();
        }
        return true;
    }

}
