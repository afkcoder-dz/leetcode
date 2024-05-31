package com.java.leetcode.tree;

//public class Trie {
//    List<String> list;
//    public Trie() {
//       list = new ArrayList<>();
//    }
//
//    public void insert(String word) {
//        list.add(word);
//    }
//
//    public boolean search(String word) {
//       return list.contains(word);
//    }
//
//    public boolean startsWith(String prefix) {
//       for(String str : list) {
//           if(str.startsWith(prefix)) return true;
//       }
//       return false;
//    }
//}

class Trie {
   private final TrieNode root;

   static class TrieNode{
       public TrieNode[] children;
       public boolean isEndOfWord;

       public TrieNode(){
           children = new TrieNode[26];
           isEndOfWord = false;
       }
   }

    public Trie(){
       root = new TrieNode();
    }



    public void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a'; // Convert a-z to 0-25
            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }


    public boolean search(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a'; // Convert a-z to 0-25
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }


    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            int index = c - 'a'; // Convert a-z to 0-25
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }


    // Main method to test the Trie
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // Output: true
        System.out.println(trie.search("app"));     // Output: false
        System.out.println(trie.startsWith("app")); // Output: true

        trie.insert("app");
        System.out.println(trie.search("app"));     // Output: true
    }
}
