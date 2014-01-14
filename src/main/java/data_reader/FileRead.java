package data_reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileRead {

	public static String read(String param) throws IOException {

		FileInputStream fis = new FileInputStream("properties_file.txt");

		Properties p = new Properties();
		p.load(fis);
		String prop;
		switch (param) {
		case "driver":
			prop = p.getProperty("driver");
			return prop;
		case "browser":
			prop = p.getProperty("browser");
			return prop;
		case "server":
			prop = p.getProperty("server");
			return prop;
		case "excelFilePath":
			prop = p.getProperty("excelFilePath");
			return prop;
		case "propertiesFolderPath":
			prop = p.getProperty("propertiesFolderPath");
			return prop;
		}
		return null;
	}

}
