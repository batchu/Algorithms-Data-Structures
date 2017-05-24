package net.batchu.exercises;

import net.batchu.exercises.ds.DoublyLinkedList;

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

        //Should be true
        System.out.println(checkIfPalindrome(strList));
    }

    public static boolean checkIfPalindrome(DoublyLinkedList<Character> list) {
        Character head = list.removeFirst();
        Character tail = list.removeLast();

        //Starting from 0. So no need to do (list.size()+1)/2
        for (int i = 0; i <= list.size() / 2; i++) {
            if (head != tail)
                return false;
            head = list.removeFirst();
            tail = list.removeLast();
        }
        return true;
    }

}
