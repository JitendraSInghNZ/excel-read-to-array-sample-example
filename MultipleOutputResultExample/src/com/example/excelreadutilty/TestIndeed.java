package com.example.excelreadutilty;
/**
 * This is an example which demonstrates how to use the API in excel_read_utility.jar
 * to read an excel file which has test data and after running the script if you get 
 * more than 1 output result, than how to use the setOutPutResult() method to store the 
 * result into an excel file, which will merge both the input test data and the output result   
 */
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jitendrasinghnz.excelreadutility.ExcelReadStringArrayXSL;

public class TestIndeed {

	public static void main(String[] args) throws FileNotFoundException, Exception {
				
				//Step1) Get the test input excel file path, sheet name and output file path; 
						
				String inpustDatafilePath = "ENTER_HERE_COMPLETE_FILE_PATH_OF_TEST_INPUT_EXCEL_FILE";
				String sheetName = "ENTER_HERE_SHEET_NAME";
				String outputFilePath = "ENTER_HERE_COMPLETE_FILE_PATH_WHERE_YOU_WANT_TO_STORE_THE_OUTPUT_RESULT";
				
				//Step2) Get input from excel file;
				
				ExcelReadStringArrayXSL excelReadStringArrayXSL = new ExcelReadStringArrayXSL(inpustDatafilePath, sheetName);
				String[][]testDataArray = excelReadStringArrayXSL.getExcelStringArray();
				
				
				//Step3) Make a driver object to drive the browser and set some parameters;
				WebDriver driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.get("http://www.indeed.com/");
				
				//Step4)Declare Test data you are going to read from excel file'
		
				String jobRole, location = null; 
				
				//Step5)Declare Result data you are going to read from the web-site 
				String jobCount = null;
				String url;
				
				
				//Step6) Result array in which the data from the web-site will be stored
		
				String[][] resultArray = new String[excelReadStringArrayXSL.getRowLenght()][2];
				
				//Step7) Loop through each row of input data array and get each row data 
				
				for(int i = 1; i < excelReadStringArrayXSL.getRowLenght(); i++){
				
				jobRole = testDataArray[i][0];//row i and column 0
				location = testDataArray[i][1];////row i and column 1
				
				driver.findElement(By.id("what")).clear();
				driver.findElement(By.id("what")).sendKeys(jobRole);
				driver.findElement(By.id("where")).clear();
				driver.findElement(By.id("where")).sendKeys(location);
				driver.findElement(By.id("fj")).click();
				
				
				//Step8) Try to locate and get the job count detail and if present store it in the result array 
				try{
					jobCount = driver.findElement(By.id("searchCount")).getText();
					resultArray[i][0] = jobCount;
				}
				
				//else handle the exception of the element is not present and store "Fail"
				catch (NoSuchElementException nse) {
					resultArray[i][0] = "Fail";
				}
				url = driver.getCurrentUrl();
				resultArray[i][1] = url;
								
				//Step9) Navigate back to enter new test data
				
					driver.navigate().back();				
				
				}
				
				//Step10) Store an output excel file having test data and its respective result
				
				excelReadStringArrayXSL.setOutputResult(testDataArray, resultArray, outputFilePath);		


	}

}
