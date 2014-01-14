package data_reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	static String path;
	static Properties p = new Properties();
	public static String read(String param) throws IOException{
		try (FileInputStream fis = new FileInputStream(
				"properties_file.txt")){			
			p.load(fis);
		} catch (IOException e) {

		}
		return null;
	}

	public static String getPathToReadXML() {
		return p.getProperty("PathToXMLRead");
	}
	
	public static String getPathToReadExel() {
		return p.getProperty("PathToExelRead");
	}

	public static String getBrowser(){
	return p.getProperty("browser");
	}
	
	public static String getPathToUrl() {
		return p.getProperty("url");
	}

	public static String getPathToName() {
		return p.getProperty("name");
	}

	public static String getPathToPassword() {
		return p.getProperty("password");
	}
	public static String getOperaBinaryPath(){
		return p.getProperty("OperaBinaryPath");
	}
}
