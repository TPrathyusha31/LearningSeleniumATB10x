package com.SeleniumPractice.ex_17_DataDrivenTesting_POI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {

    static Workbook book;
    static Sheet sheet;
    public static String SHEET_PATH = System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";

    //STEPS : ceate a file,workbook,sheet ---> create a 2D array --> put data into array and return it

    public static Object[][] getTestDataFromExcel(String SheetName){
        FileInputStream file = null;
        try {
             file = new FileInputStream(SHEET_PATH); //step i) --> read the file
            book = WorkbookFactory.create(file); //step ii) --> create a workbook(which means creating a stream to read the book)
            sheet = book.getSheet(SheetName); //from the book get the sheet
        } catch (IOException e) {
            System.out.println("Either File not found! or workbook not created!");
        }

        //creating a 2D data array
       Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        //After creating a 2D array --> Put the data into 2D array using for loops
        for (int i=0;i<sheet.getLastRowNum();i++){ // for rows
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){ // for coloumns
                // first row has headers email and password --> so skip the 1st row
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

}
