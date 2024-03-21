<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>

<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
SignOut
</title>
</head>
<body bgcolor="#eeeeee">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>

<h1>
signing out ...
</h1>
<%  connector.disconnect();
    userInfo.setPos_id(-1);
%>

<jsp:forward page="secure.jsp" />

</body>
</html>
