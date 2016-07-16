

There are two classes: 
	1) class ExcelReadStringArrayXSL : Reads .xls file
	2) class ExcelReadStringArrayXSLX : Reads .xlsx file

Parameters Required by both the Classes 
	
	ExcelReadStringArrayXSL excelread = new ExcelReadStringArrayXSL(arg1, arg2);
	
	Arguments required:
	
	arg1: String fileName
	arg2: String sheetName : "input"
	
	If you are a Microsoft Windows user:  
	eg: fileName : "C:\\user\\username\\testData.xls"

	If you are a GNU/Linux user
	eg: fileName : "/home/username/testData.xls"
	
	Both the class throws : FileNotFoundException,Exception
		
	
Methods in both the class:

1) getRowLenght() : returns int : the total row length
2) getColumnLenght() : returns int : the total column length

3) getExcelStringArray() : returns String[][] : the 2 dimension array of the excel sheet

4) convertCellToString(HSSFCell cell) : returns String  : handles 6 different Cell type:
	Numeric, String, Blank, Boolean, Error, Formula. This method is internally used
	by the API but can be used for other purpose


5) setOutputSingletResult(String[][]inputData, String[] outputResult, String filePath)     
 
 /* Use this method only when you are going to store one output result i.e 
  * after test script has run and you have wrote a script which is only going to
  * store one result value for each test data	
  */	
   
arg1) String[][]inputData : this is the 2 dimension String array which holds the test data

arg2) String[] outputResult : this is the 1 dimension String array which you get back after the test is performed on the entire test input.

arg3) String filePath : this is the file path in which you are going to store the output result
	/*
         *Note : you don't have to provide the name of the file. The method generates one 		 *for you and it is always unique
	 */


6) setOutputResult(String[][]inputData, String[][] outputResult, String filePath)

 /* Use this method only when you are going to store more than one output result i.e 
  * after test script has run and you have wrote a script which is going to
  * store more than one result values for each test data	
  */	
arg1) String[][]inputData : this is the 2 dimension String array which holds the test data

arg2) String[][] outputResult : this is the 2 dimension String array which you get back after the test is performed on the entire test input.

arg3) String filePath : this is the file path in which you are going to store the output result
	/*
         *Note : you don't have to provide the name of the file. The method generates one 		 *for you and it is always unique
	 */

