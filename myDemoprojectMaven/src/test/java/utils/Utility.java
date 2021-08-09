package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	public static String fetchdatafromexcelsheet(int row, int col) throws EncryptedDocumentException, IOException
	{
		 String path="C:\\Users\\Acer\\Desktop\\Kishor.xlsx";
		 FileInputStream file = new FileInputStream(path);
		 String Value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(col).getStringCellValue();
		return Value;
	}

}
