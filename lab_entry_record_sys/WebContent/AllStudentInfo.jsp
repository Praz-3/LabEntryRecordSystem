<%@ page import="java.sql.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Info</title>
<link rel="stylesheet" href="css/style3.css">
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_entry_record_system","root","root");
Statement st=conn.createStatement();
ResultSet rs=st.executeQuery("SELECT * FROM student_info;");
%>
<h2><font color="#eeeeec">Registered Student Info :</font></h2>
<br><br>
<table class="table-fill">
<tr>
	<th class="text-left">U-ID</th>
	<th class="text-left">Name</th>
	<th class="text-left">Class</th>
	<th class="text-left">Branch</th>
	<th class="text-left">Roll.no</th>
	<th class="text-left">Batch</th>
</tr>
<%
while(rs.next()){
%>
<tbody class="table-hover">
<tr>
	<td class="text-left"><%=rs.getInt(1)%></td>
	<td class="text-left"><%=rs.getString(2)%></td>
	<td class="text-left"><%=rs.getString(3)%></td>
	<td class="text-left"><%=rs.getString(4)%></td>
	<td class="text-left"><%=rs.getInt(5)%></td>
	<td class="text-left"><%=rs.getString(6)%></td>
</tr>
<%} 
conn.close();
%>
</tbody>
</table>
<br><br>
<form action="OptionsLabAdmin.html">
<input type="submit" value="Home"/><br>
	</form>
</body>
</html>