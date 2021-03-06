package sru.edu.bartos.forest;

import sru.edu.poper.graph.Graph;
import sru.edu.poper.linkedlist.SinglyLinkedList;

import java.util.Map;

public class Forest {

	private final int MAXSIZE = 10;
	private Graph forest[];
	private int count;

	public Forest() {
		forest = new Graph[MAXSIZE];
		count = 0;

		Graph initGraph = new Graph();
		// We need to initialize each tree, so that they are empty graphs instead of
		// pointing to null
		for (int i = 0; i < MAXSIZE; i++) {
			forest[i] = initGraph;
		}
	}

	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	public int getSize() {
		return this.count;
	}

	public boolean isFull() {
		if (count == MAXSIZE) {
			return true;
		}
		return false;
	}

	public void addVertexAtI(Object value, int i) {
		if (forest[i].isEmpty()) {
			count++;
		} // Need to make sure i is within 0 and our MAXSIZE
		if (i < MAXSIZE && i >= 0) {
			forest[i].addVertex(value);
		}
	}

	public void addEdgeAtI(Object src, Object dest, int i) {
		if (forest[i].isEmpty()) {
			count++;
		}

		if (i < MAXSIZE && i >= 0) {
			forest[i].addEdge(src, dest, false);
		}
	}

	public void removeEdgeAtI(Object src, Object dest, int i) {
		if (i < MAXSIZE && i >= 0 && forest[i].containsEdge(src, dest)) {
			forest[i].removeEdge(src, dest, false);
		}
		// If the edge we remove is the only edge in a forest, then our tree is empty
		if (forest[i].isEmpty()) {
			count--;

		}
	}

	public void removeVertexAtI(Object value, int i) {
		if (i < MAXSIZE && i >= 0 && forest[i].containsVertex(value)) {
			forest[i].removeVertex(value);
		}
		// If the vertex we removed is the only value in the tree, then our tree is
		// empty
		if (forest[i].isEmpty()) {
			count--;
		}
	}

	public void deleteTreeAtI(int i) {
		if (i < MAXSIZE && i >= 0) {
			forest[i].clear();
			count--;
		}
	}

	// This method should add one tree to another, at the entered vertices
	public void join(Object vertexI, Object vertexJ, int i) {
		forest[i].addEdge(vertexI, vertexJ, true);

		count--;

	}

	// Delete an edge between two vertices, separating the tree into two different
	// trees
	public void disjoin(Object src, Object dest, int i) {
		forest[i].removeEdge(src, dest, true);
		// Now we would keep src and all of the nodes attached in forest[i], and put
		// dest and all nodes attached to it in a different forest location

	}

	public String printTreeAtI(int i) {
		Graph printGraph = forest[i];
		return printGraph.toString();

	}

	public static void main(String args[]) {
		Forest myForest = new Forest();
		System.out.println("Size is " + myForest.getSize());
		myForest.addEdgeAtI(2, 3, 0);
		myForest.addEdgeAtI(4, 1, 1);
		myForest.addEdgeAtI(4, 8, 1);
		myForest.join(2, 4, 0);
		System.out.println(myForest.printTreeAtI(0));
		myForest.disjoin(2, 4, 0);// Does not work, it removes the edge, but I do not know how to how to store the
									// two disjoint trees in different locations
		System.out.println(myForest.printTreeAtI(0));

	}

}