<%@ page contentType="text/html; charset=windows-1256" %>
<%@ include file="ConnectInclude.jsp" %>
<html>
<head>
<title>
workLoad
</title>
</head>
<body bgcolor="#eeeeee">

<br>
<table border="2" cellpadding="1" cellspacing="1">
  <tr>
    <td>position name</td>
    <td>number of incoming documents</td>
    <td>number of out going documnets </td>
  </tr>

<% // first the arriving documents
try{
  ResultSet workLoad=connector.executeQuery("SELECT COUNT(pos_id) FROM position");
  int count=0,i=0;
  if(workLoad.next()){
    count=workLoad.getInt(1);
  }
  workLoad=connector.executeQuery("SELECT pos_id,pos_name FROM position");
  String [][] pos=new String [count][2];
  while((workLoad.next())&&(i<count)){
    pos[i][0]=workLoad.getString("pos_id");
    pos[i][1]=workLoad.getString("pos_name");
    ++i;
  }
  i=0;
  while(i<count){
    %> <tr>
          <td> <%= pos[i][1] %> </td> <%
    workLoad=connector.executeQuery("SELECT count(from_pos) FROM history WHERE from_pos="+pos[i][0]);
    if(workLoad.next()){
       %> <td><%= workLoad.getString(1) %> </td> <%
    }
    workLoad=connector.executeQuery("SELECT count(to_pos) FROM history WHERE to_pos="+pos[i][0]);
    if(workLoad.next()){
       %> <td><%= workLoad.getString(1) %> </td> <%
    }
    %> <tr> <%
    ++i;
  }
  //out going documents number
}catch(SQLException e){ %> <%=e.toString() %> <% }
%>

</table>
</body>
</html>
