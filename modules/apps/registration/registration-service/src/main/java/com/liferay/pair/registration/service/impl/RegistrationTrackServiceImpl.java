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

package com.liferay.pair.registration.service.impl;

import com.liferay.pair.registration.model.RegistrationTrack;
import com.liferay.pair.registration.service.RegistrationTrackLocalService;
import com.liferay.pair.registration.service.base.RegistrationTrackServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the registration track remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.pair.registration.service.RegistrationTrackService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationTrackServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=acme",
		"json.web.service.context.path=RegistrationTrack"
	},
	service = AopService.class
)
public class RegistrationTrackServiceImpl
	extends RegistrationTrackServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.pair.registration.service.RegistrationTrackServiceUtil</code> to access the registration track remote service.
	 */

	public void addTrack(long groupId, long userId, long companyId, Date eventDatetime,
						 String screenName, String iPAdress, String eventType){

		_registrationTrackLocalService.addTrack(groupId,userId,companyId,eventDatetime,screenName,iPAdress,eventType);
	}

	public List<RegistrationTrack> getAllRegistrationsTrack(){
		return _registrationTrackLocalService.getAllRegistrationsTrack();
	}

	@Reference
	private RegistrationTrackLocalService _registrationTrackLocalService;
}