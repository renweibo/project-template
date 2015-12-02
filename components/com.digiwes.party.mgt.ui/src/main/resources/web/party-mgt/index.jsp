<!--
 ~ Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 ~
 ~ WSO2 Inc. licenses this file to you under the Apache License,
 ~ Version 2.0 (the "License"); you may not use this file except
 ~ in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~    http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing,
 ~ software distributed under the License is distributed on an
 ~ "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 ~ KIND, either express or implied.  See the License for the
 ~ specific language governing permissions and limitations
 ~ under the License.
 -->
<%@ page import="org.apache.axis2.context.ConfigurationContext" %>
<%@ page import="org.wso2.carbon.CarbonConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil" %>
<%@ page import="org.wso2.carbon.utils.ServerConstants" %>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage" %>
<%@ page import="com.digiwes.baas.party.mgt.ui.PartyManagerClient" %>
<%@ page import="com.digiwes.baas.party.mgt.data.xsd.Party" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://wso2.org/projects/carbon/taglibs/carbontags.jar" prefix="carbon" %>
<%
        String serverURL = CarbonUIUtil.getServerURL(config.getServletContext(), session);
        ConfigurationContext configContext =
                (ConfigurationContext) config.getServletContext().getAttribute(CarbonConstants.CONFIGURATION_CONTEXT);
        String cookie = (String) session.getAttribute(ServerConstants.ADMIN_SERVICE_COOKIE);

        PartyManagerClient client;
        Party[] partys;

        try {
            client = new PartyManagerClient(configContext, serverURL, cookie);
            partys = client.getPartys();
        } catch (Exception e) {
            CarbonUIMessage.sendCarbonUIMessage(e.getMessage(), CarbonUIMessage.ERROR, request, e);
%>
            <script type="text/javascript">
                   location.href = "../admin/error.jsp";
            </script>
<%
            return;
    }
%>

<div id="middle">
	<h2>Party Management</h2>

    <div id="workArea">
		<table class="styledLeft" id="moduleTable">
                <thead>
                <tr>
                    <th width="40%">First Name</th>
                    <th width="40%">Last Name</th>
                    <th width="20%">Age</th>
                </tr>
                </thead>
                <tbody>
           <%
           		for(Party party:partys){
           %>
           		<tr>
                	<td><%=party.getFirstName()%></td>
                	<td><%=party.getLastName()%></td>
                	<td><%=party.getAge()%></td>             	
                </tr>
           <%
           		}
           %>
                </tbody>
         </table>
    </div>
</div>