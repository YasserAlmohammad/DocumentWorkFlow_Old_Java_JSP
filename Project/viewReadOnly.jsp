<%@ include file="ConnectInclude.jsp" %>
<html>

<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>reasd only view</title>
</head>

<body bgcolor="#eeeeee">
<p align="center">
<a href="inbox.jsp"><font color="#000080"><b>inbox</b></font></a>&nbsp;&nbsp;
<a href="outbox.jsp"><font color="#000080"><b>outbox</b></font></a>&nbsp;&nbsp;
<a href="sendPageGenerator.jsp"><font color="#000080"><b>send doc</b></font></a>&nbsp;&nbsp;
<a href="reporting.jsp"><font color="#000080"><b>reporting</b></font></a>&nbsp;&nbsp;
<a href="changeUserPass.jsp"><font color="#000080"><b>changePassword</b></font></a>&nbsp;&nbsp;
<a href="helpFiles/help.htm"><font color="#000080"><b>help&amp;support</b></font></a></p>
  <% String doc_ids= request.getParameter("doc_ids");
     String content="",doc_serial="";
     Timestamp doc_date=null,arrive_date=null;
     String num_on_doc="",date_on_doc="";
    try{
    //we wrapped document identifiers in the request parameters
     StringTokenizer tokens=new StringTokenizer(doc_ids);
     if(tokens.hasMoreElements())
        doc_serial=tokens.nextToken("*"); // * was the separator between date and serial: date may has spaces
     if(tokens.hasMoreElements())
        doc_date=new Timestamp(Long.valueOf(tokens.nextToken("*")).longValue());
    if(tokens.hasMoreElements())
        arrive_date=new Timestamp(Long.valueOf(tokens.nextToken("*")).longValue());
     ResultSet r=connector.executeQuery("SELECT date,content,num_on_doc,date_on_doc FROM document WHERE serial="+doc_serial);

     while(r.next()){
      Timestamp d=r.getTimestamp("date");
      //check date match in day,month,year
      if((d.getYear()==doc_date.getYear())&&(d.getMonth()==doc_date.getMonth())&&(d.getDay()==doc_date.getDay())){
        content=r.getString("content");
        num_on_doc=r.getString("num_on_doc");
        date_on_doc=r.getString("date_on_doc");
      }
     }%>

  <font color="800000">document numeber:<%=num_on_doc%> originated at:<%=date_on_doc%></font>
  <textarea rows="20" name="content" cols="100"><%= content %></textarea></p>
  <%
  }
  catch(SQLException e){
    %> ERROR, you can't view this page <%
  }
%>
<p align="right"><a href="homepage.jsp"><img border="0" src="images/60.jpg" width="72" height="29"></a></p>
<form method="POST" action="SignOut.jsp">
  <p>
  <input type="submit" value="sign out" name="signout"></p>
</form>
</body>
</html>