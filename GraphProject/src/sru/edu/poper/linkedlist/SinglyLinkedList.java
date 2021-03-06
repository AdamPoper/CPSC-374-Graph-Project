package sru.edu.poper.linkedlist;

public class SinglyLinkedList {

	private NodeOneLink head;
	private NodeOneLink tail;
	private int size;

	public SinglyLinkedList() {
		this.head = new NodeOneLink("Head");
		this.tail = new NodeOneLink("Tail");
		this.head.setNext(tail);
		this.size = 0;
	}

	public boolean isEmpty() {
		return (head.getNext() == tail);
	}

	public boolean addNode(Object data) {
		NodeOneLink temp = new NodeOneLink(data);
		temp.setNext(tail);
		NodeOneLink n = head;
		while (n.getNext() != tail) {
			n = n.getNext();
		}
		temp.setNext(tail);
		n.setNext(temp);
		temp = null;
		size++;
		return true;
	}

	public Object removeFirst() {
		if (this.isEmpty()) {
			return null;
		} else {
			NodeOneLink removed = head.getNext();
			head.setNext(removed.getNext());
			Object data = removed.getData();
			removed = null;
			size--;
			return data;
		}
	}

	// removes the first occurrence of an node in the list and returns its data, returns null otherwise
	public Object removeNode(Object value) {
		NodeOneLink current = head;

		// linear search
		while (current.getNext() != null)
		{
			if (current.getNext().getData() == value)
			{
				NodeOneLink doomed = current.getNext();
				current.setNext(doomed.getNext());
				doomed.setNext(null);
				Object data = doomed.getData();
				doomed.setData(null);
				doomed = null;
				size--;
				System.gc();
				return data;
			}				
			current = current.getNext();
		}
		return null;
	}
	
	public int getSize() {
		return size;
	}	

	public String toString() {
		String tempString = "";
		NodeOneLink ptr = head.getNext();
		while (ptr != tail) {
			tempString += ptr.getData();
			if(ptr.getNext() != tail)
				tempString += ", ";
			ptr = ptr.getNext();
		}
		return tempString;
	}

	public boolean contains(Object value) {
		NodeOneLink current = head;

		// linear search
		while (current != null) {
			if (current.getData() == value)
				return true;
			current = current.getNext();
		}
		return false;
	}

	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addNode("first data");
		list.addNode("second data");
		list.addNode("third data");
		list.addNode("fourth data");
		System.out.println(list.toString());
		System.out.println(list.removeFirst());
		System.out.println(list.toString());
	}
}
