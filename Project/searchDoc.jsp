<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>

<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
searchDoc
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
     <%
     int b=0;
     String num_on_doc= request.getParameter("num_on_doc");
     String c1=request.getParameter("C1");
     String c2=request.getParameter("C2");
     String doc_serial="";
     Timestamp doc_date;
     String pos_id="";
     String doc_ids="";
     String month=request.getParameter("month");
     String year=request.getParameter("year");
     String day=request.getParameter("day");
     Timestamp date_on_doc=new Timestamp(0,0,0,0,0,0,0);
     ResultSet link=null;

     int dd=0,mm=0,yyyy=0;
     if (c2!=null){
     try{ //check date format
     dd=Integer.valueOf(day).intValue();
     mm=Integer.valueOf(month).intValue();
     yyyy=Integer.valueOf(year).intValue();
     } catch(NumberFormatException e){
     %> <h3> the date parameters are wrong, check it again</h3> <%
     }

    //check date for value errors
    if(!((dd>0)&&(dd<32)&&(mm<13)&&(mm>0)&&(yyyy<2050)&&(yyyy>1980))) {
     %><h3> error: date is invalid </h3><%
    }else{ //continue
    yyyy=yyyy-1900;  //we need to be compatibel with Timestamp date format
    mm=mm-1;
    date_on_doc=new Timestamp(yyyy,mm,dd,0,0,0,0);
    }}
   try{
     if(c1!=null){
        if(c2!=null){ //use date and num in search
           link=connector.executeQuery("SELECT serial,date FROM document WHERE date_on_doc='"+date_on_doc +"' AND num_on_doc='"+num_on_doc +"'"+
          " AND serial in (SELECT doc_serial FROM history WHERE from_pos="+userInfo.getPos_id()+" or to_pos="+userInfo.getPos_id()+")");
        }
        else{ //use number only
            link=connector.executeQuery("SELECT serial,date FROM document WHERE num_on_doc='"+num_on_doc +"'"+
            " AND serial in (SELECT doc_serial FROM history WHERE from_pos="+userInfo.getPos_id()+" or to_pos="+userInfo.getPos_id()+")");
        }
      }
      else{ //test date only
          if(c2!=null){
              yyyy=date_on_doc.getYear()+1900;
              mm=date_on_doc.getMonth()+1;
              dd=date_on_doc.getDate();
              link=connector.executeQuery("SELECT serial,date FROM document WHERE YEAR(date_on_doc)="+yyyy+"  AND MONTH(date_on_doc)="+mm+" AND DAY(date_on_doc)="+dd+
              " AND serial in (SELECT doc_serial FROM history WHERE from_pos="+userInfo.getPos_id()+" or to_pos="+userInfo.getPos_id()+")");
          }
      }

      while(link.next()){
        b=1;
        doc_serial=link.getString("serial");
        doc_date=link.getTimestamp("date");
        doc_ids=doc_serial+"*"+doc_date.getTime()+"*";%>
        <img border="0" src="images/11.gif" width="20" height="20">&nbsp;
        <a href="viewContent.jsp?doc_ids=<%= doc_ids %>"><b>message  at <%= doc_date %></b> </a><br>
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

