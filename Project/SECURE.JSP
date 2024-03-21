<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>
<% // this page will prevent user from entering the system using history button
   // security matter
%>


<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<SCRIPT language="javascript">
function loadEvent(){
  document.forward.goToLogin.click()
}
</script>
<title>secure</title>
</head>
<body onLoad="loadEvent()">
<form name="forward" method="POST" action="login.htm">
  <input type="submit" value="Submit" name="goToLogin">
</form>
</body>
</html>

