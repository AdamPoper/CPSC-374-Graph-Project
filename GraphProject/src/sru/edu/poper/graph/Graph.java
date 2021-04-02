package sru.edu.poper.graph;

import java.util.HashMap;
import java.util.Map;
import sru.edu.poper.linkedlist.SinglyLinkedList;

public class Graph <T> extends AbstractGraph <T> {
	
	// This graph is bidirectional
	
	// this source code is aided by https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
	
	private Map<T, SinglyLinkedList> map;   // a map of nodes to a linked list

	public Graph()
	{
		this.map = new HashMap<T, SinglyLinkedList>();
	}
	
	@Override
	public int size() 
	{
		return this.map.size();
	}

	@Override
	public boolean isEmpty() 
	{
		return this.map.size() == 0;
	}

	@Override
	public boolean clear() 
	{
		this.map.clear();
		return true;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void addVertex(T value)
	{
		this.map.put(value, new SinglyLinkedList());
	}
	
	public void addEdge(T src, T dest)
	{
		if(!this.map.containsKey(src))
			this.addVertex(dest);
		if(!this.map.containsKey(dest))
			this.addVertex(src);
		// since this graph is bidirectional, both the source & destination contain each other their respective mapped list
		map.get(src).addNode(dest);
		map.get(dest).addNode(src);
	}

}