<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>

<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
search messages from position
</title>
</head>
<body bgcolor="#eeeeee"  link="#200000"  Vlink="#ffffff">
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
  <h1 align="center"><font color="#800000" size="5"><i>Reporting</i></font></h1>
     <%
     int b=0;
     String pos_name= request.getParameter("pos_name");
     String doc_serial="";
     Timestamp doc_date,note_date;
     String pos_id="";
     String doc_ids="";
     try{
     ResultSet dep_id=connector.executeQuery("SELECT pos_id FROM position WHERE pos_name='"+pos_name+"'");
     if (dep_id.next()){
        pos_id=dep_id.getString("pos_id");
     }

     ResultSet link=connector.executeQuery("SELECT doc_serial,doc_date,note_date FROM history WHERE to_pos="+userInfo.getPos_id() + "AND from_pos="+pos_id);
     while(link.next()){
        b=1;
        doc_serial=link.getString("doc_serial");
        doc_date=link.getTimestamp("doc_date");
        note_date=link.getTimestamp("note_date");
        doc_ids=doc_serial+"*"+doc_date.getTime()+"*";%>
        <img border="0" src="images/11.gif" width="20" height="20">&nbsp;
        <a href="viewContent.jsp?doc_ids=<%= doc_ids %>"><b>message from <%=pos_name%> at <%= note_date %> </b></a><br>


    <%}
     if (b==0){%>
       <p> <b><font color="#666666" size="4"> there is no document </font></b></p>
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

