package sru.edu.poper.graph;

public abstract class AbstractGraph implements BaseOpsInt {

	@Override
	public abstract int size();

	@Override
	public abstract boolean isEmpty();

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public abstract boolean clear();

	@Override
	public boolean contains(Object value) {
		return false;
	}
	
	// search vertex & edge
	public abstract boolean containsEdge(Object src, Object dest);
	
	public abstract boolean containsVertex(Object value);

	public abstract boolean removeVertex(Object value);		
	
	@Override
	public boolean add(Object value) {
		return false;
	}
	
	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(int value) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
