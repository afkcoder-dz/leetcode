package com.java.leetcode.tree;

public class WordDictionary {
    private final Node root;

    public static class Node {
        Node[] children;
        boolean isEndOfWord;

        Node() {
            this.children = new Node[26];
            this.isEndOfWord = false;
        }
    }

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(root, word);
    }

    public boolean search(Node node, String word) {
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if (c == '.') {
                for (Node n : node.children) {
                    if ( n != null && search(n, word.substring(i+1))) return true;
                }
                return false;
            } else {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
        }
      return node.isEndOfWord;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println( wordDictionary.search("a"));
        System.out.println( wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }

    /*
    public class WordDictionary {

        public class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isWord;
        }

        private TrieNode root = new TrieNode();

        // Adds a word into the data structure.
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }

        private boolean match(char[] chs, int k, TrieNode node) {
            if (k == chs.length) {
                return node.isWord;
            }
            if (chs[k] == '.') {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null && match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            } else {
                return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
            }
            return false;
        }
    }
*/
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
}
