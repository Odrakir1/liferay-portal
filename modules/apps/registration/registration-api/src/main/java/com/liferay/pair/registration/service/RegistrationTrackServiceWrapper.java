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

package com.liferay.pair.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationTrackService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationTrackService
 * @generated
 */
public class RegistrationTrackServiceWrapper
	implements RegistrationTrackService,
			   ServiceWrapper<RegistrationTrackService> {

	public RegistrationTrackServiceWrapper(
		RegistrationTrackService registrationTrackService) {

		_registrationTrackService = registrationTrackService;
	}

	@Override
	public void addTrack(
		long groupId, long userId, long companyId, java.util.Date eventDatetime,
		String screenName, String iPAdress, String eventType) {

		_registrationTrackService.addTrack(
			groupId, userId, companyId, eventDatetime, screenName, iPAdress,
			eventType);
	}

	@Override
	public java.util.List<com.liferay.pair.registration.model.RegistrationTrack>
		getAllRegistrationsTrack() {

		return _registrationTrackService.getAllRegistrationsTrack();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationTrackService.getOSGiServiceIdentifier();
	}

	@Override
	public RegistrationTrackService getWrappedService() {
		return _registrationTrackService;
	}

	@Override
	public void setWrappedService(
		RegistrationTrackService registrationTrackService) {

		_registrationTrackService = registrationTrackService;
	}

	private RegistrationTrackService _registrationTrackService;

}