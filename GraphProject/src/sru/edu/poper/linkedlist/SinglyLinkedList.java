package sru.edu.poper.linkedlist;

public class SinglyLinkedList {
	
	private NodeOneLink head;
	private NodeOneLink tail;
		
	public SinglyLinkedList() {
		this.head = new NodeOneLink("Head");
		this.tail = new NodeOneLink("Tail");
		this.head.setNext(tail);
	}
	
	public boolean isEmpty() 
	{
		return (head.getNext() == tail);
	}
	
	public Object addNode(Object data)
	{
		NodeOneLink temp = new NodeOneLink(data);
		temp.setNext(tail);
		NodeOneLink n = head;
		while(n.getNext() != tail)
		{
			n = n.getNext();
		}
		temp.setNext(tail);
		n.setNext(temp);
		temp = null;
		return data;
	}
	
	public Object removeFirst() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			NodeOneLink removed = head.getNext();
			head.setNext(removed.getNext());
			Object data = removed.getData();
			removed = null;
			return data;
		}
	}
	
	public NodeOneLink getHead() 
	{
		return head;
	}
	public void setHead(NodeOneLink head) 
	{
		this.head = head;
	}
	public NodeOneLink getTail() {
		return tail;
	}
	public void setTail(NodeOneLink tail) 
	{
		this.tail = tail;
	}
	
	public String toString()
	{
		String tempString = "";
		NodeOneLink ptr = head;
		while(ptr != null)
		{
			tempString += ptr.getData() + " ";
			ptr = ptr.getNext();
		}
		return tempString;
	}
	
	public static void main(String args[])
	{
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

