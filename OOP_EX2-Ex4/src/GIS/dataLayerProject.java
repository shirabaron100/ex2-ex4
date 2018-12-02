package GIS;

import Geom.Point3D;

public class dataLayerProject implements Meta_data {
	String name;
	public dataLayerProject (String name)
	{
		this.name=name;	
	}
	public String getMac() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSSID() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getAuthMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFirstSeen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRSSI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUTC() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
