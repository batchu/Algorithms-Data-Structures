import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.*;

public class Contacts {

    public static void main(String[] args) {
        Trie trie = new Trie();
   /*     Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> sol = new ArrayList<>(n / 2);
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            switch (op) {
                case "add":
                    trie.insert(contact);
                    break;
                case "find":
                    sol.add(trie.patternMatches(contact));
                    break;
                default:
                    throw new IllegalArgumentException("Unable to recognize the operation");
            }
        }
        printSolution(sol);*/
    trie.insert("hack");
    trie.insert("hacker");
    trie.insert("hackerrank");

        System.out.println(trie.patternMatches("hack"));

    }

    private static void printSolution(List<Integer> sol) {
        if (sol == null) return;
        for (int x : sol) {

            System.out.println(x);
        }
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');

    }

    public void insert(String s) {

        char[] c = s.toCharArray();
        TrieNode cursor = root;
        for (int i = 0; i < c.length; i++) {
            TrieNode trieNodeLookup = cursor.getChildren().get(c[i]);
            if (trieNodeLookup == null) {
                TrieNode newChild = new TrieNode(c[i]);
                cursor.getChildren().put(c[i], newChild);
                cursor=newChild;
            } else
                cursor = trieNodeLookup;
            if(i==c.length-1)
                trieNodeLookup.isLeaf=true;
        }
    }

    public int patternMatches(String s) {
        char[] c = s.toCharArray();
        TrieNode cursor = root;

        if(root.getChildren().isEmpty() || root.getChildren().get(c[0])==null) return 0;

        for(int i=0;i<c.length;i++)
        {
            if(cursor.getChildren().get(c[i])!=null)
                cursor=cursor.getChildren().get(c[i]);


        }

    }

    public void printTrie(){
        if(root==null) return;
        Queue<TrieNode> q = new LinkedList<>();
         q.offer(root);
         while(!q.isEmpty()){
             TrieNode trieNode = q.poll();
            Map<Character, TrieNode> children = trieNode.getChildren();
             children.entrySet().forEach(child-> {
                 System.out.printf("%c\t",child.getValue().data.charValue());
                 q.offer(child.getValue());
             });
            System.out.print('\n');
         }

    }
}


class TrieNode {
    Character data;
    Map<Character, TrieNode> children;
    boolean isLeaf;

    public TrieNode(char data) {
        this.children = new HashMap();
        this.data=data;
    }

    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }
}
