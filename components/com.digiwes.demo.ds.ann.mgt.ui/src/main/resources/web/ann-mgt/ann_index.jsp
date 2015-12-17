<%@ page import="com.digiwes.demo.ds.ann.mgt.ui.client.StudentClient" %>
<%@ page import="com.digiwes.demo.ds.ann.mgt.bean.Student" %>
<%@ page import="java.util.List" %>
<%
    StudentClient client = null ;
    List<Student> students = null ;
    try {
        client = StudentClient.getInstance();
        if(client != null){
            students = client.getStudentList();
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
    <h2>Demo Annotation Management</h2>

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
                for(Student student:students){
            %>
            <tr>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getAge()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>