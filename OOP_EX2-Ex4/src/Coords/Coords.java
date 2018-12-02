package Coords;

import Geom.Point3D;

public class Coords implements coords_converter {
	final double pi=Math.PI;
	final double earth=6371000;
	final double Lon_Norm=0.847091174;
	
	public Coords ()
	{
		
	}
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		// TODO Auto-generated method stub
		Point3D gpsToRadian=new Point3D (this.toradian(gps));
		Point3D gpsToMeter=new Point3D (this.tometer(gpsToRadian));
		gpsToMeter.add(local_vector_in_meter);
		return gpsToMeter;

	}

	//the function get point and make it to radian
	private Point3D toradian(Point3D point)
	{
		double x=point.ix()*pi/180;
		double y=point.iy()*pi/180;
		double z=point.iz();
		Point3D newpoint= new Point3D (x,y,z);
		return newpoint;
	}
	//the function get a point and return a new point by meter
	private Point3D tometer(Point3D point)
	{
		double x=Math.sin(point.ix())*Lon_Norm;
		double y=Math.sin(point.ix())*Lon_Norm*earth;
		double z=point.ix();
		Point3D newpoint= new Point3D (x,y,z);
		return newpoint;
	}
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}


}
