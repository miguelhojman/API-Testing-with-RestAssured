package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		String path=System.getProperty("user.dir")+"/userdata.xlsx"; //el excel con los datos
		ExcelUtilities xl=new ExcelUtilities(path);
		int rownum=xl.getRowCount("Hoja1");
		int colnum=xl.getCellCount("Hoja1", 1);
		String[][] apidata= new String [rownum][colnum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				apidata[i-1][j]=xl.getCellData("Hoja1", i, j);
			}
		}		
		return apidata; // String [][] es un 2d array.Es una tabla con los datos del excel
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException{
		String path=System.getProperty("user.dir")+"/userdata.xlsx";
		ExcelUtilities xl=new ExcelUtilities(path);
		int rownum=xl.getRowCount("Hoja1");
		String[] apidata= new String [rownum];
		for(int i=1;i<=rownum;i++) {
			apidata[i-1]=xl.getCellData("Hoja1", i, 1);
		}
		return apidata;	
		//String [] es un array de strings.Es un array conlos UserNames ya que toma j=1
		//o sea la columna del User Name
	}
}
