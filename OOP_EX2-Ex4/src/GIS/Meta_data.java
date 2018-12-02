package GIS;

import Geom.Point3D;

public interface Meta_data {

	public String getMac(); 
	public String getSSID(); 
	public String getAuthMode();
	public String getFirstSeen();
	public String getChannel();
	public String getRSSI();
	public String getType();
	/** returns the Universal Time Clock associated with this data; */
	public long getUTC();
	/** return a String representing this data */
	public String toString();
	/**
	 * @return the orientation: yaw, pitch and roll associated with this data;
	 */
	public Point3D get_Orientation();
}
