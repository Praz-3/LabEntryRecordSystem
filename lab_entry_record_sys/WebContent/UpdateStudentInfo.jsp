<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Info</title>
<script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>


  
  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet prefetch' href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>

      <link rel="stylesheet" href="css/style2.css">
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_entry_record_system","root","root");
PreparedStatement ps1=conn.prepareStatement("SELECT * FROM student_info WHERE u_id=?");
ps1.setInt(1, Integer.parseInt(request.getParameter("u_id")));
ResultSet rs1=ps1.executeQuery();
PreparedStatement ps2=conn.prepareStatement("SELECT * FROM student_uname_pass WHERE uname=?");
ps2.setInt(1, Integer.parseInt(request.getParameter("u_id")));
ResultSet rs2=ps2.executeQuery();
if(rs1.next()){
%>


<div class="container">
<fieldset>
<legend><font color="white">Update Student Info :</font></legend><br>
<form class="well form-horizontal" action="UpdateStudentInf"  id="contact_form">
<div class="form-group">
  <label class="col-md-4 control-label">U-ID</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="u_id" value="<%=rs1.getInt(1)%>" READONLY class="form-control"  type="text">
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" >Name</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="s_name" value="<%=rs1.getString(2)%>" class="form-control"  type="text">
    </div>
  </div>
</div>

<div class="form-group"> 
  <label class="col-md-4 control-label">Class</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-book"></i></span>
    <select name="s_class" class="form-control selectpicker" >
      <option value="<%=rs1.getString(3)%>"><%=rs1.getString(3)%></option>
      <option>FY</option>
      <option>SY</option>
      <option >TY</option>
      <option >B.Tech</option>      
    </select>
  </div>
</div>
</div>

<div class="form-group"> 
  <label class="col-md-4 control-label">Branch</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-screenshot"></i></span>
    <select name="branch" class="form-control selectpicker" >
      <option value="<%=rs1.getString(4)%>" ><%=rs1.getString(4)%></option>
      <option>CSE</option>
      <option>Mech</option>
      <option >ETC</option>
      <option >Civil</option>      
    </select>
  </div>
</div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" >Roll No</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-tag"></i></span>
  <input name="roll_no" value="<%=rs1.getInt(5)%>" class="form-control"  type="text">
    </div>
  </div>
</div>

<div class="form-group"> 
  <label class="col-md-4 control-label">Batch</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-th-large"></i></span>
    <select name="batch" class="form-control selectpicker" >
      <option value="<%=rs1.getString(6)%>" ><%=rs1.getString(6)%></option>
      <option>S1</option>
      <option>S2</option>
      <option >S3</option>
      <option >S4</option>      
    </select>
  </div>
</div>
</div>
<%} if(rs2.next()){ %>
<div class="form-group">
  <label class="col-md-4 control-label" >Password</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="pass" value="<%=rs2.getString(2)%>" class="form-control"  type="text">
    </div>
  </div>
</div>
<%}
conn.close(); %>
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-warning" form="contact_form" >Submit <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>
</form>

<form action="OptionsLabAdmin.html" id="form2">
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-warning" form="form2" >Cancel <span class="glyphicon glyphicon-remove"></span></button>
  </div>
</div>
</form>
</fieldset>

</div><!-- /.container -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>

    <script  src="js/index2.js"></script>




	
</body>
</html>