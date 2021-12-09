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
 * This class is a wrapper for {@link RegistrationTrack}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationTrack
 * @generated
 */
public class RegistrationTrackWrapper
	extends BaseModelWrapper<RegistrationTrack>
	implements ModelWrapper<RegistrationTrack>, RegistrationTrack {

	public RegistrationTrackWrapper(RegistrationTrack registrationTrack) {
		super(registrationTrack);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("registrationTrackId", getRegistrationTrackId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventDatetime", getEventDatetime());
		attributes.put("screenName", getScreenName());
		attributes.put("iPAdress", getIPAdress());
		attributes.put("eventType", getEventType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long registrationTrackId = (Long)attributes.get("registrationTrackId");

		if (registrationTrackId != null) {
			setRegistrationTrackId(registrationTrackId);
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

		Date eventDatetime = (Date)attributes.get("eventDatetime");

		if (eventDatetime != null) {
			setEventDatetime(eventDatetime);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String iPAdress = (String)attributes.get("iPAdress");

		if (iPAdress != null) {
			setIPAdress(iPAdress);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}
	}

	/**
	 * Returns the company ID of this registration track.
	 *
	 * @return the company ID of this registration track
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this registration track.
	 *
	 * @return the create date of this registration track
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event datetime of this registration track.
	 *
	 * @return the event datetime of this registration track
	 */
	@Override
	public Date getEventDatetime() {
		return model.getEventDatetime();
	}

	/**
	 * Returns the event type of this registration track.
	 *
	 * @return the event type of this registration track
	 */
	@Override
	public String getEventType() {
		return model.getEventType();
	}

	/**
	 * Returns the group ID of this registration track.
	 *
	 * @return the group ID of this registration track
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the i p adress of this registration track.
	 *
	 * @return the i p adress of this registration track
	 */
	@Override
	public String getIPAdress() {
		return model.getIPAdress();
	}

	/**
	 * Returns the modified date of this registration track.
	 *
	 * @return the modified date of this registration track
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this registration track.
	 *
	 * @return the primary key of this registration track
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the registration track ID of this registration track.
	 *
	 * @return the registration track ID of this registration track
	 */
	@Override
	public long getRegistrationTrackId() {
		return model.getRegistrationTrackId();
	}

	/**
	 * Returns the screen name of this registration track.
	 *
	 * @return the screen name of this registration track
	 */
	@Override
	public String getScreenName() {
		return model.getScreenName();
	}

	/**
	 * Returns the user ID of this registration track.
	 *
	 * @return the user ID of this registration track
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this registration track.
	 *
	 * @return the user uuid of this registration track
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this registration track.
	 *
	 * @param companyId the company ID of this registration track
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this registration track.
	 *
	 * @param createDate the create date of this registration track
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event datetime of this registration track.
	 *
	 * @param eventDatetime the event datetime of this registration track
	 */
	@Override
	public void setEventDatetime(Date eventDatetime) {
		model.setEventDatetime(eventDatetime);
	}

	/**
	 * Sets the event type of this registration track.
	 *
	 * @param eventType the event type of this registration track
	 */
	@Override
	public void setEventType(String eventType) {
		model.setEventType(eventType);
	}

	/**
	 * Sets the group ID of this registration track.
	 *
	 * @param groupId the group ID of this registration track
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the i p adress of this registration track.
	 *
	 * @param iPAdress the i p adress of this registration track
	 */
	@Override
	public void setIPAdress(String iPAdress) {
		model.setIPAdress(iPAdress);
	}

	/**
	 * Sets the modified date of this registration track.
	 *
	 * @param modifiedDate the modified date of this registration track
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this registration track.
	 *
	 * @param primaryKey the primary key of this registration track
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the registration track ID of this registration track.
	 *
	 * @param registrationTrackId the registration track ID of this registration track
	 */
	@Override
	public void setRegistrationTrackId(long registrationTrackId) {
		model.setRegistrationTrackId(registrationTrackId);
	}

	/**
	 * Sets the screen name of this registration track.
	 *
	 * @param screenName the screen name of this registration track
	 */
	@Override
	public void setScreenName(String screenName) {
		model.setScreenName(screenName);
	}

	/**
	 * Sets the user ID of this registration track.
	 *
	 * @param userId the user ID of this registration track
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this registration track.
	 *
	 * @param userUuid the user uuid of this registration track
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected RegistrationTrackWrapper wrap(
		RegistrationTrack registrationTrack) {

		return new RegistrationTrackWrapper(registrationTrack);
	}

	public RegistrationTrackWrapper cloneWithOriginalValues(){
		return null;
	}
}