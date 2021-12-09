/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.pair.registration.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Registration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Registration
 * @generated
 */
public class RegistrationWrapper
	extends BaseModelWrapper<Registration>
	implements ModelWrapper<Registration>, Registration {

	public RegistrationWrapper(Registration registration) {
		super(registration);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("registrationId", getRegistrationId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("username", getUsername());
		attributes.put("male", isMale());
		attributes.put("birthday", getBirthday());
		attributes.put("password", getPassword());
		attributes.put("confirmPassword", getConfirmPassword());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zipcode", getZipcode());
		attributes.put("securityQuestion", getSecurityQuestion());
		attributes.put("answer", getAnswer());
		attributes.put("acceptedToU", isAcceptedToU());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long registrationId = (Long)attributes.get("registrationId");

		if (registrationId != null) {
			setRegistrationId(registrationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		Boolean male = (Boolean)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String confirmPassword = (String)attributes.get("confirmPassword");

		if (confirmPassword != null) {
			setConfirmPassword(confirmPassword);
		}

		String homePhone = (String)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String securityQuestion = (String)attributes.get("securityQuestion");

		if (securityQuestion != null) {
			setSecurityQuestion(securityQuestion);
		}

		String answer = (String)attributes.get("answer");

		if (answer != null) {
			setAnswer(answer);
		}

		Boolean acceptedToU = (Boolean)attributes.get("acceptedToU");

		if (acceptedToU != null) {
			setAcceptedToU(acceptedToU);
		}
	}

	/**
	 * Returns the accepted to u of this registration.
	 *
	 * @return the accepted to u of this registration
	 */
	@Override
	public boolean getAcceptedToU() {
		return model.getAcceptedToU();
	}

	/**
	 * Returns the address1 of this registration.
	 *
	 * @return the address1 of this registration
	 */
	@Override
	public String getAddress1() {
		return model.getAddress1();
	}

	/**
	 * Returns the address2 of this registration.
	 *
	 * @return the address2 of this registration
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the answer of this registration.
	 *
	 * @return the answer of this registration
	 */
	@Override
	public String getAnswer() {
		return model.getAnswer();
	}

	/**
	 * Returns the birthday of this registration.
	 *
	 * @return the birthday of this registration
	 */
	@Override
	public Date getBirthday() {
		return model.getBirthday();
	}

	/**
	 * Returns the city of this registration.
	 *
	 * @return the city of this registration
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this registration.
	 *
	 * @return the company ID of this registration
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the confirm password of this registration.
	 *
	 * @return the confirm password of this registration
	 */
	@Override
	public String getConfirmPassword() {
		return model.getConfirmPassword();
	}

	/**
	 * Returns the create date of this registration.
	 *
	 * @return the create date of this registration
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email address of this registration.
	 *
	 * @return the email address of this registration
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the first name of this registration.
	 *
	 * @return the first name of this registration
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this registration.
	 *
	 * @return the group ID of this registration
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the home phone of this registration.
	 *
	 * @return the home phone of this registration
	 */
	@Override
	public String getHomePhone() {
		return model.getHomePhone();
	}

	/**
	 * Returns the last name of this registration.
	 *
	 * @return the last name of this registration
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the male of this registration.
	 *
	 * @return the male of this registration
	 */
	@Override
	public boolean getMale() {
		return model.getMale();
	}

	/**
	 * Returns the mobile phone of this registration.
	 *
	 * @return the mobile phone of this registration
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this registration.
	 *
	 * @return the modified date of this registration
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the password of this registration.
	 *
	 * @return the password of this registration
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this registration.
	 *
	 * @return the primary key of this registration
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the registration ID of this registration.
	 *
	 * @return the registration ID of this registration
	 */
	@Override
	public long getRegistrationId() {
		return model.getRegistrationId();
	}

	/**
	 * Returns the security question of this registration.
	 *
	 * @return the security question of this registration
	 */
	@Override
	public String getSecurityQuestion() {
		return model.getSecurityQuestion();
	}

	/**
	 * Returns the state of this registration.
	 *
	 * @return the state of this registration
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user ID of this registration.
	 *
	 * @return the user ID of this registration
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the username of this registration.
	 *
	 * @return the username of this registration
	 */
	@Override
	public String getUsername() {
		return model.getUsername();
	}

	/**
	 * Returns the user uuid of this registration.
	 *
	 * @return the user uuid of this registration
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the zipcode of this registration.
	 *
	 * @return the zipcode of this registration
	 */
	@Override
	public String getZipcode() {
		return model.getZipcode();
	}

	/**
	 * Returns <code>true</code> if this registration is accepted to u.
	 *
	 * @return <code>true</code> if this registration is accepted to u; <code>false</code> otherwise
	 */
	@Override
	public boolean isAcceptedToU() {
		return model.isAcceptedToU();
	}

	/**
	 * Returns <code>true</code> if this registration is male.
	 *
	 * @return <code>true</code> if this registration is male; <code>false</code> otherwise
	 */
	@Override
	public boolean isMale() {
		return model.isMale();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this registration is accepted to u.
	 *
	 * @param acceptedToU the accepted to u of this registration
	 */
	@Override
	public void setAcceptedToU(boolean acceptedToU) {
		model.setAcceptedToU(acceptedToU);
	}

	/**
	 * Sets the address1 of this registration.
	 *
	 * @param address1 the address1 of this registration
	 */
	@Override
	public void setAddress1(String address1) {
		model.setAddress1(address1);
	}

	/**
	 * Sets the address2 of this registration.
	 *
	 * @param address2 the address2 of this registration
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the answer of this registration.
	 *
	 * @param answer the answer of this registration
	 */
	@Override
	public void setAnswer(String answer) {
		model.setAnswer(answer);
	}

	/**
	 * Sets the birthday of this registration.
	 *
	 * @param birthday the birthday of this registration
	 */
	@Override
	public void setBirthday(Date birthday) {
		model.setBirthday(birthday);
	}

	/**
	 * Sets the city of this registration.
	 *
	 * @param city the city of this registration
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this registration.
	 *
	 * @param companyId the company ID of this registration
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the confirm password of this registration.
	 *
	 * @param confirmPassword the confirm password of this registration
	 */
	@Override
	public void setConfirmPassword(String confirmPassword) {
		model.setConfirmPassword(confirmPassword);
	}

	/**
	 * Sets the create date of this registration.
	 *
	 * @param createDate the create date of this registration
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email address of this registration.
	 *
	 * @param emailAddress the email address of this registration
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the first name of this registration.
	 *
	 * @param firstName the first name of this registration
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this registration.
	 *
	 * @param groupId the group ID of this registration
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the home phone of this registration.
	 *
	 * @param homePhone the home phone of this registration
	 */
	@Override
	public void setHomePhone(String homePhone) {
		model.setHomePhone(homePhone);
	}

	/**
	 * Sets the last name of this registration.
	 *
	 * @param lastName the last name of this registration
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets whether this registration is male.
	 *
	 * @param male the male of this registration
	 */
	@Override
	public void setMale(boolean male) {
		model.setMale(male);
	}

	/**
	 * Sets the mobile phone of this registration.
	 *
	 * @param mobilePhone the mobile phone of this registration
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this registration.
	 *
	 * @param modifiedDate the modified date of this registration
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the password of this registration.
	 *
	 * @param password the password of this registration
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this registration.
	 *
	 * @param primaryKey the primary key of this registration
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the registration ID of this registration.
	 *
	 * @param registrationId the registration ID of this registration
	 */
	@Override
	public void setRegistrationId(long registrationId) {
		model.setRegistrationId(registrationId);
	}

	/**
	 * Sets the security question of this registration.
	 *
	 * @param securityQuestion the security question of this registration
	 */
	@Override
	public void setSecurityQuestion(String securityQuestion) {
		model.setSecurityQuestion(securityQuestion);
	}

	/**
	 * Sets the state of this registration.
	 *
	 * @param state the state of this registration
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user ID of this registration.
	 *
	 * @param userId the user ID of this registration
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the username of this registration.
	 *
	 * @param username the username of this registration
	 */
	@Override
	public void setUsername(String username) {
		model.setUsername(username);
	}

	/**
	 * Sets the user uuid of this registration.
	 *
	 * @param userUuid the user uuid of this registration
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the zipcode of this registration.
	 *
	 * @param zipcode the zipcode of this registration
	 */
	@Override
	public void setZipcode(String zipcode) {
		model.setZipcode(zipcode);
	}

	@Override
	protected RegistrationWrapper wrap(Registration registration) {
		return new RegistrationWrapper(registration);
	}

	public RegistrationWrapper cloneWithOriginalValues(){
		return null;
	}
}