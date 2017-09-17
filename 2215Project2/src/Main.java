/**
 * Devon Vlcek
 * Programming Project 2
 * ITCS 2215-001
 * 
 * This project reads a text file, counts each character's
 * frequency in the file and then applies Huffman Encoding
 * to display the encoding for each character. 
 */


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
	public static int count = 0;
	
    public static void main(String[] args) throws IOException
    {
    	
        HashMap<Character, Integer> myFrequencies = new HashMap<Character, Integer>();
        
        /**
         *  Reading file, saving contents to a String
         */
        String str = "";
        Scanner input = new Scanner(new File("test.txt"));
        while(input.hasNext()){
            str = input.nextLine();
        }
        
        input.close();
        
        /**
         * Calculating the number of characters in the string
         * and the total number of bits used with ASCII symbols
         */
        int totalCharacters = str.toCharArray().length;
        int asciiBits = totalCharacters * 8;
        System.out.println("Total characters in string: " + totalCharacters);
        System.out.println("Total bits with ascii: " + asciiBits);
        
        /**
         * Placing each character from the text file into the hashmap
         * and incrementing its frequency as necessary
         */
        for(char c : str.toCharArray()){
        	if (myFrequencies.get(c) == null)
                myFrequencies.put(c, 1);
            else
            	myFrequencies.put(c, myFrequencies.get(c)+1);
        }
        
        
        
        /**
         * new LinkedList to hold Huffman tree
         */
        LinkedList<Node> myCandidates = new LinkedList<Node>();

        /**
         *loop through the hashmap
         *create a new Node, assign values for its letter and frequency values,
         *and add it to the myCandidates linked list
        */ 
        for (Character c : myFrequencies.keySet())
        {    
            char letter = c;
            int frequency = myFrequencies.get(c);
            Node newNode = new Node(letter, frequency);
            myCandidates.add(newNode);
        }

        /** Loop through the linked-list until size == 1
         * New Nodes are created from the 2 nodes with the current minimum
         * frequencies. The 2 minimum nodes are set as the new Node's children
         * and the new nodes frequency = the sum of its children's frequencies
         */
        
        while(myCandidates.size() > 1){
        	
        	Node min1 = returnMin(myCandidates);
        		myCandidates.remove(min1);
        		
        	Node min2 = returnMin(myCandidates);
    			myCandidates.remove(min2);
        	
        	
        	Node newNode = new Node();
        	newNode.setChildren(min1, min2);
        	newNode.setFrequency(min1.getFrequency()+min2.getFrequency());
        	myCandidates.add(newNode);

        }
        
        // Prints encoding starting with the root
        printEncoding(myCandidates.get(0));
        


    }

    /**
     * this method finds the node with the minimum
     * frequency by comparing the 0th element to the ith element and 
     * reassigning as necessary.   	
     * @param list - send in a LinkedList
     * @return min - The minimum node is returned once the whole list
     * has been searched
     */
    public static Node returnMin(LinkedList<Node> list)
    {
    	Node min = list.get(0); 
    	for(int i = 1; i < list.size(); i++){
    		if(list.get(i).getFrequency() <= min.getFrequency()){
    			min = list.get(i);
    		}
    	}
    	return min; 	
    }
    
    /*
     * this method calls the private printEncoding2 so the user
     * doesn't have to worry about passing in an empty string.
     * User only needs to pass in the root Node
     */
    public static void printEncoding(Node root)
    {
    	
    	 printEncoding2(root, "");
    	 System.out.println("Total bits: " + count);
    }

    /**
     * Method recursively searches each branch of the Huffman Tree
     * and concatenates a 0 or 1 to the code depending on the path 
     * followed by the method.
     * 
     * @param root - Root node
     * @param code - empty string to hold the code as the Huffman Tree
     * is traversed
     */
    private static void printEncoding2(Node root, String code)
    {
    	
    	if(root.isLeaf()){
    		count += code.length();
    		System.out.println(root.getLetter() + ": " + code);
    	}else{
    		printEncoding2(root.getLeftChild(), code + "0");
    		printEncoding2(root.getRightChild(), code + "1");		
    	}
    }
    

}