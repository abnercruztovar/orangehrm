/**
 * 
 */
package auto.orangehrm.model;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class Employee {

	private String firstName;
	private String middleName;
	private String lastName;
	private Integer id;
	private String fullName;
	private Boolean exist = false;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setFullName(String firstName, String middleName, String lastName) {
		final String space = " ";
		StringBuilder sb = new StringBuilder();
		if (!StringUtils.isBlank(middleName)) {
			sb.append(firstName);
			sb.append(space);
			sb.append(middleName);
			sb.append(space);
			sb.append(lastName);
		} else {
			sb.append(firstName);
			sb.append(space);
			sb.append(lastName);

		}

		this.fullName = sb.toString();
	}

	/**
	 * @return the exist
	 */
	public Boolean getExist() {
		return exist;
	}

	/**
	 * @param exist the exist to set
	 */
	public void setExist(Boolean exist) {
		this.exist = exist;
	}

}
