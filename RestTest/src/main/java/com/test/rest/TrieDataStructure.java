package com.test.rest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class TrieDataStructure {

	
    private static final int R = 256;        // extended ASCII
    private static final Object VALUE = new Object();

    private Node root;      // root of trie
    private int n;          // number of keys in trie

    // R-way trie node
    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }


	public TrieDataStructure() {

		root = null;
	}



	
    public void put(String key) {
        root = put(root, key, VALUE, 0);
    }

    private Node put(Node x, String key, Object val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.val == null) n++;
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
    
    public int size() {
        return n;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public List<String> keys() {
        return keysWithPrefix("");
    }
    
    @SuppressWarnings("unchecked")
	public List<String> keysWithPrefix(String prefix) {
        Queue<String> results = new LinkedList<String>();
        Node x = get(root, prefix, 0);
        if(x!=null)
        	collect(x, new StringBuilder(prefix), results);
        return (List<String>) results;
    }

    private void collect(Node x, StringBuilder prefix, Queue<String> results) {
        if (x == null) return;
        if (x.val != null) results.add(prefix.toString());
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public Node get(String key) {
        return get(root, key, 0);

    }
    


    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    
    
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val != null) n--;
            x.val = null;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        // remove subtrie rooted at x if it is completely empty
        if (x.val != null) return x;
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }
    
    

	/*public static void main(String[] args) {
		
		DataAccesor d = new DataAccesor();
		
		
		for (String str : d.trie.keysWithPrefix("")) {
			System.out.println(str);
		}
		
		
	}*/
}
 
