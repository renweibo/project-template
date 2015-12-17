<%@ page import="com.digiwes.demo.ds.mgt.ui.client.EmployeeClient" %>
<%@ page import="com.digiwes.demo.ds.mgt.bean.Employee" %>
<%@ page import="java.util.List" %>
<%
    EmployeeClient client = null ;
    List<Employee> employees = null ;
    try {
        client = EmployeeClient.getInstance();
        if(client != null){
            employees = client.getEmployeeList();
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
    <h2>Demo DS Management</h2>

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
                for(Employee employee:employees){
            %>
            <tr>
                <td><%=employee.getId()%></td>
                <td><%=employee.getName()%></td>
                <td><%=employee.getAge()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>