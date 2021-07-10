package algorithm.string.trie;

public class Trie {
    
    static TrieNode root;
    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();

        for(String k : keys) {
            insert(k);
        }

        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
      
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
        
        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
        
        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);    
        
    }

    static class TrieNode {
        
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;

        TrieNode() {
            isEnd = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static void insert(String key) {
        TrieNode parent = root;

        for(int i = 0; i < key.length(); i++) {
            int ascii = key.charAt(i) - 'a';
            
            if(parent.children[ascii] == null) {
                parent.children[ascii] = new TrieNode();
            }

            parent = parent.children[ascii];
        }

        parent.isEnd = true;
    }

    static boolean search(String key) {
        TrieNode parent = root;

        for(int i = 0; i < key.length(); i++) {
            int ascii = key.charAt(i) - 'a';

            if(parent.children[ascii] == null) {
                return false;
            }

            parent = parent.children[ascii];
        }

        return parent != null && parent.isEnd;
    }
}
