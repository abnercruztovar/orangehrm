/**
 * 
 */
package auto.orangehrm.steps;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import auto.orangehrm.pages.LoginPage;
import auto.orangehrm.pages.UserPage;
import auto.orangehrm.utils.ReadXlsFile;
import auto.orangehrm.utils.WriteXlsFile;
import net.thucydides.core.annotations.Step;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class GetUserListSteps {

	public static final String XSLX_FILE_PATH = "/orangehrm/src/test/resources/files/OrangeHRMUserRoles.xlsx";
	LoginPage lPage;
	UserPage uPage;

	private Map<String, WebElement> lstElements = new HashMap<>();

	private WriteXlsFile writeFile;
	private ReadXlsFile readFile;

	@Step
	public void loginAndOpen() {
		lPage.open();
		lPage.userLogin("Admin");
		lPage.passLogin("admin123");
	}

	@Step
	public void searchUsersByRole() throws Exception {
		ReadXlsFile xlsFile = new ReadXlsFile();
		xlsFile.cleanXlsForTest(XSLX_FILE_PATH);
		List<String> roles = xlsFile.getRolesToWork(XSLX_FILE_PATH, "Sheet1");

		for (int i = 0; i < roles.size(); i++) {
			lstElements.put(roles.get(i), (WebElement) uPage.searchUsersByRole(roles.get(i)));
		}
	}

	@Step
	public void saveUserInfo() throws IOException {
		List<String> roles = lstElements.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
		for (String string : roles) {
			List<WebElement> results = lstElements.entrySet().stream().map(Map.Entry::getValue)
					.collect(Collectors.toList());
			String[] infoToPersist = results.stream().map(e -> e.getText()).collect(Collectors.toList())
					.toArray(new String[lstElements.size()]);
			WriteXlsFile xlsFile = new WriteXlsFile();
			xlsFile.writeXlsFile(XSLX_FILE_PATH, string, infoToPersist);
		}

	}

	/**
	 * @return the writeFile
	 */
	public WriteXlsFile getWriteFile() {
		return writeFile;
	}

	/**
	 * @param writeFile the writeFile to set
	 */
	public void setWriteFile(WriteXlsFile writeFile) {
		this.writeFile = writeFile;
	}

	/**
	 * @return the readFile
	 */
	public ReadXlsFile getReadFile() {
		return readFile;
	}

	/**
	 * @param readFile the readFile to set
	 */
	public void setReadFile(ReadXlsFile readFile) {
		this.readFile = readFile;
	}

}
