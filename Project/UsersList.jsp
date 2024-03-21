<%@ include file="ConnectInclude.jsp" %>
<html>
<head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>
a list of the system users
</title>
</head>
<body bgcolor="#eeeeee">

<% if(userInfo.getPos_id()<0){ //any one can't use any page without signing in, he may see the forms, but can't use them
   %> <jsp:forward page="error.htm" />
<%} %>

<br>
<table border="2" bordercolor="#808080">
  <tr>
      <td> user name </td>
      <td> account description </td>
      <td> start valid at </td>
      <td> end validation at </td>
<% ResultSet users=connector.executeQuery("SELECT count(pos_id) FROM users");
  int count=0,i=0;
  if(users.next()){ //get users count
    count=users.getInt(1);
  }

  users=connector.executeQuery("SELECT username,startDate,endDate,pos_id FROM users");
  String [][] u=new String[count][4]; //ResultSet is used only once, so we store value in
  //dynamic array then retore the vcalues
  while((users.next())&&(i<count)){
    u[i][0]=users.getString("username");
    u[i][1]=users.getString("startDate");
    u[i][2]=users.getString("endDate");
    u[i][3]=users.getString("pos_id");
    ++i;
  }

  i=0;
  while(i<count){
    String pos_id=u[i][3];
    users=connector.executeQuery("SELECT pos_name FROM position WHERE pos_id="+pos_id);
    if(users.next()){
       %> <tr>
          <td> <%= u[i][0] %> </td>
          <td> <%= users.getString("pos_name") %> </td>
          <td> <%= u[i][1] %> </td>
          <td> <%= u[i][2] %> </td>
       </tr>
      <%
    }
    ++i;

  }

  /*
  while(users.next()){
    %> <tr>
          <td> <%= users.getString("username") %> </td>
          <td> <%= users.getString("startDate") %> </td>
          <td> <%= users.getString("endDate") %> </td>
       </tr>
    <%
  }
  */
%>
</table>

</body>
</html>
