<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>

<html>

<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>homepage</title>
</head>

<body bgcolor="#eeeeee">


<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<% ResultSet r=connector.executeQuery("SELECT username FROM users WHERE pos_id="+userInfo.getPos_id());
   String username="";
   if(r.next())
     username=r.getString("username");
%>

<p><font color="#800000" size="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
W</font><font color="#800000" size="4">elcome
<%=username%> to your Home Page&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>
<p align="center"><img border="0" src="images/mmm.gif" width="140" height="56"></p>
<h3 align="center"><a href="inbox.jsp"><font color="#000000"><b>inbox</b></font></a></h3>
<h3 align="center"><a href="outbox.jsp"><font color="#000000"><b>outbox</b></font></a></h3>
<h3 align="center"><a href="sendPageGenerator.jsp"><font color="#000000"><b>send doc</b></font></a></h3>
<h3 align="center"><a href="reporting.jsp"><font color="#000000"><b>reporting</b></font></a></h3>
<h3 align="center"><a href="changeUserPass.jsp"><font color="#000000"><b>changePassword</b></font></a></h3>
<h3 align="center"><a href="helpFiles/help.htm"><font color="#000000"><b>help&amp;support</b></font></a></h3>
<h3 align="center"><a href="help/new_page_1.htm"><font color="#000000"><b>help&amp;support 2nd version</b></font></a></h3>

<form method="POST" action="SignOut.jsp">
  <!--webbot bot="SaveResults" U-File="_private/form_results.csv" S-Format="TEXT/CSV" S-Label-Fields="TRUE" startspan --><input TYPE="hidden" NAME="VTI-GROUP" VALUE="0"><!--webbot bot="SaveResults" i-checksum="43374" endspan --><p>
  <input type="submit" value="signout" name="signout"></p>
</form>
<p align="left">&nbsp;</p>

</body>

</html>
