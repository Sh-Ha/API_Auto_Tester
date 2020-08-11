package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import io.restassured.response.Response;


public class DataDriver {
	
	
	
	public List<String> getcolval(String Filepath, int sheetno,int colno, int row_lmarker,int row_hmarker) throws IOException
	{
		FileInputStream excelFile = new FileInputStream(new File(Filepath));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(sheetno);
    	
    	
    	//List<Cell> cells = new ArrayList<Cell>();
    	List<String> scells = new ArrayList<String>();
    	
    	

    	for (Row row : datatypeSheet) 
    	{
    		if (row.getRowNum() >= row_lmarker)
    		{
    	   Cell c = row.getCell(colno);
    	   
    	   if (c!= null)
    	   {
    	   if (c.getCellType() == Cell.CELL_TYPE_STRING) {
           	
    		  
             scells.add(c.getStringCellValue());
          
             
           } else if (c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
        	  
               scells.add(Double.toString(c.getNumericCellValue()));
           }
    	   
    	}
    	   if (row.getRowNum() == row_hmarker)
    	   {
    		   break;
    	   }
    		}
    	}
    	
    	
    	excelFile.close();
    	 
    	
        
        return scells;
    	
	}
}


	



