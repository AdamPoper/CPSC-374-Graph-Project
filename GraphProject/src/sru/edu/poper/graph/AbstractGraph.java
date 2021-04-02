package sru.edu.poper.graph;

public abstract class AbstractGraph <T> implements BaseOpsInt <T> {

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
	public abstract boolean contains(T value);

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(int value) {
		// TODO Auto-generated method stub
		return 0;
	}

}
