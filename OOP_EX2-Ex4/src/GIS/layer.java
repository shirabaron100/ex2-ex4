package GIS;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class layer implements GIS_layer {
	HashSet<GIS_element> set=new HashSet< GIS_element>();
	String place;
	Meta_data layerdata;
	public layer(String s) {
		place=s;
		layerdata=new dataLayerProject (s);
	}
	
	public String getName ()
	{
		return place;
	}
	@Override
	public boolean add(GIS_element e) {
		
		return set.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		
		return set.addAll(c);
	}

	@Override
	public void clear() {

		set.clear();
	}

	@Override
	public boolean contains(Object o) {

		return	set.contains(o);

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
	public Iterator<GIS_element> iterator() {
		// TODO Auto-generated method stub
		return this.set.iterator();
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
		return layerdata;
	}

}
