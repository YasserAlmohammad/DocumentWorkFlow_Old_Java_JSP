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
<% if(userInfo.getPos_id()==-1) {%>
    <jsp:forward page="error.htm" />

<%}%>
  <p align="center">
<a href="inbox.jsp"><font color="#000080"><b>inbox</b></font></a>&nbsp;&nbsp;
<a href="outbox.jsp"><font color="#000080"><b>outbox</b></font></a>&nbsp;&nbsp;
<a href="sendPageGenerator.jsp"><font color="#000080"><b>send doc</b></font></a>&nbsp;&nbsp;
<a href="reporting.jsp"><font color="#000080"><b>reporting</b></font></a>&nbsp;&nbsp;
<a href="changeUserPass.jsp"><font color="#000080"><b>changePassword</b></font></a>&nbsp;&nbsp;
<a href="helpFiles/help.htm"><font color="#000080"><b>help&amp;support</b></font></a></p>
  <h1 align="center"><font color="#800000" size="5"><i>changePassword</i></font></h1>

  <!-- -->
  <form method="POST" action="change.jsp">
  <p> <b><font color="#666666">username &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;</b></font> <input type="text" name="username" size="20" ></p>
  <p> <b><font color="#666666">oldPassword &nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;</b></font> <input type="password" name="oldPassword" size="20" ></p>
  <p> <b><font color="#666666">newPassword &nbsp; : &nbsp;&nbsp;&nbsp;</b></font> <input type="password" name="newPassword" size="20" ></p>
<br>
  <p>
  <input type="submit" value="change" name="signout"></p>
</form>
<p align="right"><a href="homepage.jsp"><img border="0" src="images/60.gif" width="72" height="29"></a></p>
<form method="POST" action="SignOut.jsp">
  <p>
  <input type="submit" value="sign out" name="signout"></p>
</form>

</body>
</html>

