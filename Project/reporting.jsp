<%@ page contentType="text/html; charset=windows-1252" %>
<%@ include file="ConnectInclude.jsp" %>

<html>

<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>Reporting</title>
</head>

<body bgcolor="#eeeeee">
<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>

<p align="center">
<a href="inbox.jsp"><font color="#000080"><b>inbox</b></font></a>&nbsp;&nbsp;
<a href="outbox.jsp"><font color="#000080"><b>outbox</b></font></a>&nbsp;&nbsp;
<a href="sendPageGenerator.jsp"><font color="#000080"><b>send doc</b></font></a>&nbsp;&nbsp;
<a href="reporting.jsp"><font color="#000080"><b>reporting</b></font></a>&nbsp;&nbsp;
<a href="changeUserPass.jsp"><font color="#000080"><b>changePassword</b></font></a>&nbsp;&nbsp;
<a href="helpFiles/help.htm"><font color="#000080"><b>help&amp;support</b></font></a></p>
<h1 align="center"><font color="#800000" size="5"><i>Reporting</i></font></h1>

<form method="POST" action="searchDoc.jsp">
 <dl>
    <p align="left"><b><font color="#666666">Find specefic document&nbsp;</font></b></p>
     <p> <input type="checkbox" name="C1"  value="ON"> <b><font color="#666666">number on document&nbsp; : &nbsp;&nbsp;&nbsp;</b></font> <input type="text" name="num_on_doc" size="20" ></p>
     <p> <input type="checkbox" name="C2"  value="ON"> <b><font color="#666666">date   on document&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;</b></font>
     <input type="text" name="day" size="2" >
     <input type="text" name="month" size="2" >
     <input type="text" name="year" size="4" >
     </p>
     <dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="submit" value="find" name="find"></dt>
     </dl>
</form>
<hr>
<!--       -->
<form method="POST" action="getDocsFrom.jsp">
 <dl>
   <p align="left"><b><font color="#666666">Find document reached from specefic
   position&nbsp;</font></b></p>
   <select size="1" name="pos_name">

<%try{
   String pos_name="";
   String pos_id="";

   //administrator is not count, and you can't send message to your self directly
   ResultSet poss=connector.executeQuery("SELECT pos_name FROM position WHERE pos_name<> 'administrator' AND pos_id<>"+userInfo.getPos_id());
   while(poss.next()){
       pos_name=poss.getString("pos_name");
      //we can know everything about user from pos_id
       %>

       <option value="<%= pos_name %>"> <%=pos_name %></option>
   <%}}catch(SQLException e){ %>
    <h1> SQL error <h1> <%=e.toString() %>
<% } %>
  </select>&nbsp;&nbsp;
  <input type="submit" value="find" name="find">
  </p></dl>
  <br><br>
</form>

<hr>

<form method="POST" action="getSendedTo.jsp">

 <dl>
  <p align="left"> <b><font color="#666666">Find documents sent to spesefic
  position</font></b></p>
   <select size="1" name="pos_name">

  <%try{
   String pos_name="";
   String pos_id="";

   //administrator is not count, and you can't send message to your self directly
   ResultSet poss=connector.executeQuery("SELECT pos_name FROM position WHERE pos_name<> 'administrator' AND pos_id<>"+userInfo.getPos_id());
   while(poss.next()){
       pos_name=poss.getString("pos_name");
      //we can know everything about user from pos_id
       %>
       <option value="<%= pos_name%>"> <%=pos_name %></option>
   <%}}catch(SQLException e){ %>
    <h1> SQL error <h1> <%=e.toString() %>
  <%}%>
  </select>&nbsp;&nbsp;
  <input type="submit" value="find" name="find">
  </p></dl>
</form>

<hr>

<form method="POST" action="sentDocsBetweenTwoDates.jsp">
   <b><font color="#666666">Find documents sent between &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></b>
   <input type="text" name="day1" size="2" >
   <input type="text" name="month1" size="2" >
   <input type="text" name="year1" size="4" >
   <b><font color="#666666">&nbsp;&nbsp; and &nbsp;&nbsp;</font></b>
   <input type="text" name="day2" size="2" >
   <input type="text" name="month2" size="2" >
   <input type="text" name="year2" size="4" >&nbsp;dates&nbsp;&nbsp;
   <input type="submit" value="find" name="find">
</form>

<hr>

<form method="POST" action="findRecieved.jsp">
   <b><font color="#666666">Find documents reached between &nbsp;&nbsp;</font></b>
   <input type="text" name="day1" size="2" >
   <input type="text" name="month1" size="2" >
   <input type="text" name="year1" size="4" >
   <b><font color="#666666">&nbsp;&nbsp; and &nbsp;&nbsp;</font></b>
   <input type="text" name="day2" size="2" >
   <input type="text" name="month2" size="2" >
   <input type="text" name="year2" size="4" >&nbsp;dates&nbsp;&nbsp;
   <input type="submit" value="find" name="find">
</form>
<br>

<hr>
<form method="POST" action="workLoad.jsp">
  <input type="submit" value="show work Load for all positions" >
</form>
<hr>
<p align="right"><a href="homepage.jsp"><img border="0" src="images/60.gif" width="72" height="29"></a></p>
<form method="POST" action="SignOut.jsp">
  <p>
  <input type="submit" value="sign out" name="signout"></p>
</form>

</body>

</html>