package GIS;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Geom.Point3D;

public class data implements Meta_data {
	String [] csvLine;
	String mac;
	String SSID;
	String AuthMode;
	String FirstSeen;
	String Channel;
	String RSSI;
	String AccuracyMeters;
	String Type;
	/**
	 * 
	 * constructor that get a line from csv with a array
	 * @param s
	 */
	public data (String [] s)
	{
		csvLine=s;
		mac=csvLine[0];
		SSID=csvLine[1];
		AuthMode=csvLine[2];
		FirstSeen=csvLine[3];
		Channel=csvLine[4];
		RSSI=csvLine[5];
		AccuracyMeters=csvLine[6];
		Type=csvLine[7];


	}
	/**
	 * this function getAccuracyMeters
	 * @return String
	 */
	public String getAccuracyMeters() {
		return AccuracyMeters;
	}
	/**
	 * this function return mac
	 * @return String 
	 */
	public String getMac() {
		return mac;
	}
	/**
	 * return SSID
	 * @return string
	 */
	public String getSSID() {
		return SSID;
	}
	/**
	 * @return AuthMode
	 */
	public String getAuthMode() {
		return AuthMode;
	}
	/**
	 * @param FirstSeen
	 */
	public String getFirstSeen() {
		return FirstSeen;
	}
	/**
	 * @return Channel
	 */
	public String getChannel() {
		return Channel;
	}
	/**
	 * @return RSSI
	 */
	public String getRSSI() {
		return RSSI;
	}
	/**
	 * @return Type
	 */
	public String getType() {
		return Type;
	}
	@Override
	/**this function get a string and return it to timestamp
	 * @return long 
	 */
	public long getUTC() {
		SimpleDateFormat sdf=new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		Date date;
		try {
			date=sdf.parse(csvLine[3]);
			long timeInMillis=date.getTime();
			return timeInMillis;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		} 
		catch (java.text.ParseException e) 
		{

			e.printStackTrace();
		}
		return 0;
	}
	@Override
	
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString()
	{
		return " mac: " +csvLine[0]+"\n CHANNEL: "+csvLine[4]+"\n RSSI: "+csvLine[5]+"\n TYPE: "+csvLine[10];
	}

}
