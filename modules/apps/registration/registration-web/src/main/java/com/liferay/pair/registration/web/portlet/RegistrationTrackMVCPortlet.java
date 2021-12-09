package com.liferay.pair.registration.web.portlet;

import com.liferay.pair.registration.service.RegistrationTrackService;
import com.liferay.pair.registration.web.constants.RegistrationMVCPortletKeys;
import com.liferay.pair.registration.web.constants.RegistrationTrackMVCPortletKeys;
import com.liferay.pair.registration.model.Registration;
import com.liferay.pair.registration.service.RegistrationService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

import javax.portlet.Portlet;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=RegistrationTrack",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/tracker/track.jsp",
                "javax.portlet.name=" + RegistrationTrackMVCPortletKeys.REGISTRATIOTRACKNMVC,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class RegistrationTrackMVCPortlet extends  MVCPortlet{
        @Override
        public void render(RenderRequest renderRequest, RenderResponse renderResponse)
                throws PortletException, IOException {
                try {
//                    List<Registration> registrations = _registrationTrackService.
//                    renderRequest.setAttribute("registrations", registrations);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                super.render(renderRequest, renderResponse);
        }

//    @Reference
//    protected RegistrationTrackService _registrationTrackService;
}
