<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>

<html>

<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>inbox</title>
</head>

<body bgcolor="#eeeeee"  link="#200000"  Vlink="#0000FF">

<% if(userInfo.getPos_id()<0){  //security matter: if you are not signed in you can't see this page
      %> <jsp:forward page="error.htm" />
 <%}
%>

<p align="center">
<a href="inbox.jsp"><font color="#000080"><b>inbox</b></font></a>&nbsp;&nbsp;
<a href="outbox.jsp"><font color="#000080"><b>outbox</b></font></a>&nbsp;&nbsp;
<a href="sendPageGenerator.jsp"><font color="#000080"><b>send doc</b></font></a>&nbsp;&nbsp;
<a href="reporting.jsp"><font color="#000080"><b>reporting</b></font></a>&nbsp;&nbsp;
<a href="changeUserPass.jsp"><font color="#000080"><b>changePassword</b></font></a>&nbsp;&nbsp;
<a href="helpFiles/help.htm"><font color="#000080"><b>help&amp;support</b></font></a></p>
<h1 align="center"><font color="#800000" size="5"><i>Inbox</i></font></h1>
<!-- newly recieved messages -->
<br>
  <font color="#800000" size="4">newly received&nbsp; message:</font>
  <br>

  <!-- ***************************************************************-->
  <% ResultSet new_links=connector.executeQuery("SELECT doc_serial,subject,doc_date,arrive_date,visited FROM inbox WHERE belongs_to_pos="+ userInfo.getPos_id()+" AND visited='no'");
     String doc_ids="",doc_serial="",visited="",subj="";
     Timestamp doc_date=null,arrive_date=null;
     while(new_links.next()){
        doc_serial=new_links.getString("doc_serial");
        subj=new_links.getString("subject");
        doc_date=new_links.getTimestamp("doc_date");
        arrive_date=new_links.getTimestamp("arrive_date");
        visited=new_links.getString("visited");
        doc_ids=doc_serial+"*"+doc_date.getTime()+"*"+arrive_date.getTime();%>

        <!-- we pass ids throught request -->
        <img border="0" src="images/11.gif" width="20" height="20">&nbsp;
        <a href="acceptance.jsp?doc_ids=<%= doc_ids %>"><b>message from <%= subj %> at <%= doc_date %></b> </a>
        <br>
     <% } %>
<br>

<br>
<!-- history trash -->
<form method="POST" action="deleteVisitedLinks.jsp">
  <p>
  <font color="#800000" size="4">visited messages(Read only): </font></p>
     <% ResultSet visited_links=connector.executeQuery("SELECT doc_serial,subject,doc_date,arrive_date,visited FROM inbox WHERE belongs_to_pos="+ userInfo.getPos_id()+" AND visited='yes'");
     while(visited_links.next()){
        doc_serial=visited_links.getString("doc_serial");
        subj=visited_links.getString("subject");
        doc_date=visited_links.getTimestamp("doc_date");
        arrive_date=visited_links.getTimestamp("arrive_date");
        visited=visited_links.getString("visited");
        doc_ids=doc_serial+"*"+doc_date.getTime()+"*"+arrive_date.getTime();%>
        <img border="0" src="images/11.gif" width="20" height="20">&nbsp;
        <a href="viewReadOnly.jsp?doc_ids=<%= doc_ids %>"><b>message from <%= subj %> at <%= doc_date %></b> </a><br>
   <%  } %>
  <p><input type="submit" value="delete visted links" name="emptytrash"></p>
</form>
<p>&nbsp;</p>
<p align="right"><a href="homepage.jsp"><img border="0" src="images/60.gif" width="72" height="29"></a></p>
<form method="POST" action="SignOut.jsp">
  <p>
  <input type="submit" value="sign out" name="signout"></p>
</form>

</body>

</html>
