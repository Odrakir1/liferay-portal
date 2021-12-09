<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.pair.registration.web.constants.RegistrationMVCPortletKeys" %>
<%@ include file="../init.jsp" %>


<div class="centralize-content">
    <liferay-ui:error key="email" message="email-not-valid"/>
    <liferay-ui:error key="birthday-not-valid" message="birthday-not-valid"/>
    <liferay-ui:error key="name-not-valid" message="name-not-valid"/>
    <liferay-ui:error key="terms-of-use-not-accepted" message="terms-of-use-not-accepted"/>
</div>

<div class="main-container">
	<div class="title centralize-content">
		<h2>Sign up to Acme Movie Fanatics (AMF)</h2>

	</div>
    <portlet:actionURL name="<%= MVCCommandNames.ADD_REGISTRATION %>" var="userActionURL">
        <portlet:param name="redirect" value="${param.redirect}"/>
    </portlet:actionURL>


    <aui:form action="${userActionURL}" name="fm">
        <div class="main-content">
            <aui:fieldset-group markupView="lexicon">
                <div class="centralize-content">
                    <h3>User info</h3>
                </div>
                <aui:fieldset>

                    <%-- Title field. --%>

                    <aui:input label="First name" name="first_name">

                        <%-- <aui:validator name="required" />--%>

                        <%-- Custom AUI validator. --%>

                        <aui:validator errorMessage="error.assignment-name-format" name="custom">
                                    function (val, fieldNode, ruleValue) {
                                        var wordExpression =
                                                new RegExp("^[^\\[\\]\\^$<>]*$");

                                        return wordExpression.test(val);
                                    }
                        </aui:validator>
                    </aui:input>

                    <aui:input label="Last name" name="last_name">

                        <%-- <aui:validator name="required" />--%>

                        <%-- Custom AUI validator. --%>

                        <aui:validator errorMessage="error.assignment-name-format" name="custom">
                                    function (val, fieldNode, ruleValue) {
                                        var wordExpression =
                                                new RegExp("^[^\\[\\]\\^$<>]*$");

                                        return wordExpression.test(val);
                                    }
                        </aui:validator>
                    </aui:input>

                    <aui:input label="Email address" name="email_address" type="email">

                        <%-- <aui:validator name="required" />--%>

                    </aui:input>

                    <aui:input name="username">

                        <%-- <aui:validator name="required" />--%>

                        <%-- Custom AUI validator. --%>

                        <aui:validator errorMessage="error.assignment-name-format" name="custom">
                                    function (val, fieldNode, ruleValue) {
                                        var wordExpression =
                                                new RegExp("^[^\\[\\]\\^$<>]*$");

                                        return wordExpression.test(val);
                                    }
                        </aui:validator>
                    </aui:input>

                    <aui:input name="male" type="checkbox">

                    </aui:input>

                    <aui:input name="birthday" type="Date">

                        <%-- <aui:validator name="required" />--%>

                    </aui:input>

                    <aui:input name="password" type="password">

                        <%-- <aui:validator name="required" />--%>

                    </aui:input>

                    <aui:input label="Confirm password" name="password2" type="password">

                        <%-- <aui:validator name="required" />--%>

                    </aui:input>
                </aui:fieldset>
            </aui:fieldset-group>

            <hr/>
            <aui:fieldset-group>
                <div class="centralize-content">
                    <h3>Phone info</h3>
                </div>

                <aui:input label="Home phone" name="home_phone">
                </aui:input>

                <aui:input label="Mobile phone" name="mobile_phone">
                </aui:input>
            </aui:fieldset-group>

            <hr/>
            <aui:fieldset-group>
                <div class="centralize-content">
                    <h3>Billing Address</h3>
                </div>

                <aui:input label="Address 1" name="address1">
                    <%-- <aui:validator name="required" />--%>
                </aui:input>

                <aui:input label="Address 2" name="address2">
                </aui:input>

                <aui:input label="City" name="city">
                    <%-- <aui:validator name="required" />--%>
                </aui:input>

                <aui:input label="State" name="state">
                    <%-- <aui:validator name="required" />--%>
                </aui:input>

                <aui:input label="Zip Code" name="zip">
                    <%-- <aui:validator name="required" />--%>
                </aui:input>
            </aui:fieldset-group>

            <hr/>

            <aui:fieldset-group>
                <div class="centralize-content">
                    <h3>Misc.</h3>
                </div>

                <aui:select label="Security Question" name="security_question">
                    <aui:option selected="true"
                                value="What is your mother's maiden name?">What is your mother's maiden name? </aui:option>
                    <aui:option value="What is the make of your first car?">What is the make of your first car?</aui:option>
                    <aui:option value="What is your high school mascot?">What is your high school mascot?</aui:option>
                    <aui:option value="Who is your favorite actor?">Who is your favorite actor?</aui:option>
                </aui:select>

                <aui:input label="Answer" name="answer">
                </aui:input>

                <div class="tou-block">
                    <aui:button onClick="modal()" value="Read Terms of Use"></aui:button>
                </div>

                <aui:input name="accepted_tou" type="checkbox" label="I accept the Terms of Use of Liferay">
                </aui:input>
            </aui:fieldset-group>
            <div class="submit-button">
                <aui:button-row>
                    <aui:button cssClass="btn btn-primary" type="submit"/>
                </aui:button-row>
            </div>
        </div>
    </aui:form>
</div>

<%@include file="../terms-of-use/index.html"%>

<aui:script>
    var touContent = document.getElementById("tou-content").innerHTML;
    function modal () {
            Liferay.Util.openModal({
                title:"Terms of Use",
                bodyHTML: touContent
        });
    }
</aui:script>