package dataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;


import configuration.TestConfig;
import data_reader.ExcelRead;

public class TestDataProvider {
	@DataProvider()
	public static Object[][] baseDataProvider(Method method) throws IOException {
		String fileName = getDataFileName(method);
		String sheetName = method.getName();
		ExcelRead read = new ExcelRead(fileName);
		return read.readExcel(sheetName);

	}

	private static String getDataFileName(Method method) throws IOException {
		return TestConfig.getPropertiesFolderPath()
				+ method.getDeclaringClass().getSimpleName() + ".xls";
	}
}
