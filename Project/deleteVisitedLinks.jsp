<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>
<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
deleteVisitedLinks
</title>
</head>
<body bgcolor="#eeeeee">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<% try{
      connector.executeUpdate("DELETE FROM inbox WHERE visited='yes' AND belongs_to_pos="+userInfo.getPos_id());
      %>
      <jsp:forward page="inbox.jsp" />
      <%
   }
   catch(SQLException e){
    %> ERROR: <%= e.toString() %>
  <%} %>
</body>
</html>
