
/**
 * 
 */
package auto.orangehrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import auto.orangehrm.steps.GetUserListSteps;

/**
 * Clase que lee un archivo XLS
 * 
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class ReadXlsFile {

	private int rowCount;

	public ReadXlsFile() {
		// Default consutructor
	}

	/**
	 * Retorna un arreglo con la lista de nombres de las hojas
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public List<String> getSheets(String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

		List<String> lstSheets = new ArrayList<>();
		for (int i = 0; i < newWorkbook.getNumberOfSheets(); i++) {
			lstSheets.add(newWorkbook.getSheetName(i));
		}

		return lstSheets;
	}

	/**
	 * Lee un archivo de Excel
	 * 
	 * @param filePath
	 * @param sheetName
	 * @throws IOException
	 * @throws IOException
	 */
	public void readXls(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		rowCount = newSheet.getLastRowNum() + newSheet.getFirstRowNum();

		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "||");
			}
		}

	}

	public List<String> getRolesToWork(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		rowCount = newSheet.getLastRowNum() + 1;
		List<String> lstRoles = new ArrayList<>();

		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				lstRoles.add(row.getCell(j).getStringCellValue());
			}
		}

		return lstRoles;

	}

	/**
	 * Retorna el contenido de una celda de un archivo de excel
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws Exception
	 */
	public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws Exception {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);

		return cell.getStringCellValue();
	}

	public static void main(String[] args) throws IOException {
		ReadXlsFile file = new ReadXlsFile();
		file.cleanXlsForTest(GetUserListSteps.XSLX_FILE_PATH);
		List<String> roles = file.getRolesToWork(GetUserListSteps.XSLX_FILE_PATH, "Sheet1");

	}

	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * prepara el archivo xlsx para el test
	 * 
	 * @param xslsFilePath
	 * @throws IOException
	 */
	public void cleanXlsForTest(String xslsFilePath) throws IOException {
		File file = new File(xslsFilePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

		List<String> lstSheets = new ArrayList<>();
		for (int i = 0; i < newWorkbook.getNumberOfSheets(); i++) {
			if ("sheet1".equalsIgnoreCase(newWorkbook.getSheetName(i))) {
				continue;
			}
			newWorkbook.removeSheetAt(i);
		}
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();

	}

}
