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

package com.liferay.pair.registration.model.impl;

import com.liferay.pair.registration.model.RegistrationTrack;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RegistrationTrack in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RegistrationTrackCacheModel
	implements CacheModel<RegistrationTrack>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegistrationTrackCacheModel)) {
			return false;
		}

		RegistrationTrackCacheModel registrationTrackCacheModel =
			(RegistrationTrackCacheModel)object;

		if (registrationTrackId ==
				registrationTrackCacheModel.registrationTrackId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, registrationTrackId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{registrationTrackId=");
		sb.append(registrationTrackId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventDatetime=");
		sb.append(eventDatetime);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", iPAdress=");
		sb.append(iPAdress);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RegistrationTrack toEntityModel() {
		RegistrationTrackImpl registrationTrackImpl =
			new RegistrationTrackImpl();

		registrationTrackImpl.setRegistrationTrackId(registrationTrackId);
		registrationTrackImpl.setGroupId(groupId);
		registrationTrackImpl.setUserId(userId);
		registrationTrackImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			registrationTrackImpl.setCreateDate(null);
		}
		else {
			registrationTrackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			registrationTrackImpl.setModifiedDate(null);
		}
		else {
			registrationTrackImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventDatetime == Long.MIN_VALUE) {
			registrationTrackImpl.setEventDatetime(null);
		}
		else {
			registrationTrackImpl.setEventDatetime(new Date(eventDatetime));
		}

		if (screenName == null) {
			registrationTrackImpl.setScreenName("");
		}
		else {
			registrationTrackImpl.setScreenName(screenName);
		}

		if (iPAdress == null) {
			registrationTrackImpl.setIPAdress("");
		}
		else {
			registrationTrackImpl.setIPAdress(iPAdress);
		}

		if (eventType == null) {
			registrationTrackImpl.setEventType("");
		}
		else {
			registrationTrackImpl.setEventType(eventType);
		}

		registrationTrackImpl.resetOriginalValues();

		return registrationTrackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		registrationTrackId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventDatetime = objectInput.readLong();
		screenName = objectInput.readUTF();
		iPAdress = objectInput.readUTF();
		eventType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(registrationTrackId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(eventDatetime);

		if (screenName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (iPAdress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iPAdress);
		}

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}
	}

	public long registrationTrackId;
	public long groupId;
	public long userId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long eventDatetime;
	public String screenName;
	public String iPAdress;
	public String eventType;

}