<%@ page contentType="text/html; charset=windows-1252" %>
<%@ include file="ConnectInclude.jsp" %>
<%@ page import="java.lang.String"%>


<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
findRecieved
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

  <!-- -->
 <%int b=0;
   String doc_serial="";
   Timestamp  doc_date;
   String  pos_id="";
   String pos_name="";
   String doc_ids="";
   String month1=request.getParameter("month1");
   String year1=request.getParameter("year1");
   String day1=request.getParameter("day1");
   String month2=request.getParameter("month2");
   String year2=request.getParameter("year2");
   String day2=request.getParameter("day2");
   Timestamp date=new Timestamp(0,0,0,0,0,0,0);
   Timestamp date1=new Timestamp(0,0,0,0,0,0,0);
   Timestamp date2=new Timestamp(0,0,0,0,0,0,0);
   int dd1=0,mm1=0,yyyy1=0;
   int dd2=0,mm2=0,yyyy2=0;

   try{ //check date format
      dd1=Integer.valueOf(day1).intValue();
      mm1=Integer.valueOf(month1).intValue();
      yyyy1=Integer.valueOf(year1).intValue();
      dd2=Integer.valueOf(day2).intValue();
      mm2=Integer.valueOf(month2).intValue();
      yyyy2=Integer.valueOf(year2).intValue();
   }
   catch(NumberFormatException e){
      %> <h3> the date parameters are wrong, check it again</h3> <%
   }

   //check date for value errors
   if((!((dd1>0)&&(dd1<32)&&(mm1<13)&&(mm1>0)&&(yyyy1<2050)&&(yyyy1>1980))) &&(!((dd2>0)&&(dd2<32)&&(mm2<13)&&(mm2>0)&&(yyyy2<2050)&&(yyyy2>1980)))){
   b=1;
      %><h3> error: date is invalid </h3><%
   }else{ //continue
   yyyy1=yyyy1-1900;
   yyyy2=yyyy2-1900;
   mm1=mm1-1;
   mm2=mm2-1;
   date1=new Timestamp(yyyy1,mm1,dd1,0,0,0,0);
   date2=new Timestamp(yyyy2,mm2,dd2,0,0,0,0);
   }
     try{
      ResultSet r;
      r=connector.executeQuery("SELECT COUNT(pos_id) FROM position");
      int count=0;
      int i=0;
      if(r.next()){
      count=r.getInt(1);
      }
      r=connector.executeQuery("SELECT pos_id,pos_name FROM position");
      String [][] pos=new String [count][2];
      while((r.next())&&(i<count)){
      pos[i][0]=r.getString("pos_id");
      pos[i][1]=r.getString("pos_name");
      ++i;
      }
     ResultSet link=connector.executeQuery("SELECT from_pos,doc_serial,doc_date,note_date FROM history WHERE  to_pos="+userInfo.getPos_id());
     while(link.next()){
        pos_id=link.getString("from_pos");
        doc_serial=link.getString("doc_serial");
        doc_date=link.getTimestamp("doc_date");
        date=link.getTimestamp("note_date");
        doc_ids=doc_serial+"*"+doc_date.getTime()+"*";
        int j=0;
        while (j<count){
          if (pos[j][0].equals(pos_id)){
           pos_name=pos[j][1];
           }
          j++;
        }
        if ((date1.before(date)) && (date.before(date2))) {
           b=1;%>
           <img border="0" src="images/11.gif" width="20" height="20">&nbsp;
          <a href="viewContent.jsp?doc_ids=<%= doc_ids %>"><b>message frome <%=pos_name%> at <%= date %></b> </a> <br>
     <% } }

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

