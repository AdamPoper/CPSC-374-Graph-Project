package sru.edu.poper.graph;

import java.util.HashMap;
import java.util.Map;
import sru.edu.poper.linkedlist.SinglyLinkedList;

/*
 * Name:    		Adam Poper
 * UserID:  		arp1017
 * Name of File:  	Graph.java
 * Name of Project: Bonus Project
 * Status:			Correctly-Works Completely
 * Starting Date: 	4/2/2021
 * Ending Date: 	4/19/2021
 * Description: This is a graph class for a bonus project that involves steiner trees and forests. 
 * 
 * This program was done entirely by me and no part 
 * of this program was plagiarized, intentionally or 
 * unintentionally, from anybody or any location. 
 * I would be held accountable and penalized if any 
 * part of this program was plagiarized.
 */

public class Graph extends AbstractGraph {
		
	// This graph is unidirectional or bidirectional
	
	// The source code of this graph class is aided by https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
	
	// Nodes/Vertices are stored in this graph by means of mapping a value to a list of other values
	private Map<Object, SinglyLinkedList> map;   // a map of nodes to a linked list

	public Graph()
	{
		this.map = new HashMap<Object, SinglyLinkedList>();
	}
	
	// get the number of key-value mappings in the map
	@Override
	public int size() 
	{
		return this.map.size();
	}

	// check if the graph is empty
	@Override
	public boolean isEmpty() 
	{
		return this.map.isEmpty();
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
	public boolean containsVertex(Object value) 
	{
		return (this.map.containsKey(value));
	}
	
	// check if an edge exists between to values
	@Override
	public boolean containsEdge(Object src, Object dest)
	{
		if(this.map.containsKey(src))
			if(this.map.get(src).contains(dest))
				return true;		
		return false;
	}			
	
	// use this method to add an edge to the graph. It can also be used to add vertices to the graph
	// to indicate the direction of the edge, use direction = true for one directional and direction = false for bidirectional
	// returns true if an edge was established or false if no edges were established
	public boolean addEdge(Object src, Object dest, boolean direction)
	{
		if(!this.map.containsKey(src))
			this.addVertex(src);
		if(!this.map.containsKey(dest))
			this.addVertex(dest);
		
		// set the direction of the edge
		if(direction)
		{
			// only add the edge doesn't already exist
			if(!map.get(src).contains(dest))
			{
				map.get(src).addNode(dest);
				return true;
			}
			return false;
		}
		else			
		{
			boolean edgeAdded = false;
			// only add the edge doesn't already exist
			if(!map.get(src).contains(dest))
			{
				map.get(src).addNode(dest);
				edgeAdded = true;
			}
			// only add the edge doesn't already exist
			if(!map.get(dest).contains(dest))
			{
				map.get(dest).addNode(src);
				edgeAdded = true;
			}
			return edgeAdded;
		}
	}
	
	// check the direction of an edge
	// returns 1 if edge is one directional, 2 if edge is bidirectional, 0 if there if there is no edge	
	public int checkEdgeDirection(Object src, Object dest)
	{		
		if(this.map.get(src).contains(dest) && !this.map.get(dest).contains(src))
			return 1;
		else if(this.map.get(src).contains(dest) && this.map.get(dest).contains(src))
			return 2;
		return 0;
	}

	// use this method to get all the edges associated with a particular vertex
	public SinglyLinkedList getEdgesOfVertex(Object value)
	{
		if(this.map.containsKey(value))
			return map.get(value);
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
	
	// removes an edge between two values
	// same as when adding edge, use direction = true for removing a one directional edge or direction = false for a bidirectional edge
	public boolean removeEdge(Object src, Object dest, boolean direction) 
	{
		if(this.map.containsKey(src) && this.map.containsKey(dest))
		{
			if(direction)
				this.map.get(src).removeNode(dest);
			else 
			{
				this.map.get(src).removeNode(dest);	
				this.map.get(dest).removeNode(src);
			}
			return true;
		}
		return false;
	}		

	// add a vertex to the graph without specifying an edge
	public boolean addVertex(Object value) 
	{
		this.map.put(value, new SinglyLinkedList());
		return true;
	}			
	
	// toString method for displaying which values are mapped to which other values
	@Override
	public String toString()
	{
		/* output looks like this
		 * 
		 * 20 - 10, 30          20 has edges with 10 and 30
		 * 40 - 10, 30    		40 has edges with 10 and 30
		 * 10 - 20, 40 			10 has edges with 20 and 40
		 * 30 - 20, 40 			30 has edges with 20 and 40
		 */
		String str = new String();
		for(Map.Entry<Object, SinglyLinkedList> vertex : map.entrySet())
			str += vertex.getKey() + " - " + vertex.getValue() + '\n';				
		return str;
	}
	
	public static void main(String args[])
	{
		Graph graph = new Graph();
		graph.addEdge(10, 20, false);
		graph.addEdge(10, 40, false);
		graph.addEdge(20, 30, false);
		graph.addEdge(30, 40, true);
		System.out.println(graph);		
		switch(graph.checkEdgeDirection(40, 30))
		{
		case 1:
			System.out.println("Unidirectional");
			break;
		case 2: 
			System.out.println("Bidirectional");
			break;
		case 0:
			System.out.println("No Direction");
			break;
		}		
	}		
}
