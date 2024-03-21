<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>
<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<!-- the hiostory of the current document -->
<title>
showHistory
</title>
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
<br>
<table border="2" cellpadding="2" cellspacing="2">
  <tr>
      <td>From</td>
      <td> To </td>
      <td> response </td>
      <td> at </td>
      <td> note </td>
  </tr>

<% String doc_serial=request.getParameter("doc_serial");
   String doc_date_str=request.getParameter("doc_date");
   Timestamp doc_date=new Timestamp(Long.valueOf(doc_date_str).longValue());
   try{

   ResultSet row_num=connector.executeQuery("SELECT doc_date FROM history WHERE doc_serial="+doc_serial);
   int count=0;
   Timestamp d=null; // the doc_date we get from the query
   while(row_num.next()){
    d=row_num.getTimestamp("doc_date");
    if((d.getYear()==doc_date.getYear())&&(d.getMonth()==doc_date.getMonth())&&(d.getDate()==doc_date.getDate()))
      ++count;
   }
   ResultSet r=connector.executeQuery("SELECT doc_date,to_pos,from_pos,note,response,note_date FROM history WHERE doc_serial="+doc_serial+"ORDER BY  note_date");
   String [][] History=new String [count][5];
   //ResultSet can't be instantiated this is why it can be used for one query at a time
   int i=0;
   while((r.next())&&(i<count)){
     d=r.getTimestamp("doc_date");
     if((d.getYear()==doc_date.getYear())&&(d.getMonth()==doc_date.getMonth())&&(d.getDate()==doc_date.getDate())){
       History[i][0]=r.getString("to_pos");
       History[i][1]=r.getString("from_pos");
       History[i][2]=r.getString("note");
       History[i][3]=r.getString("response");
       History[i][4]=r.getString("note_date");
       ++i;
     }
   }
    //now we got the info in an array, we'll use it for mutible query to get the position names

    for(i=0;i<count;i++){
      String to_name="",from_name="";
      r=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+History[i][0]);
      if(r.next())
        to_name=r.getString("pos_name");
      r=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+History[i][1]);
      if(r.next())
        from_name=r.getString("pos_name");

      %><tr>
            <td> <%=from_name%>  </td>
            <td> <%=to_name%>    </td>
            <td> <%= History[i][3] %>    </td>
            <td> <%= History[i][4] %>     </td>
            <td> <%= History[i][2] %>     </td>

        </tr>
      <%


   }}
   catch(SQLException e){
      %> <h3> ERROR: </h3> <%= e.toString() %>
   <% }
%>
</table>
<p align="right"><a href="homepage.jsp"><img border="0" src="images/60.gif" width="72" height="29"></a></p>
<form method="POST" action="SignOut.jsp">
  <p>
  <input type="submit" value="sign out" name="signout"></p>
</form>
</body>
</html>
