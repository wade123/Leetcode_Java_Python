class TrieNode {
    // Initialize your data structure here.
    char val;
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf;
    TrieNode(char val) {
        this.val = val;
    } 
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] letters = word.toCharArray();
        TrieNode node = this.root;
        for (int i = 0; i < letters.length; i++) {
            int position = letters[i] - 'a';
            if (node.children[position] == null) {
                node.children[position] = new TrieNode(letters[i]);
            }
            node = node.children[position];
            if (i == letters.length - 1) {
                node.isLeaf = true;
            }
        } 
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] letters = word.toCharArray();
        TrieNode node = this.root;
        for (int i = 0; i < letters.length; i++) {
            int position = letters[i] - 'a';
            if (node.children[position] == null) {
                return false;
            }
            node = node.children[position];
        }
        return node.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        char[] letters = prefix.toCharArray();
        TrieNode node = this.root;
        for (int i = 0; i < letters.length; i++) {
            int position = letters[i] - 'a';
            if (node.children[position] == null) {
                return false;
            }
            node = node.children[position];
        }
        return true;  
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcde");
        System.out.println(trie.search("abc"));
        trie.insert("abc");
        System.out.println(trie.search("abc"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");