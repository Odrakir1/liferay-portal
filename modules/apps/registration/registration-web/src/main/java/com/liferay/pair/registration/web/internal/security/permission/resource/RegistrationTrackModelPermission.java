package com.liferay.pair.registration.web.internal.security.permission.resource;

import com.liferay.pair.registration.model.RegistrationTrack;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class RegistrationTrackModelPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, RegistrationTrack registrationTrack, String actionId) throws PortalException {

        return _registrationTrackModelResourcePermission.contains(permissionChecker, registrationTrack, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long registrationTrackId, String actionId) throws PortalException {

        return _registrationTrackModelResourcePermission.contains(permissionChecker, registrationTrackId, actionId);
    }

    @Reference(
            target = "(model.class.name=com.liferay.pair.registration.model.RegistrationTrack)",
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<RegistrationTrack> modelResourcePermission) {

        _registrationTrackModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<RegistrationTrack> _registrationTrackModelResourcePermission;


}
