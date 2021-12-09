package com.liferay.pair.registration.web.portlet.action;

import com.liferay.pair.registration.exception.BirthdayNotValidException;
import com.liferay.pair.registration.exception.EmailNotValidException;
import com.liferay.pair.registration.exception.NameNotValidException;
import com.liferay.pair.registration.exception.ToUNotAcceptedException;
import com.liferay.pair.registration.model.Registration;
import com.liferay.pair.registration.service.RegistrationService;
import com.liferay.pair.registration.service.RegistrationTrackService;
import com.liferay.pair.registration.web.constants.MVCCommandNames;
import com.liferay.pair.registration.web.constants.RegistrationMVCPortletKeys;
//import com.liferay.pair.registration.service.consta
import com.liferay.pair.registration.web.constants.RegistrationTrackConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + RegistrationMVCPortletKeys.REGISTRATIONMVC,
		"mvc.command.name=" + MVCCommandNames.ADD_REGISTRATION }, service = MVCActionCommand.class)
public class AddRegistrationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Registration.class.getName(), actionRequest);

		String firstName = ParamUtil.getString(actionRequest, "first_name");
		String lastName = ParamUtil.getString(actionRequest, "last_name");
		String emailAddress = ParamUtil.getString(actionRequest, "email_address");
		String username = ParamUtil.getString(actionRequest, "username");
		boolean male = ParamUtil.getBoolean(actionRequest, "male");
		Date birthday = ParamUtil.getDate(actionRequest, "birthday",
				DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd"));
		String password = ParamUtil.getString(actionRequest, "password");
		String confirmPassword = ParamUtil.getString(actionRequest, "password2");
		String homePhone = ParamUtil.getString(actionRequest, "home_phone");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobile_phone");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String zipcode = ParamUtil.getString(actionRequest, "zip");
		String securityQuestion = ParamUtil.getString(actionRequest, "security_question");
		String answer = ParamUtil.getString(actionRequest, "answer");
		boolean acceptedToU = ParamUtil.getBoolean(actionRequest, "accepted_tou");

		try {
			Registration registration = _registrationService.addRegistration(themeDisplay.getScopeGroupId(),username,
					firstName, lastName, emailAddress,
					male, birthday, password, confirmPassword,
					homePhone, mobilePhone, address1, address2,
					city, state, zipcode, securityQuestion, answer, acceptedToU, serviceContext);

		} catch (NameNotValidException nameNotValidException){
			SessionErrors.add(actionRequest,"name-not-valid");
		} catch (BirthdayNotValidException birthdayNotValidException){
			SessionErrors.add(actionRequest,"birthday-not-valid");
		} catch (EmailNotValidException emailNotValidException){
			SessionErrors.add(actionRequest,"email-not-valid");
		} catch (ToUNotAcceptedException toUNotAcceptedException){
			SessionErrors.add(actionRequest,"terms-of-use-not-accepted");
		} catch (Exception e){
			SessionErrors.add(actionRequest,"An unexpected error occurred");
		}

		_registrationTrackService.addTrack(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
				themeDisplay.getCompanyId(), new Date(),firstName, serviceContext.getRemoteAddr(), RegistrationTrackConstants.REGISTRATION);

		sendRedirect(actionRequest, actionResponse);
	}

	@Reference
	protected RegistrationService _registrationService;

	@Reference
	protected RegistrationTrackService _registrationTrackService;

	private static final Log _log = LogFactoryUtil.getLog(AddRegistrationMVCActionCommand.class);

}