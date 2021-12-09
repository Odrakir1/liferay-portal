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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.pair.registration.service.http.RegistrationTrackServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class RegistrationTrackSoap implements Serializable {

	public static RegistrationTrackSoap toSoapModel(RegistrationTrack model) {
		RegistrationTrackSoap soapModel = new RegistrationTrackSoap();

		soapModel.setRegistrationTrackId(model.getRegistrationTrackId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventDatetime(model.getEventDatetime());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setIPAdress(model.getIPAdress());
		soapModel.setEventType(model.getEventType());

		return soapModel;
	}

	public static RegistrationTrackSoap[] toSoapModels(
		RegistrationTrack[] models) {

		RegistrationTrackSoap[] soapModels =
			new RegistrationTrackSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegistrationTrackSoap[][] toSoapModels(
		RegistrationTrack[][] models) {

		RegistrationTrackSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RegistrationTrackSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RegistrationTrackSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegistrationTrackSoap[] toSoapModels(
		List<RegistrationTrack> models) {

		List<RegistrationTrackSoap> soapModels =
			new ArrayList<RegistrationTrackSoap>(models.size());

		for (RegistrationTrack model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RegistrationTrackSoap[soapModels.size()]);
	}

	public RegistrationTrackSoap() {
	}

	public long getPrimaryKey() {
		return _registrationTrackId;
	}

	public void setPrimaryKey(long pk) {
		setRegistrationTrackId(pk);
	}

	public long getRegistrationTrackId() {
		return _registrationTrackId;
	}

	public void setRegistrationTrackId(long registrationTrackId) {
		_registrationTrackId = registrationTrackId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getEventDatetime() {
		return _eventDatetime;
	}

	public void setEventDatetime(Date eventDatetime) {
		_eventDatetime = eventDatetime;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getIPAdress() {
		return _iPAdress;
	}

	public void setIPAdress(String iPAdress) {
		_iPAdress = iPAdress;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	private long _registrationTrackId;
	private long _groupId;
	private long _userId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _eventDatetime;
	private String _screenName;
	private String _iPAdress;
	private String _eventType;

}