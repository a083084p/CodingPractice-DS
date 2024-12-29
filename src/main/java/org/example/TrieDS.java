package org.example;

public class TrieDS {

    static class TrieNode {
        TrieNode[] children;
        boolean eow;

        public TrieNode() {
            children = new TrieNode[26];
            for (int i=0; i<26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static TrieNode root = new TrieNode();

    public static void insert(String word) {
        TrieNode current = root;

        for (int i=0; i<word.length(); i++) {
            int indx = word.charAt(i) - 'a';

            if (current.children[indx] == null) {
                current.children[indx] = new TrieNode();
            }

            if (i == word.length()-1) {
                current.children[indx].eow = true;
            }

            current = current.children[indx];
        }
    }

    public static boolean search(String key) {
        TrieNode current = root;

        for (int i=0; i<key.length(); i++) {
            int indx = key.charAt(i) - 'a';
            TrieNode node = current.children[indx];

            if (node == null) {
                return false;
            }

            if (i == key.length() - 1 && !node.eow) {
                return false;
            }

            current = current.children[indx];
        }

        return true;
    }

    public static boolean startsWith(String prefix) {
        TrieNode current = root;

        for (int i=0; i<prefix.length(); i++) {
            int indx = prefix.charAt(i) - 'a';

            if (current.children[indx] == null) {
                return false;
            }

            current = current.children[indx];
        }

        return true;
    }

    public static int countNode (TrieNode node) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        for (int i=0; i<26; i++) {
            if (node.children[i] != null) {
                count = count + countNode(node.children[i]);
            }
        }
        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(TrieNode root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i=0; i<26; i++) {
            if (root.children[i] != null && root.children[i].eow) {
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }


    public static void main(String[] args) {

        String words[] = {"Trie", "startsWith"};

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }



//        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
//
//        for (int i=0; i<words.length; i++) {
//            insert(words[i]);
//        }
//
//        longestWord(root, new StringBuilder(""));
//        System.out.println(ans);


//        String str = "ababa";
//
//        for (int i=0; i<str.length(); i++) {
//            String suffix = str.substring(i);
//            insert(suffix);
//        }
//
//        System.out.println(countNode(root));

    }

}
