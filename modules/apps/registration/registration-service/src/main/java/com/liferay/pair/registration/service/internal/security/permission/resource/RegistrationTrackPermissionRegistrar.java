package com.liferay.pair.registration.service.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.pair.registration.model.RegistrationTrack;
import com.liferay.pair.registration.service.RegistrationTrackLocalService;
import com.liferay.pair.registration.service.constants.RegistrationTrackConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.*;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.GroupService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;

import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;

import java.util.Dictionary;

@Component(
        immediate = true,
        service = RegistrationTrackPermissionRegistrar.class
)
public class RegistrationTrackPermissionRegistrar {
    public static boolean contains(
            PermissionChecker permissionChecker, RegistrationTrack registrationTrack,
            String actionId)
            throws PortalException {
        return _assignmentModelResourcePermission.contains(
                permissionChecker, registrationTrack, actionId);
    }
    public static boolean contains(
            PermissionChecker permissionChecker, long assignmentId, String actionId)
            throws PortalException {
        return _assignmentModelResourcePermission.contains(
                permissionChecker, assignmentId, actionId);
    }

    @Activate
    public void activate(BundleContext bundleContext){

        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("model.class.name", RegistrationTrack.class.getName());

        _serviceRegistration = bundleContext.registerService(
                ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        RegistrationTrack.class, RegistrationTrack::getRegistrationTrackId,
                        _registrationTrackLocalService::getRegistrationTrack, _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
                            consumer.accept(
                                    new StagedModelPermissionLogic<RegistrationTrack>(
                                            _stagingPermission, RegistrationTrackConstants.RESOURCE_NAME,
                                            RegistrationTrack::getRegistrationTrackId));
                            consumer.accept(
                                    new WorkflowedModelPermissionLogic<RegistrationTrack>(
                                            _workflowPermission, modelResourcePermission,
                                            _groupLocalService, RegistrationTrack::getRegistrationTrackId));
                        }),
                properties);
    }

    public RegistrationTrack cloneWithOriginalValues(){
        return null;
    }

    @Reference(
            target = "(model.class.name=com.liferay.pair.registration.model.RegistrationTrack)",
            unbind = "-"
    )
    protected void setEntryModelPermission(
            ModelResourcePermission<RegistrationTrack> modelResourcePermission) {
        _assignmentModelResourcePermission = modelResourcePermission;
    }
    private static ModelResourcePermission<RegistrationTrack>
            _assignmentModelResourcePermission;

    @Reference
    private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;

    @Reference
    private WorkflowPermission _workflowPermission;

    @Reference
    private RegistrationTrackLocalService _registrationTrackLocalService;

    @Reference
    private ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference(target = "(resource.name=" + RegistrationTrackConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

}