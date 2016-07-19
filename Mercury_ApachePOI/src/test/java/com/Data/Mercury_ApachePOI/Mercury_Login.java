package com.Data.Mercury_ApachePOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Mercury_Login {

	@Test
	public void Mercury_ExcelHandler(){
		try {
			FileInputStream mercuryFile = new FileInputStream("MercuryLogin.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(mercuryFile);
			XSSFSheet loginSheet = workBook.getSheet("Test_Cases");
			XSSFSheet testcasesSheet = workBook.getSheet("Mercury_Login");
			XSSFSheet selectFlightSheet = workBook.getSheet("Select_Flight");
						
			int loginSheet_Rows = loginSheet.getLastRowNum();
			System.out.println("loginSheet_Rows : "+loginSheet_Rows);
			
			int testcasesSheet_Rows = testcasesSheet.getLastRowNum();
			System.out.println("testcasesSheet_Rows : "+testcasesSheet_Rows);
			
			int selectFlightSheet_Rows = selectFlightSheet.getLastRowNum();
			System.out.println("selectFlightSheet_Rows : "+selectFlightSheet_Rows);
			
			Mercury_TestClass mercury = new Mercury_TestClass();
			Method mercuryMethods[] = mercury.getClass().getMethods();
			
			Mercury_SelectFlight selectFlightclass = new Mercury_SelectFlight();
			Method selectFlightMethods[] = selectFlightclass.getClass().getMethods();
			
			for(int i=1;i<=loginSheet_Rows;i++){
				String loginSheet_TestID = String.valueOf(loginSheet.getRow(i).getCell(0));
				String loginSheet_Type = String.valueOf(loginSheet.getRow(i).getCell(2));
				
				if(loginSheet_Type.equals("Yes")){
					for(int j=1;j<=testcasesSheet_Rows;j++){
						String testCasesSheet_TestID = String.valueOf(testcasesSheet.getRow(j).getCell(0));
						if(loginSheet_TestID.equals(testCasesSheet_TestID)){
							String test_Object = String.valueOf(testcasesSheet.getRow(j).getCell(2));
							String test_Action = String.valueOf(testcasesSheet.getRow(j).getCell(3));
							String test_Data = String.valueOf(testcasesSheet.getRow(j).getCell(4));						
							for(int k=0;k<mercuryMethods.length;k++){
								if(mercuryMethods[k].getName().equals(test_Action)){
									mercuryMethods[k].invoke(mercury, test_Object,test_Data);
								}
							}
						}
					}
					for(int j=1;j<=selectFlightSheet_Rows;j++){
						String selectFlightSheet_TestID = String.valueOf(selectFlightSheet.getRow(j).getCell(0));
						if(selectFlightSheet_TestID.equals(selectFlightSheet_TestID)){
							String selectFlight_Action =String.valueOf(selectFlightSheet.getRow(j).getCell(3));
							String selectFlight_Object =String.valueOf(selectFlightSheet.getRow(j).getCell(2));
							for(int k=0;k<selectFlightMethods.length;k++){								
								if(selectFlightMethods[k].getName().equals(selectFlight_Action)){
									selectFlightMethods[k].invoke(selectFlightclass, selectFlight_Object);									
								}
							}
						}
					}
				}				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}