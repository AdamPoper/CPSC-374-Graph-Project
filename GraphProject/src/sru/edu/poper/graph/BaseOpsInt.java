package sru.edu.poper.graph;

public interface BaseOpsInt {
	
	//size of the structure
	public int size();
	
	//query if the structure is empty?
	public boolean isEmpty();
	
	//query if the structure is full
	public boolean isFull();
	
	//remove all elements from the structure
	public boolean clear();
	
	//checks if the value is in the structure
	public boolean contains(Object value);
	
	// add to end of structure
	public boolean add(Object value);
	
	//remove at the end of structure
	public Object remove();
	
	//index of the first value in the structure
	public int indexOf(int value);
	
}
