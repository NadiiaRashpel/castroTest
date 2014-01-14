package configuration;

import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import data_reader.FileRead;
import data_reader.PropertiesFileReader;

public class TestConfig {
	
	public static String getExcelFilePath() throws IOException {

		String excelFilePath = FileRead.read("excelFilePath");
		return excelFilePath;
	}

	public static Capabilities getDriver() throws IOException {
		if (PropertiesFileReader.read("driver") == "firefox") {
			Capabilities driver = DesiredCapabilities.firefox();
			return driver;
		}
		return null;

	}

	/*public static String getServer() throws IOException {
		String server = PropertiesFileReader.read("server");
		return server;
	}*/

	public static String getPropertiesFolderPath() throws IOException {
		String propertiesFolderPath = FileRead.read("propertiesFolderPath");
		return propertiesFolderPath;
	}

	/*public static Capabilities getCapabilities() {		
		  String browser;
		  if (System.getProperty("browser") != null){
		   browser = System.getProperty("browser");
		  } else {
		   browser = p.getProperty("browser");
		  }
		  switch (browser) {
		  case "firefox":
		   return DesiredCapabilities.firefox();
		  case "opera":
		   return DesiredCapabilities.opera();
		  case "internet explorer":
		   return DesiredCapabilities.internetExplorer();
		  case "chrome":
		   return DesiredCapabilities.chrome();

		  default:
		  // LOG.error("Browser's property is incorrect");
		   throw new IllegalArgumentException(
		     "Browser's property is incorrect");
		  }
		 }*/
	}
