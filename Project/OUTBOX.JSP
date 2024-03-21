<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>

<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
outbox
</title>
</head>
<body bgcolor="#eeeeee"  link="#200000"  Vlink="#0000FF">
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
<h1 align="center"><font color="#800000" size="5"><i>Outbox</i></font></h1>
  <!-- -->
  <%
       int b=0;
       String doc_ids="";
       String doc_serial="";
       String to_pos="";
       String pos_name="";
       Timestamp doc_date=null;
       Timestamp note_date=null;

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
       ResultSet link=connector.executeQuery("SELECT to_pos,doc_serial,doc_date,note_date FROM history WHERE from_pos="+userInfo.getPos_id());
       while(link.next()){
        b=1;
        to_pos=link.getString("to_pos");
        doc_serial=link.getString("doc_serial");
        doc_date=link.getTimestamp("doc_date");
        note_date=link.getTimestamp("note_date");
        doc_ids=doc_serial+"*"+doc_date.getTime()+"*";
        int j=0;
        while (j<count){
          if (pos[j][0].equals(to_pos)){
           pos_name=pos[j][1];
           }
          j++;
        }  %>

        <img border="0" src="images/11.gif" width="20" height="20">&nbsp;
        <a href="viewContent.jsp?doc_ids=<%= doc_ids %>"> <b>message to <%= pos_name %> at <%= note_date %> </b></a><br>

    <%}
     if (b==0){%>
       <p> <b><font color="#666666" size="4"> there is no document </font></b></p>
     <%}
    }catch(SQLException e){%>
        <h2> SQL error:</h2> <%= e.toString() %>
  <% }} %>
<br><br><br><br>
<p align="right"><a href="homepage.jsp"><img border="0" src="images/60.jpg" width="72" height="29"></a></p>
<form method="POST" action="SignOut.jsp">
  <p>
  <input type="submit" value="sign out" name="signout"></p>
</form>
</body>
</html>

