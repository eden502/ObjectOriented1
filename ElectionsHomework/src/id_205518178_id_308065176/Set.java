package id_205518178_id_308065176;

import java.util.Vector;

public class Set<T>  {
	
	private Vector<T> list;
	
	public Set() {
		list = new Vector<T>();
	}
	
	public Vector<T> getList(){
		return list;
	}
	public T get(int index) {
		return list.get(index);
	}
	public int size() {
		return list.size();
	}
	public void add(T obj) {
		if(list.contains(obj)) {
			return;
		}
		list.add(obj);
	}
	

}
