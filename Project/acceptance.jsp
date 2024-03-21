<%@ include file="ConnectInclude.jsp" %>
<html>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<head>
<title>acceptance</title>
</head>

<body bgcolor="#eeeeee">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>


<p align="center">
<a href="inbox.jsp"><font color="#000080"><b>inbox</b></font></a>&nbsp;&nbsp;
<a href="outbox.jsp"><font color="#000080"><b>outbox</b></font></a>&nbsp;&nbsp;
<a href="sendPageGenerator.jsp"><font color="#000080"><b>send doc</b></font></a>&nbsp;&nbsp;
<a href="reporting.jsp"><font color="#000080"><b>reporting</b></font></a>&nbsp;&nbsp;
<a href="changeUserPass.jsp"><font color="#000080"><b>changePassword</b></font></a>&nbsp;&nbsp;
<a href="helpFiles/help.htm"><font color="#000080"><b>help&amp;support</b></font></a></p>
<form method="POST" action="redirect.jsp">
  <p>
  <% String doc_ids= request.getParameter("doc_ids");
     String content="",doc_serial="",doc_type="";
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
     ResultSet r=connector.executeQuery("SELECT date,content,doc_type,num_on_doc,date_on_doc FROM document WHERE serial="+doc_serial);

     while(r.next()){
      Timestamp d=r.getTimestamp("date");
      //check date match in day,month,year
      if((d.getYear()==doc_date.getYear())&&(d.getMonth()==doc_date.getMonth())&&(d.getDay()==doc_date.getDay())){
        content=r.getString("content");
        doc_type=r.getString("doc_type");
        num_on_doc=r.getString("num_on_doc");
        date_on_doc=r.getString("date_on_doc");
      }
     }%>

  <font color="#800000"><b>document numeber:<%=num_on_doc%> originated at:<%=date_on_doc%></b></font>
  <textarea rows="20" name="content" cols="100"><%= content %></textarea></p>
  <p>&nbsp;the above text will not change, if you have a note write it bellow:
  </p>
  <p><textarea rows="4" name="note" cols="50"> </textarea></p>
  <p><select size="1" name="choice">
  <!-- we could make serial as hidden field -->
  <option selected value="ok">ok</option>
  <option value="reject">reject</option>
  </select></p>



<%
    if(doc_type.equals("manual")){
       // view all positions available for manual direcing
   %> <h3>you must select destination position to send the message for </h3>
      <select size="1" name="pos_id"> <%
       String pos_name="",pos_id;
       ResultSet pos=connector.executeQuery("SELECT pos_name,pos_id FROM position WHERE pos_name<> 'administrator' AND pos_id<>"+userInfo.getPos_id());
       while(pos.next()){
         pos_name=pos.getString("pos_name");
         pos_id=pos.getString("pos_id");
         //we can know everything about user from pos_id
         %>
         <option value="<%= pos_id %>"> <%=pos_name %></option>
       <%}
        %>   </select></p> <%

   }
  }catch(SQLException e){ %>
    <h1> SQL error <h1> <%=e.toString() %>
<% } %>

  <!-- ids for the link are passed between interactived pages-->
  <input type="hidden" name="doc_serial" value="<%= doc_serial %>" >
  <input type="hidden" name="doc_date" value="<%=doc_date.getTime()%>" >
  <input type="hidden" name="arrive_date" value="<%=arrive_date.getTime()%>">
   <h4>if you are the one who published this documnet and rejeted it, it will be deleted permanently
  <br>you can check the document history to be sure of what happened before it reached you</h4>
  <p><input type="submit" value="submit" name="submit">&nbsp;&nbsp; </p>
</form>

<hr>
<form method="POST" action="showHistory.jsp">
  <input type="hidden" name="doc_serial" value="<%= doc_serial %>" >
  <input type="hidden" name="doc_date" value="<%=doc_date.getTime()%>" >
  <input type="submit" value="show this message history">
</form>
<hr>
</body>

</html>
