/**
 * Devon Vlcek
 * Project 2
 * ITCS 2215-001
 * 
 * Node class creates new Nodes and assigns letter
 * and frequency fields to each new node.  Also provides
 * setter and getter methods.
 * 
 */

public class Node
{
    private int frequency;
    private char letter;
    private Node leftChild;
    private Node rightChild;
    
    /**
     * Constructor initializes Node with a letter and
     * the frequency of that letter
     * @param letter
     * @param frequency
     */
    public Node(char letter, int frequency){
    	this.frequency = frequency;
    	this.letter = letter;
    }
    
    
    
    /**
     * Empty constructor 
     */
    public Node(){}
    
    /**
     * Method sets pointers to left and right children
     * @param left - pointer to left child
     * @param right - pointer to right child
     */
    public void setChildren(Node left, Node right){
    	this.leftChild = left;
    	this.rightChild = right;
    }
    
    /**
     * Method assigns frequency of character occurence 
     * to node
     * @param frequency
     */
    public void setFrequency(int frequency){
    	this.frequency = frequency;
    }
    
    /**
     * Returns letter held by the Node
     * @return letter - character held by the Node
     */
    public char getLetter(){
    	return letter;
    }
    
    /**
     * Returns the frequency of the letter held by the Node
     * @return frequency - frequency of character
     */
    public int getFrequency(){
    	return frequency;
    }
    
    /**
     * Returns pointer to the left child
     * @return leftChild - pointer to left child
     */
    public Node getLeftChild(){
    	return leftChild;
    }
    
    /**
     * Returns pointer to the right child
     * @return rightChild - pointer to right child
     */
    public Node getRightChild(){
    	return rightChild;
    }
    
    /*
     * By nature, a new node can only be made 
     * if 2 children exist, so this method only checks
     * if the left child holds any value. If there are no 
     * children, returns true. If children exist, method 
     * returns false.
     */
    public boolean isLeaf(){
    	return (leftChild == null);
    }
    
  
}