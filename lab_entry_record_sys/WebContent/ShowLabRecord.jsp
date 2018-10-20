<%@ page import="java.sql.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lab Entry Record</title>
<link rel="stylesheet" href="css/style3.css">
</head>

<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_entry_record_system","root","root");
Statement st=conn.createStatement();
ResultSet rs=st.executeQuery("SELECT sr_no,s_u_id,name,class,branch,roll_no,batch,s_date,in_time,out_time,subject FROM lab_entry INNER JOIN student_info ON s_u_id=u_id;");
%>
<h2><font color="#eeeeec">Lab Entry Record :</font></h2>
<br><br>
<table class="table-fill">
<tr>
	<th class="text-left">Sr.no.</th>
	<th class="text-left">U-ID</th>
	<th class="text-left">Name</th>
	<th class="text-left">Class</th>
	<th class="text-left">Branch</th>
	<th class="text-left">Roll.no</th>
	<th class="text-left">Batch</th>
	<th class="text-left">Date</th>
	<th class="text-left">In-Time</th>
	<th class="text-left">Out-Time</th>
	<th class="text-left">Subject</th>
</tr>
<%
while(rs.next()){
%>
<tbody class="table-hover">
<tr>
	<td class="text-left"><%=rs.getInt(1)%></td>
	<td class="text-left"><%=rs.getInt(2)%></td>
	<td class="text-left"><%=rs.getString(3)%></td>
	<td class="text-left"><%=rs.getString(4)%></td>
	<td class="text-left"><%=rs.getString(5)%></td>
	<td class="text-left"><%=rs.getInt(6)%></td>
	<td class="text-left"><%=rs.getString(7)%></td>
	<td class="text-left"><%=rs.getDate(8)%></td>
	<td class="text-left"><%=rs.getTime(9)%></td>
	<td class="text-left"><%=rs.getTime(10)%></td>
	<td class="text-left"><%=rs.getString(11)%></td>
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