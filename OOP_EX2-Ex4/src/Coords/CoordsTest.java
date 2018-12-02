package Coords;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class CoordsTest {

	@Test
	void testAdd() {
		Point3D a= new Point3D(0,0,0);
		Point3D b= new Point3D(3326139,3672925,-20);
		Coords Z=new Coords();
		Point3D x=Z.add(a, b);
		assertEquals(x.x(),31.471532896347014);
		assertEquals(x.y(),35.2052247037712);
	}

	@Test
	void testDistance3d() {
		Point3D a= new Point3D(32.10332,35.20904,670);
		Point3D b= new Point3D(32.10635,35.20523,650);
		Coords Z=new Coords();
		double y= Z.distance3d(a, b);
		assertEquals(y,492.2447784618046);
	}

	@Test
	void testVector3D() {
		Point3D a= new Point3D(32.10332,35.20904,670);
		Point3D b= new Point3D(32.10635,35.20523,650);
		Coords Z=new Coords();
		Point3D x=Z.vector3D(a, b);
		assertEquals(x.x(),-336.9206275762522);
		assertEquals(x.y(), 358.87241832792813);
		assertEquals(x.z(),20.0);
	}
	
	@Test
	void testAzimuth_elevation_dist() {
		Point3D a= new Point3D(32.10332,35.20904,670);
		Point3D b= new Point3D(32.10635,35.20523,650);
		Coords Z=new Coords();
		double [] temp =Z.azimuth_elevation_dist(a,b);
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		System.out.println(temp[2]);
		assertEquals(temp[0],313.19444380079074);
		assertEquals(temp[1],-2.3285795133351765);
		assertEquals(temp[2],492.2447784618046);

	}

	@Test
	void testIsValid_GPS_Point() {
		Point3D a= new Point3D(181,35.20904,400);
		Point3D b= new Point3D(-181,35.20904,400);
		Point3D c= new Point3D(180,91,400);
		Point3D d= new Point3D(180,-91,400);
		Point3D e= new Point3D(18,35.20904,451);
		Point3D f= new Point3D(-181,35.20904,-451);
		Coords Z=new Coords();
		assertFalse(Z.isValid_GPS_Point(a));
		assertFalse(Z.isValid_GPS_Point(b));
		assertFalse(Z.isValid_GPS_Point(c));
		assertFalse(Z.isValid_GPS_Point(d));
		assertFalse(Z.isValid_GPS_Point(e));
		assertFalse(Z.isValid_GPS_Point(f));
	}

	@Test
	void testVectortopoint() {
		Point3D b= new Point3D(3326139,3672925,-20);
		Coords Z=new Coords();
		Point3D test= Z.vectortopoint(b);
		assertEquals(test.x(),31.471532896347014);
		assertEquals(test.y(),35.2052247037712);
		assertEquals(test.z(),-20.0);
	}
	

}
