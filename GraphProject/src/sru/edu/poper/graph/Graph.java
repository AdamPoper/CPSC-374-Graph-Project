package sru.edu.poper.graph;

import java.util.HashMap;
import java.util.Map;
import sru.edu.poper.linkedlist.SinglyLinkedList;

public class Graph extends AbstractGraph {
	
	// This graph is bidirectional
	
	// The source code of this graph class is aided by https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
	
	// Nodes/Vertices are stored in this graph by means of mapping a value to a list of other values
	private Map<Object, SinglyLinkedList> map;   // a map of nodes to a linked list

	public Graph()
	{
		this.map = new HashMap<Object, SinglyLinkedList>();
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

	// clear the graph just by clearing the map
	@Override
	public boolean clear() 
	{
		this.map.clear();
		return true;
	}

	// check to see if a vertex is in the graph
	@Override
	public boolean contains(Object value) 
	{
		return (this.map.containsKey(value));
	}
	
	// add a vertex to graph with out specifying an edge
	@Override
	public boolean add(Object value)
	{
		this.map.put(value, new SinglyLinkedList());
		return true;
	}
	
	// use this method to add an edge to the graph. It can also be used to add vertices to the graph
	public void addEdge(Object src, Object dest)
	{
		if(!this.map.containsKey(src))
			this.add(src);
		if(!this.map.containsKey(dest))
			this.add(dest);
		// since this graph is bidirectional, both the source & destination contain each other in their respective mapped list
		map.get(src).addNode(dest);
		map.get(dest).addNode(src);
	}

	// use this method to get all the edges associated with this particular vertex
	public SinglyLinkedList getEdgesOfVertex(Object v)
	{
		if(this.map.containsKey(v))
			return map.get(v);
		return null;
	}
	
	// removes a vertex from the graph. Returns true if it was removed, returns false otherwise
	@Override
	public boolean removeVertex(Object value)
	{
		if(this.map.containsKey(value))
		{
			// remove the value from the map
			this.map.remove(value);
			// iterate over the map and remove any edges of the value
			for(Map.Entry<Object, SinglyLinkedList> vertex : map.entrySet())
				vertex.getValue().removeNode(value);
			return true;
		}
		return false;
	}
	
	public static void main(String args[])
	{
		Graph graph = new Graph();
		graph.addEdge(10, 20);
		graph.addEdge(10, 30);
		graph.addEdge(20, 40);
		graph.addEdge(30, 40);
		
		graph.removeVertex(10);
		System.out.println(graph.getEdgesOfVertex(30));		
		
	}	
	
}
