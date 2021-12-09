<%@ include file="/init.jsp" %>


<aui:model-context bean="${registration}" model="${registrationClass}" />

<%--<c:set var = "isSignedIn" value = "${!themeDisplay.isSignedIn()}"/>--%>
<%--<c:choose>--%>
<%--    <c:when test = "${isSignedIn}">--%>
        <%@ include file="registration/signup.jsp" %>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        <h2> Logged in!</h2>--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>