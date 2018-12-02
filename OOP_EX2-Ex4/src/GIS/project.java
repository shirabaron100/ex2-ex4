package GIS;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class project implements GIS_project {
	HashSet<GIS_layer> set=new HashSet< GIS_layer>();
	String name;
	Meta_data projectdata;
	public project (String s) {
		name=s;
		projectdata=new dataLayerProject (s);
	}
	public String getName () {
		return name;
	}
	@Override
	public boolean add(GIS_layer e) {
		// TODO Auto-generated method stub

		return set.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		// TODO Auto-generated method stub
		return set.addAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		set.clear();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return set.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return set.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return set.isEmpty();
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return set.iterator();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return set.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return set.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return set.retainAll(c);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return set.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return set.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return set.toArray(a);
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return projectdata;
	}

}
