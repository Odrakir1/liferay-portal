package com.liferay.pair.registration.web.portlet.action;

import com.liferay.pair.registration.model.RegistrationTrack;
import com.liferay.pair.registration.service.RegistrationTrackService;
import com.liferay.pair.registration.web.constants.RegistrationTrackMVCCommandNames;
import com.liferay.pair.registration.web.constants.RegistrationTrackMVCPortletKeys;
import com.liferay.pair.registration.web.internal.security.permission.resource.RegistrationTrackPermission;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


import javax.portlet.*;
import java.util.List;

@Component(immediate = true, property = { "javax.portlet.name=" + RegistrationTrackMVCPortletKeys.REGISTRATIOTRACKNMVC,
        "mvc.command.name=" + RegistrationTrackMVCCommandNames.RENDER_TRACK},   service = MVCRenderCommand.class)
public class ViewRegistrationTrackMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        renderRequest.setAttribute("registrationTrackPermission", _registrationTrackPermission);
        ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        try {
            List<RegistrationTrack> registrations = _registrationTrackService.getAllRegistrationsTrack();
            renderRequest.setAttribute("registrations", registrations);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/tracker/track.jsp";
    }

    @Reference
    protected RegistrationTrackPermission _registrationTrackPermission;

    @Reference
    protected RegistrationTrackService _registrationTrackService;
}
