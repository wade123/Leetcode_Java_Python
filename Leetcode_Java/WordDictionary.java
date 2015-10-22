class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf;
    TrieNode(char val) {
        this.val = val;
    } 
    TrieNode() {}
}

public class WordDictionary {
    private TrieNode root;

    WordDictionary() {
        this.root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, this.root);
    }

    public boolean search(String word, TrieNode node) {
        if (word == null) {
            return false;
        }
        if (word.length() == 0 && node.isLeaf) {
            return true;
        }
        char[] letters = word.toCharArray();
        TrieNode cur = node;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && search(word.substring(i + 1, letters.length), child)) {
                        return true;
                    }
                }
                return false;
            } else if (cur.children[letters[i] - 'a'] != null) {
                cur = cur.children[letters[i] - 'a'];
            } else {
                return false;
            }
        }
        return cur.isLeaf;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("a."));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");