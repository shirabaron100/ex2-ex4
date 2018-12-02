package Coords;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import Geom.Point3D;

public class Coords implements coords_converter {
	private double radius =6371*1000;
	private double Lon_Norm;
	
	/**
	 *  The function returns the addition between the gps and the vector
	 * @param gps point
	 * @param local vector in meter 
	 * @return point3D
	 * 
	 */
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		Point3D copy= new Point3D(local_vector_in_meter);
		copy=vectortopoint(local_vector_in_meter);
		copy.add(gps);
		return copy;
	}
/**
 * @param gps0
 * @param gps1
 * @return this function return the distance between the two gps points.
 */
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		Point3D a= new Point3D(gps0.x()-gps1.x(),gps0.y()-gps1.y(),gps0.z()-gps1.z());
		double x=(Math.sin((a.x()*Math.PI)/180))*radius;
		 Lon_Norm=Math.cos(gps0.x()*Math.PI/180);
		double y= (Math.sin((a.y()*Math.PI)/180))*radius*Lon_Norm;
		return Math.sqrt(x*x+y*y);
	}
/**
 * @return return the vector between the two points
 * @param gps0
 * @param gps1
 * 
 */
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		Point3D a= new Point3D(gps0.x()-gps1.x(),gps0.y()-gps1.y(),gps0.z()-gps1.z());
		double x=Math.sin((a.x()*Math.PI)/180)*radius;
		 Lon_Norm=Math.cos(gps0.x()*Math.PI/180);
		double y= Math.sin((a.y()*Math.PI)/180)*radius* Lon_Norm;
		Point3D b=new Point3D(x,y,a.z());
		return b;
	}
/**
 * return double array that there in azimuth, elevation and dist
 * @param gps0;
 * @param gps1;
 */
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double teta1 = (gps0.x()*Math.PI)/180;
	    double teta2 = (gps1.x()*Math.PI)/180;
	    double delta2 = ((gps1.y()- gps0.y())*Math.PI)/180;
	    double y = Math.sin(delta2) * Math.cos(teta2);
	    double x = Math.cos(teta1) * Math.sin(teta2) - Math.sin(teta1)*Math.cos(teta2)*Math.cos(delta2);
	    double brng = Math.atan2(y,x);
	    brng = (brng*180)/ Math.PI ;
	    brng = (((double)brng + 360) % 360 );
	    Coords C1 = new Coords();
	    double dist=C1.distance3d(gps0, gps1);
	    double high= gps1.z()-gps0.z();
	    double eleveation = Math.toDegrees(Math.asin(high/dist));
	    double[] temp= {brng,eleveation,dist};
	    return temp;
	}
/**
 * return a boolean answer and check if the point is a gps 
 * @param point3D
 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		return ((p.x()>=-180 && p.x()<=180)&&(p.y()>=-90 && p.y()<=90)&&(p.z()>=-450 && p.z()<=450));
	}
	/**
	 * 
	 * @param a
	 * @return a vector to this point
	 */
	public Point3D vectortopoint(Point3D a) {
		Lon_Norm=40;
		double pro_x= a.x()/radius;
		double x = (java.lang.Math.asin(pro_x))*180/Math.PI;
		double pro_y = a.y() /radius;
		double y = (java.lang.Math.asin(pro_y))*180/Math.PI;
		Point3D P=new Point3D(x,y,a.z()); 
		return P;
	}
	


}
