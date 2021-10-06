/**
 * 
 */
package auto.orangehrm.utils;

import static java.util.Optional.ofNullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import auto.orangehrm.util.GB;

/**
 * Clase que escribe en un archivo XLS
 * 
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class WriteXlsFile {

	public void writeXlsFile(String filePath, String sheetName, String[] dataToWrite) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = ofNullable(newWorkbook.getSheet(sheetName))

				.orElse(GB.of(newWorkbook.createSheet(sheetName + "_" + "users"))
						.push(s -> s.createRow(0).createCell(0)).build());

		int lastRow = newSheet.getLastRowNum();
		for (int i = 0; i < dataToWrite.length; i++) {
			XSSFRow newRow = newSheet.createRow(lastRow + i);
			XSSFCell newCell = newRow.createCell(0);
			newCell.setCellValue(dataToWrite[i]);
		}

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
	}

	public void wirteCellValue(String filePath, String sheetName, int rowNumber, int cellNumber, String valuetoWrite)
			throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber - 1);
		System.out.println("Valor de primera celda es: " + cell.getStringCellValue());
		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(valuetoWrite);
		System.out.println("Valor de la siguiente celda: " + nextCell);

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();

	}

	public static void main(String[] args) throws IOException {
		WriteXlsFile file = new WriteXlsFile();
		String[] test = { "abner", "vicky" };
		file.writeXlsFile("C:\\Users\\Spot\\Documents\\OrangeHRMUserRoles.xlsx", "Sheet2", test);
	}

}
