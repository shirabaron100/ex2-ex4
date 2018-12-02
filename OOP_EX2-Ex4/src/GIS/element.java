package GIS;
import Coords.Coords;
import Geom.Geom_element;
import Geom.Point3D;

public class element implements GIS_element {

	String [] csvLine;
	Point3D point;
	Meta_data data;
	public element (String [] a)
	{
		csvLine=a;
		point=new Point3D (Double.parseDouble(csvLine[7]),Double.parseDouble(csvLine[6]),Double.parseDouble(csvLine[8]));
		data=new data (csvLine);

	}
	public Geom_element getGeom() {

		return point;
	}
	@Override
	public Meta_data getData() {

		return data;
	}
	@Override

	public void translate(Point3D vec) {
		// TODO Auto-generated method stub

		Coords coords=  new Coords ();
		Point3D p=(Point3D) this.getGeom();
		Point3D a=coords.add(p, vec);
		point=a;
	}	

public String toString() {
	return data.getSSID();
}

}
