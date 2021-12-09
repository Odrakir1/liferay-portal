<%@ include file="../init.jsp" %>


<%
    List<Registration> registrations = (List<Registration>) renderRequest.getAttribute("registrations");

    List<Registration> registrationsMale = new ArrayList<Registration>();
    List<Registration> registrationsFemale = new ArrayList<Registration>();

    for (int i = 0; i < registrations.size(); i++) {
        if (!registrations.get(i).getMale()) {
           registrationsFemale.add(registrations.get(i));
        } else {
           registrationsMale.add(registrations.get(i));
        }
    }
%>

<aui:container>
    <liferay-ui:tabs names="All,Male,Female" refresh="false" tabsValues="All,Male,Female" value="Male">
        <liferay-ui:section>
            <liferay-ui:search-container total="<%= registrations.size() %>" delta="2"  deltaConfigurable="false" emptyResultsMessage="No Registration Found" curParam="sc1">
                <liferay-ui:search-container-results>  <%
                     results = ListUtil.subList(registrations, searchContainer.getStart(), searchContainer.getEnd());
                     total = registrations.size();
                     pageContext.setAttribute("results", results);
                     pageContext.setAttribute("total", total);
                 %> </liferay-ui:search-container-results>
                <liferay-ui:search-container-row
                    className="com.liferay.pair.registration.model.Registration"
                    modelVar="registration"
                >
                    <liferay-ui:search-container-column-text title="First Name" property="firstName"/>

                    <liferay-ui:search-container-column-text title="Last Name" property="lastName"/>
                </liferay-ui:search-container-row>

                <liferay-ui:search-iterator />
            </liferay-ui:search-container>
        </liferay-ui:section>
        <liferay-ui:section>
            <liferay-ui:search-container total="<%= registrationsMale.size() %>" delta="2" deltaConfigurable="false" emptyResultsMessage="No Males Found" curParam="sc2">
                <liferay-ui:search-container-results>  <%
                     results = ListUtil.subList(registrationsMale, searchContainer.getStart(), searchContainer.getEnd());
                     total = registrationsMale.size();

                     pageContext.setAttribute("results", results);
                     pageContext.setAttribute("total", total);
                 %> </liferay-ui:search-container-results>
                <liferay-ui:search-container-row
                    className="com.liferay.pair.registration.model.Registration"
                    modelVar="registration"
                >
                    <liferay-ui:search-container-column-text title="First Name" property="firstName"/>
                    <liferay-ui:search-container-column-text title="Last Name" property="lastName"/>
                </liferay-ui:search-container-row>

                <liferay-ui:search-iterator />
            </liferay-ui:search-container>
        </liferay-ui:section>
        <liferay-ui:section>
            <liferay-ui:search-container total="<%= registrationsFemale.size() %>" delta="2" deltaConfigurable="false" emptyResultsMessage="No Females Found" curParam="sc3">
                <liferay-ui:search-container-results>  <%
                     results = ListUtil.subList(registrationsFemale, searchContainer.getStart(), searchContainer.getEnd());
                     total = registrationsFemale.size();

                     pageContext.setAttribute("results", results);
                     pageContext.setAttribute("total", total);
                 %> </liferay-ui:search-container-results>
                <liferay-ui:search-container-row
                    className="com.liferay.pair.registration.model.Registration"
                    modelVar="registration"
                >
                    <liferay-ui:search-container-column-text title="First Name" property="firstName"/>
                    <liferay-ui:search-container-column-text title="Last Name" property="lastName"/>
                </liferay-ui:search-container-row>

                <liferay-ui:search-iterator />
            </liferay-ui:search-container>
        </liferay-ui:section>
    </liferay-ui:tabs>
</aui:container>