package sru.edu.poper.linkedlist;

public class NodeOneLink {
	private Object data;
	private NodeOneLink next;
	
	public NodeOneLink (Object data)
	{
		this.data = data;
		this.next = null;
	}
	
	public Object getData() 
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	public NodeOneLink getNext()
	{
		return next;
	}

	public void setNext(NodeOneLink next)
	{
		this.next = next;
	}
	
	
}
