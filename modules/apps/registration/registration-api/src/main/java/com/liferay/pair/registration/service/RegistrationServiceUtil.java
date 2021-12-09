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

import com.liferay.pair.registration.model.Registration;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Registration. This utility wraps
 * <code>com.liferay.pair.registration.service.impl.RegistrationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationService
 * @generated
 */
public class RegistrationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.pair.registration.service.impl.RegistrationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Registration addRegistration(
			long groupId, String username, String firstName, String lastName,
			String emailAddress, boolean male, java.util.Date birthday,
			String password, String confirmPassword, String homePhone,
			String mobilePhone, String address1, String address2, String city,
			String state, String zipcode, String securityQuestion,
			String answer, boolean acceptedToU,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addRegistration(
			groupId, username, firstName, lastName, emailAddress, male,
			birthday, password, confirmPassword, homePhone, mobilePhone,
			address1, address2, city, state, zipcode, securityQuestion, answer,
			acceptedToU, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static RegistrationService getService() {
		return _service;
	}

	private static volatile RegistrationService _service;

}