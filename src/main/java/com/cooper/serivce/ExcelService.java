package com.cooper.serivce;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelService {
	
	// make excel
	@SuppressWarnings("deprecation")
	public void makeExcel() throws IOException {
		Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
	    Sheet sheet = wb.createSheet("new sheet");
	    // Sheet sheet2 = wb.createSheet("second sheet?");// wrong naming
	    // for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
	    // String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
	    // Sheet sheet3 = wb.createSheet(safeName);

	    Row row = sheet.createRow(2);
	    row.createCell(0).setCellValue(1.1);
	    row.createCell(1).setCellValue(new Date());
	    row.createCell(2).setCellValue(Calendar.getInstance());
	    row.createCell(3).setCellValue("a string");
	    row.createCell(4).setCellValue(true);
	    row.createCell(5).setCellType(CellType.ERROR);
	    
	    OutputStream fileOut = new FileOutputStream("workbook.xls");
	    wb.write(fileOut);
	    
	}
}
