package hashtable;

import java.util.LinkedList;

public class HashTable {
    static class MyMapNode {
        String key;
        int value;

        public MyMapNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hash_table");
        System.out.println("To be or not to be");
        String sentence = "To be or not to be";
        String[] words = sentence.toLowerCase().split(" ");

        LinkedList<MyMapNode>[] hashTable = new LinkedList[10]; // Size of hash table

        // Initialize the hash table
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }

        // Calculate frequency of words
        for (String word : words) {
            int index = getHash(word);

            LinkedList<MyMapNode> list = hashTable[index];
            boolean found = false;

            for (MyMapNode node : list) {
                if (node.key.equals(word)) {
                    node.value++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                list.add(new MyMapNode(word, 1));
            }
        }

        // Display the frequency of words
        for (LinkedList<MyMapNode> list : hashTable) {
            if (list.isEmpty()) {
                continue;
            }

            for (MyMapNode node : list) {
                System.out.println(node.key + ": " + node.value);
            }
        }
    }

    /*  Using a ternary operator It allows you to evaluate a condition and choose one of two expressions
    based on the result of the condition.*/

    private static int getHash(String word) {
        return (word.hashCode() % 10) >= 0 ? (word.hashCode() % 10) : -(word.hashCode() % 10);
    }

}
