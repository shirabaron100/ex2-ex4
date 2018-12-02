package File_format;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.element;
import GIS.layer;
import GIS.project;
/**
 * get a csv file and return it to kml
 * @author shira and hadaar
 *
 */
public class csvrReader {
	/**
	 * this function get  name of csv file and make it a layer
	 * @param place of csvFile
	 * @return layer
	 */
	private static layer csvToLayer (String csvFile)
	{
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int num=0;
		layer layer=new layer (csvFile);
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				num++;
				// use comma as separator
				if (num>2)
				{
					String[] csvLine = line.split(cvsSplitBy);
					layer.add(new element (csvLine));
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		} finally 
		{
			if (br != null)
			{
				try
				{
					br.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return layer;
	}
	/**
	 * The function accepts a project with layers and converts it to one KML 
	 * @param project name
	 */
	public static void projectToKmls(project name)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>");
		java.util.Iterator<GIS_layer>  it=name.iterator();
		while(it.hasNext())//Go through each gis layer and make it to kml
		{
			GIS_layer a=it.next();
			System.out.println(a.getName());
			sb.append(minikml(a));
		}
		sb.append("</Folder></Document></kml>");
		String fileName = name.getName().substring(0, name.getName().length()-3)+".Kml";
		PrintWriter pw = null;
		try 
		{
			pw = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");	
	}
	/**
	 * get layer and return the Lines with the Almtanim information
	 * @param gis_layer
	 * @return stringBuilder
	 */
	private static StringBuilder minikml(GIS_layer gis_layer)
	{
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<GIS_element>  it=gis_layer.iterator();
		while(it.hasNext())
			sb.append(elementToKml(it.next()));

		return sb;
	}
	/**
	 * The function accepts layer and turns it into KML
	 * @param gis_layer
	 */
	private static void layersTokml (GIS_layer gis_layer)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>");
		sb.append(minikml(gis_layer));//Uses a function that returns the most important of the KML
		sb.append("</Folder></Document></kml>");
		String fileName = gis_layer.getName().substring(0, gis_layer.getName().length()-3)+".Kml";
		PrintWriter pw = null;
		try 
		{
			pw = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");	
	}
	/**
	 * this function get an element and make it a set
	 * @param a
	 * @return StringBuilder
	 */
	private static StringBuilder elementToKml(GIS_element a) {
		{
			// use comma as separator
			StringBuilder sb = new StringBuilder();
			sb.append( "<Placemark>\n");
			sb.append("<name><![CDATA[");
			sb.append(a.getData().getSSID());
			sb.append("]]></name>");
			sb.append("<description><![CDATA[BSSID: <b>");
			sb.append(a.getData().getAuthMode());
			sb.append("</b><br/>Capabilities: <b>");
			sb.append(a.getData().getAuthMode());
			sb.append(" </b><br/>");
			sb.append("<br/>");
			sb.append("<br/>Date: <b>");
			sb.append(a.getData().getFirstSeen());
			sb.append(" </b>]]></description><styleUrl>#red</styleUrl>");
			sb.append("<Point>");
			sb.append("<coordinates>");
			sb.append(a.getGeom().x());
			sb.append(',');
			sb.append(a.getGeom().y());
			sb.append("</coordinates></Point>");
			sb.append("</Placemark>");
			return sb;
		}
	}
	/**
	 * Recursive function receives the name of a folder and a blank project and enters it with the layer 
	 * @param folder
	 * @param project
	 */
	public static void multiCsv(final File folder,final project project) {
		for (final File fileEntry : folder.listFiles()) 
		{
			if (fileEntry.isDirectory()) 
			{
				multiCsv(fileEntry,project);
			} else 
			{
				String name=fileEntry.getPath();
				if (name.substring(name.length()-3, name.length()).equals("csv")) //ïif there is csv in the file
				{	
					layer csv=csvToLayer(name);
					project.add(csv);
				}
			}
		}	
	}
	public static void main(String args[])
	{
		File a=new File ("C://Users//DELL//Desktop//csv");
		project z=new project("C://Users//DELL//Desktop//csv");
		multiCsv (a,z);
		projectToKmls(z);
	}
}

