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
import com.liferay.pair.registration.exception.*;
import com.liferay.pair.registration.model.Registration;
import com.liferay.pair.registration.service.base.RegistrationLocalServiceBaseImpl;
import com.liferay.pair.registration.service.persistence.RegistrationPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.util.LocaleUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.pair.registration.service.RegistrationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.pair.registration.model.Registration",
	service = AopService.class
)
public class RegistrationLocalServiceImpl
	extends RegistrationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.pair.registration.service.RegistrationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.pair.registration.service.RegistrationLocalServiceUtil</code>.
	 */

	
	public Registration addRegistration(long groupId, String username, String firstName,
			String lastName, String emailAddress,
			boolean male, Date birthday, String password,
			String confirmPassword, String homePhone, String mobilePhone,
			String address1, String address2, String city,
			String state, String zipcode, String securityQuestion, 
			String answer, boolean acceptedToU, ServiceContext serviceContext) throws PortalException {
		
		long registrationId = _counterLocalService.increment(Registration.class.getName());
		
		Registration registration = _registrationPersistence.create(registrationId);

		_checkName(firstName);
		_checkName(lastName);
		_checkBirthday(birthday);
		_checkEmailAddress(emailAddress);
		_checkToU(acceptedToU);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);

		User user = null;

		try{
			user = _userService.addUser(serviceContext.getCompanyId(),false,password,confirmPassword,
					true,firstName,emailAddress, LocaleUtil.getDefault(),firstName,null,lastName,
					0L,0L,male,calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),
					calendar.get(Calendar.YEAR),null,null,null,
					null,null,false,serviceContext);
		}
		catch (Exception e){
			e.printStackTrace();
		}

		registration.setUserId(user.getUserId());
		registration.setUsername(username);
		registration.setGroupId(groupId);
		registration.setFirstName(firstName);
		registration.setLastName(lastName);
		registration.setEmailAddress(emailAddress);
		registration.setMale(male);
		registration.setBirthday(birthday);
		registration.setPassword(password);
		registration.setConfirmPassword(confirmPassword);
		registration.setHomePhone(homePhone);
		registration.setMobilePhone(mobilePhone);
		registration.setAddress1(address1);
		registration.setAddress2(address2);
		registration.setCity(city);
		registration.setState(state);
		registration.setZipcode(zipcode);
		registration.setSecurityQuestion(securityQuestion);
		registration.setAnswer(answer);
		registration.setAcceptedToU(acceptedToU);
		
		return _registrationPersistence.update(registration);
		
	}

	private void _checkEmailAddress(String emailAddress) throws EmailNotValidException {
		Pattern pattern = Pattern.compile("^(?i)[a-z]+@(?i)[a-z]+\\.(?i)[a-z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(emailAddress);
		boolean matchFound = matcher.find();
		boolean matchSize = emailAddress.length() <= 250 ? true : false;

		matchFound = matchSize && matchSize;

		if(!matchFound){
			throw new EmailNotValidException("Provided email is not valid");
		}
	}

	private void _checkName(String name) throws NameNotValidException {
		if(name.isEmpty() || name.length() > 50){
			throw new NameNotValidException("Name length should be greater than zero and smaller than 50");
		}
	}

	private void _checkBirthday(Date date) throws NameNotValidException, BirthdayNotValidException {
		try{
			if(date instanceof Date){
				Date todayDate = new Date();

				long diff = todayDate.getTime() - date.getTime();

				long diffInDays = TimeUnit.DAYS.convert(diff,TimeUnit.DAYS);

				double age = Math.floor(diffInDays/12/31);

				if(age < 13){
					throw new BirthdayNotValidException("Date should be at least 13 year old");
				}

			}
		}
		catch (Exception e){
			throw new BirthdayNotValidException("Date should be at least 13 year old");
		}

	}

	private void _checkToU(boolean acceptedToU) throws ToUNotAcceptedException {
		if(!acceptedToU){
			throw new ToUNotAcceptedException("Terms of Use must be accepted");
		}
	}

	@Reference
	private CounterLocalService _counterLocalService;
	
	@Reference
	private RegistrationPersistence _registrationPersistence;

	@Reference
	private UserService _userService;
}