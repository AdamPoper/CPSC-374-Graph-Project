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
	public abstract boolean contains(Object value);

	@Override
	public abstract boolean add(Object value);
		

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
	
	public abstract boolean removeVertex(Object value);

}
