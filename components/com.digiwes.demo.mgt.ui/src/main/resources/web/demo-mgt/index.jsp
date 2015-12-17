<%@ page import="com.digiwes.demo.mgt.ui.client.PersonClient" %>
<%@ page import="com.digiwes.demo.mgt.bean.Person" %>
<%@ page import="java.util.List" %>
<%
    PersonClient client = null ;
    List<Person> persons = null ;
    try {
        client = PersonClient.getInstance();
        if(client != null){
            persons = client.getPersons();
        }
    } catch (Exception e) {
        //CarbonUIMessage.sendCarbonUIMessage(e.getMessage(), CarbonUIMessage.ERROR, request, e);
%>
<script type="text/javascript">
    location.href = "error.jsp";
</script>
<%
       return;
    }
%>

<div id="middle">
    <h2>Demo Management</h2>

    <div id="workArea">
        <table class="styledLeft" id="moduleTable">
            <thead>
            <tr>
                <th width="40%">Number</th>
                <th width="40%">Name</th>
                <th width="20%">Age</th>
            </tr>
            </thead>
            <tbody>
            <%
                for(Person person:persons){
            %>
            <tr>
                <td><%=person.getId()%></td>
                <td><%=person.getName()%></td>
                <td><%=person.getAge()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>