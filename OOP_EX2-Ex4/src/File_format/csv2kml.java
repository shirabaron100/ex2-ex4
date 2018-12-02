package File_format;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class csv2kml 
{
	public csv2kml(String csvFile )
	{
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>");

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);
				sb.append( "<Placemark>\n");
				sb.append("<name><![CDATA[");
				sb.append(country[1]);
				sb.append("]]></name>");
				sb.append("<description><![CDATA[BSSID: <b>");
				sb.append(country[0]);
				sb.append("</b><br/>Capabilities: <b>");
				sb.append(country[2]);
				sb.append(" </b><br/>");
				sb.append("<br/>");
				sb.append("<br/>Date: <b>");
				sb.append(country[3]);
				sb.append(" </b>]]></description><styleUrl>#red</styleUrl>");
				sb.append("<Point>");
				sb.append("<coordinates>");
				sb.append(country[7]);
				sb.append(',');
				sb.append(country[6]);
				sb.append("</coordinates></Point>");
				sb.append("</Placemark>");
			}
			sb.append("</Folder></Document></kml>");

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		} finally {
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
		String fileName = csvFile.substring(0, csvFile.length()-3)+".Kml";
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

}



