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

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.pair.registration.model.Registration;
import com.liferay.pair.registration.model.RegistrationTrack;
import com.liferay.pair.registration.service.base.RegistrationTrackLocalServiceBaseImpl;
import com.liferay.pair.registration.service.persistence.RegistrationPersistence;
import com.liferay.pair.registration.service.persistence.RegistrationTrackPersistence;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ResourceLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the registration track local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.pair.registration.service.RegistrationTrackLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationTrackLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.pair.registration.model.RegistrationTrack",
	service = AopService.class
)
public class RegistrationTrackLocalServiceImpl
	extends RegistrationTrackLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.pair.registration.service.RegistrationTrackLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.pair.registration.service.RegistrationTrackLocalServiceUtil</code>.
	 */

	public void addTrack(long groupId, long userId, long companyId, Date eventDatetime,
						 String screenName, String iPAdress, String eventType){

		long registrationTrackId = _counterLocalService.increment(RegistrationTrack.class.getName());

		RegistrationTrack registrationTrack = _registrationTrackPersistence.create(registrationTrackId);

		registrationTrack.setCompanyId(companyId);
		registrationTrack.setGroupId(groupId);
		registrationTrack.setEventDatetime(eventDatetime);
		registrationTrack.setIPAdress(iPAdress);
		registrationTrack.setScreenName(screenName);
		registrationTrack.setEventType(eventType);

		try {
			_resourceLocalService.addResources(companyId, groupId, userId,
					RegistrationTrack.class.getName(), registrationTrack.getRegistrationTrackId(), false, false, false);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		_registrationTrackPersistence.update(registrationTrack);
	}

	public List<RegistrationTrack> getAllRegistrationsTrack() {
		return _registrationTrackPersistence.findAll();
	}

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private RegistrationTrackPersistence _registrationTrackPersistence;

	@Reference
	private ResourceLocalService _resourceLocalService;
}