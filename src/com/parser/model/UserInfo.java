/**
 * 
 */
package com.parser.model;

import java.util.List;

/**
 * @author pushpendra
 * 
 */
public class UserInfo {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", location=" + location + ", phone="
				+ phone + ", hobbies=" + hobbies + ", userInfoExtra="
				+ userInfoExtra + "]";
	}

	private String name;
	private String location;
	private long phone;
	private List<String> hobbies;
	private List<UserInfoExtra> userInfoExtra;

	

	/**
	 * @return the userInfoExtra
	 */
	public List<UserInfoExtra> getUserInfoExtra() {
		return userInfoExtra;
	}

	/**
	 * @param userInfoExtra the userInfoExtra to set
	 */
	public void setUserInfoExtra(List<UserInfoExtra> userInfoExtra) {
		this.userInfoExtra = userInfoExtra;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the phone
	 */
	public Long getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}

	/**
	 * @return the hobbies
	 */
	public List<String> getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	
}
