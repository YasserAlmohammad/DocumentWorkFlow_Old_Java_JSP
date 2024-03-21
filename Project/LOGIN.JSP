<%@ include file="ConnectInclude.jsp" %>

<html>
<head>
<title>
login ensurance
</title>
</head>

<meta name="GENERATOR" content="Microsoft FrontPage 5.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<body bgcolor="#eeeeee">
<h1>
Testing user authentication
</h1>

<% String user=request.getParameter("username"),pass=request.getParameter("password");

  try{
      connector.connect("jdbc:odbc:project","","");
      ResultSet r=connector.executeQuery("SELECT pos_id,username,password,enddate,startdate FROM users WHERE username='"+user+"' AND password='"+pass+"'");
      if(r.next()){
         userInfo.setPos_id(r.getInt("pos_id"));
         Timestamp endDate=r.getTimestamp("enddate"); //check user have access any more
         Timestamp startDate=r.getTimestamp("startdate");
         Timestamp sysDate=new Timestamp(System.currentTimeMillis());
         if("admin".equals(user.toLowerCase())){ %>
            <jsp:forward page="administrator.htm" />
        <% }else{
                 if((endDate==null)||(endDate.after(sysDate))){ //make sure the user still valid
                    if(startDate.before(sysDate)){ // he starts after the current time
                      %> <jsp:forward page="homepage.jsp" />
                    <%}
                    else{
                        connector.disconnect();
                        userInfo.setPos_id(-1);%> you dont have access yet, you can access the system after <%= startDate %> <%
                    }
                 }
                 else{
                    connector.disconnect();
                    userInfo.setPos_id(-1); %> you don't have access anymore, contact Administartor for more information <%}
            }
      }else{
            connector.disconnect();%>
         <%=user %> you are invalid user, try a gain
<%  }
    }catch(Exception e){ %>
    <p> error </p> <%= e.getMessage() %>
<%}%>


</body>
</html>
