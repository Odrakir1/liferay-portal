<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.pair.registration.model.Registration"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>


<%@ page import="com.liferay.pair.registration.web.constants.MVCCommandNames" %>

<%@ page import="com.liferay.pair.registration.web.internal.security.permission.resource.RegistrationTrackModelPermission" %>
<%@ page import="com.liferay.pair.registration.web.internal.security.permission.resource.RegistrationTrackPermission" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />