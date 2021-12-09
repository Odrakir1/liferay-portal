package com.liferay.pair.registration.service.internal.security.permission.resource;

import com.liferay.pair.registration.service.constants.RegistrationTrackConstants;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Reference;

public class RegistrationTrackTopLevelPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, String actionId) {
        return _portletResourcePermission.contains(permissionChecker, groupId, actionId);
    }

    @Reference(
            target = "(resource.name=" + RegistrationTrackConstants.RESOURCE_NAME + ")",
            unbind = "-"
    )

    protected void setPortletResourcePermission(
            PortletResourcePermission portletResourcePermission) {
        _portletResourcePermission = portletResourcePermission;
    }

    private static PortletResourcePermission _portletResourcePermission;
}
