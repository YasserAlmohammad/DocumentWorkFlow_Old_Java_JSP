<%@ include file="ConnectInclude.jsp" %>

<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>
changePassword
</title>
</head>
<body bgcolor="#eeeeee">
<% if(userInfo.getPos_id()==-1){ %>
    <jsp:forward page="error.htm" />

<% }else{%>

   <p align="center">
<a href="inbox.jsp"><font color="#000080"><b>inbox</b></font></a>&nbsp;&nbsp;
<a href="outbox.jsp"><font color="#000080"><b>outbox</b></font></a>&nbsp;&nbsp;
<a href="sendPageGenerator.jsp"><font color="#000080"><b>send doc</b></font></a>&nbsp;&nbsp;
<a href="reporting.jsp"><font color="#000080"><b>reporting</b></font></a>&nbsp;&nbsp;
<a href="changeUserPass.jsp"><font color="#000080"><b>changePassword</b></font></a>&nbsp;&nbsp;
<a href="helpFiles/help.htm"><font color="#000080"><b>help&amp;support</b></font></a></p>
</p>
  <h1 align="center"><font color="#800000" size="5"><i>changePassword</i></font></h1>


  <!-- -->
<%  String oldPassword=request.getParameter("oldPassword");
    String newPassword=request.getParameter("newPassword");
    String username=request.getParameter("username");
    String pos_id="";
    String startDate="";
    String endDate="";
    try{
      ResultSet get=connector.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+oldPassword+"'");
      if (get.next()){
        connector.executeUpdate("UPDATE users SET password='"+newPassword+"' WHERE username='"+username+"'");
        %> <h3> password changed successfully </h3>
    <%
       }
      else{%>
        <h3> hello there, this account not exists!</h3>
     <%}

    }catch(SQLException e){%>
        <h2> SQL error:</h2> <%= e.toString() %>
  <% }} %>



<p align="right"><a href="homepage.jsp"><img border="0" src="images/60.gif" width="72" height="29"></a></p>
<form method="POST" action="SignOut.jsp">
  <p>
  <input type="submit" value="sign out" name="signout"></p>
</form>

</body>
</html>

