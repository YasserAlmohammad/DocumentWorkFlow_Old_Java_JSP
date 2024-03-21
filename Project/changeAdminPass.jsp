<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>
<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>
changeAdminPass
</title>
</head>

<body bgcolor="#eeeeee">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<% String newPass=request.getParameter("newPass");
   if(!newPass.equals("")){  //administartor password can't be null
        connector.executeUpdate("UPDATE users SET password='"+newPass+"' WHERE username='Admin'");
        %> <h3> password changed successfully </h3> <%
   }
   else{
      %> <h3> be realistic, input a password </h3> <%
   }
%>

</body>
</html>
