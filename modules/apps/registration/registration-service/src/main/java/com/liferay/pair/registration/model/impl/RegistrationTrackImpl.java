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

/**
 * The extended model implementation for the RegistrationTrack service. Represents a row in the &quot;Acme_RegistrationTrack&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.pair.registration.model.RegistrationTrack</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class RegistrationTrackImpl extends RegistrationTrackBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a registration track model instance should use the {@link com.liferay.pair.registration.model.RegistrationTrack} interface instead.
	 */
	public RegistrationTrackImpl() {
	}

	@Override
	public String getUserName() {
		return null;
	}

	@Override
	public void setUserName(String userName) {

	}

	@Override
	public RegistrationTrackImpl cloneWithOriginalValues(){
		return null;
	}
}